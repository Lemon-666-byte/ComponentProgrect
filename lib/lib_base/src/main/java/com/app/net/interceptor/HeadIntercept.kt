package com.app.net.interceptor

import com.app.base.BuildConfig
import com.app.common.utils.biz.Biz
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.Buffer
import java.io.IOException

class HeadIntercept : Interceptor {
    private fun bodyToString(request: RequestBody): String {
        return try {
            val buffer = Buffer()
            request.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.let {
            var request = it.request()
            val stringBody = request.body?.apply { bodyToString(this).toRequestBody("application/json;charset=utf-8".toMediaType()) }
            val requestBuilder = request.newBuilder()
            stringBody?.let { body ->
                requestBuilder.addHeader("Content-Type", "application/json;charset=UTF-8")
//                        .addHeader("ms", getComonUriParms())
//                        .addHeader("cv", AppTools.getVersionName())
                        .addHeader("referer", BuildConfig.HOST)
                        .addHeader("token", Biz.instance.sessionid)
                        .addHeader("uid", Biz.instance.uid)
                        .post(body)
            }
//            LogUtils.e("instance->" + Biz.instance.token())
//            LogUtils.e("instance->" + Biz.instance.uid())
            it.proceed(requestBuilder.build())
        }
    }

//    /**
//     * 获取公共的参数
//     *
//     * @return
//     */
//    fun getComonUriParms(): String {
//        var comonUriParms = ""
//        if (TextUtils.isEmpty(comonUriParms)) {
//            comonUriParms = ("1#" + AppTools.getVersionName()
//                    + "#" + AppTools.getVersionCode()
//                    + "#" + ChannelUtil.getChannel()
//                    + "#" + NetUtils.getNetworkType()
//                    + "#" + AppTools.getPhoneManufacturer()
//                    + "#" + AppTools.getIMEI())
//            comonUriParms = StringUtils.getBase64(comonUriParms).trim { it <= ' ' }
//        }
//        return comonUriParms
//    }

    /**
     *
     *  head.put("ms", getComonUriParms());//接口公共的参数
    head.put("cv", AppTools.getVersionName());//接口识别码
    head.put("referer", URIContant.REALMNAME);//接口域名
    if (UserInforManager.getInstance().getUserInfor() != null
    && !TextUtils.isEmpty(UserInforManager.getInstance().getUserInfor().getToken())) {
    head.put("token", UserInforManager.getInstance().getUserInfor().getToken());
    head.put("uid", UserInforManager.getInstance().getUserInfor().getUid());
    }
     */


}