package com.app.net.interceptor

import com.app.base.BuildConfig
import com.blankj.utilcode.util.LogUtils
import okhttp3.*
import okio.Buffer
import java.io.EOFException
import java.io.IOException
import java.nio.charset.Charset

/**
 * @author
 * @date 2020
 */
class LoggingInterceptor() : Interceptor {
    //标记： 请求 - 响应 数据成对出现
    private var mRequestTag = 0

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        val request = chain.request()
        val startTime = System.nanoTime() //请求发起的时间
        if (mRequestTag >= MAX_REQUEST_TAG) {
            mRequestTag = 0
        }
        mRequestTag++
        val requestTag = mRequestTag
        if (BuildConfig.DEBUG) {
            val requestBody = request.body
            val hasRequestBody = requestBody != null
            val connection = chain.connection()
            val protocol = connection?.protocol() ?: Protocol.HTTP_1_1
            var requestStartMessage = "(" + requestTag + ") " + "--> " + request.method + ' ' + request.url + ' ' + protocol
            if (hasRequestBody) {
                requestStartMessage += " (" + requestBody!!.contentLength() + "-byte body)"
            }

            var bodyString = ""
            if (hasRequestBody && !bodyEncoded(request.headers)) {
                val buffer = Buffer()
                requestBody!!.writeTo(buffer)
                var charset = UTF8
                val contentType = requestBody.contentType()
                if (contentType != null) {
                    charset = contentType.charset(UTF8)
                }
                if (isPlaintext(buffer)) {
                    bodyString = buffer.readString(charset);
                }
            } else {
                bodyString = requestStartMessage
            }
            LogUtils.e("$requestTag url->${request.url} params->$bodyString")
        }
        val response = chain.proceed(request)
        val endTime = System.nanoTime() //收到响应的时间

        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        val responseBody = response.body
        if (BuildConfig.DEBUG) {
            val responseJson = printResultJson(responseBody)
            val responseCode = response.code
            val responseMsg = response.message
            val requestUrl = response.request.url.toString()
            LogUtils.e("$requestTag ${(endTime - startTime) / 1e6}ms $requestUrl ${decodeUnicode(responseJson)}")
        }
        return response
    }

    private fun bodyEncoded(headers: Headers): Boolean {
        val contentEncoding = headers["Content-Encoding"]
        return contentEncoding != null && !"identity".equals(contentEncoding, ignoreCase = true)
    }

    /**
     * 打印响应结果
     *
     * @return 解析后的响应结果
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun printResultJson(responseBody: ResponseBody?): String {
        val source = responseBody?.source()
        source?.request(Long.MAX_VALUE) // Buffer the entire body.
        val buffer = source?.buffer
        return buffer?.clone()?.readString(UTF8)!!
    }

    interface Logger {
        fun logUrl(url: String?)
        fun logResult(message: String?)
    }

    companion object {
        private val UTF8 = Charset.forName("UTF-8")
        private const val MAX_REQUEST_TAG = 9999

        /**
         * Returns true if the body in question probably contains human readable text. Uses a small sample
         * of code points to detect unicode control characters commonly used in binary file signatures.
         */
        fun isPlaintext(buffer: Buffer): Boolean {
            return try {
                val prefix = Buffer()
                val byteCount = if (buffer.size < 64) buffer.size else 64
                buffer.copyTo(prefix, 0, byteCount)
                for (i in 0..15) {
                    if (prefix.exhausted()) {
                        break
                    }
                    val codePoint = prefix.readUtf8CodePoint()
                    if (Character.isISOControl(codePoint) && !Character.isWhitespace(
                                    codePoint
                            )
                    ) {
                        return false
                    }
                }
                true
            } catch (e: EOFException) {
                false // Truncated UTF-8 sequence.
            }
        }

        /**
         * http 请求数据返回 json 中中文字符为 unicode 编码转汉字转码
         * @param theString
         * @return
         */
        fun decodeUnicode(theString: String): String? {
            var aChar: Char
            val len = theString.length
            val outBuffer = StringBuffer(len)
            var x = 0
            while (x < len) {
                aChar = theString[x++]
                if (aChar == '\\') {
                    aChar = theString[x++]
                    if (aChar == 'u') {
                        // Read the xxxx
                        var value = 0
                        for (i in 0..3) {
                            aChar = theString[x++]
                            value = when (aChar) {
                                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> (value shl 4) + aChar.toInt() - '0'.toInt()
                                'a', 'b', 'c', 'd', 'e', 'f' -> (value shl 4) + 10 + aChar.toInt() - 'a'.toInt()
                                'A', 'B', 'C', 'D', 'E', 'F' -> (value shl 4) + 10 + aChar.toInt() - 'A'.toInt()
                                else -> throw IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.")
                            }
                        }
                        outBuffer.append(value.toChar())
                    } else {
//                    when (aChar) {
//                        't' -> aChar = '\t'
//                        'r' -> aChar = '\r'
//                        'n' -> aChar = '\n'
//                        'f' -> aChar = '\f'
//                    }
                        outBuffer.append(aChar)
                    }
                } else outBuffer.append(aChar)
            }
            return outBuffer.toString()
        }
    }


}