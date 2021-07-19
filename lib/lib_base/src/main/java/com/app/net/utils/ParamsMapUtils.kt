package com.app.net.utils

import androidx.collection.ArrayMap

/**
 * 公共参数
 */
object ParamsMapUtils {

    @JvmStatic
    val commonParams: ArrayMap<String, Any>
        get() {
            val params = ArrayMap<String, Any>()
//            params["versioncode"] = AppUtils.getAppVersionCode()
//            params["app_version"] = AppUtils.getAppVersionName()
//            params["app_channel"] = ChannelUtil.getChannel(Utils.getApp())
//            params["os_sdk"] = Build.VERSION.SDK_INT
//            params["os_version"] = Build.MODEL + "," + Build.VERSION.RELEASE
////            params["device_uuid"] = UidUtils.getDeviceId()
//            params["platform"] = 0
            return params
        }

}