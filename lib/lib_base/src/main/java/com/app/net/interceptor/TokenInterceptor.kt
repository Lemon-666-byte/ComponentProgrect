package com.app.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

/**
 * @author
 * @date 2020
 */
class TokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalResponse = chain.proceed(originalRequest)
        // 获取返回的数据字符串
        val responseBody = originalResponse.body
        if (responseBody != null) {
            val source = originalResponse.body!!.source()
            source.request(Int.MAX_VALUE.toLong())
            val buffer = source.buffer()
            val contentType = responseBody.contentType()
            val charset: Charset?
            charset = if (contentType == null) {
                StandardCharsets.UTF_8
            } else {
                contentType.charset()
            }
            if (charset != null) {
//                val bodyString = buffer.clone().readString(charset)
//                val baseBean = GsonUtils.fromJson(bodyString, BaseBean::class.java)
//                if (baseBean != null && baseBean.isSessionKeyFail) {
//                    ViewUtils.runOnUiThread {
//                        SessionKeyInvalidUtils.getInstance().showSessionKeyInvalidDialog()
//                    }
//                }
            }
        }
        return originalResponse
    }


}