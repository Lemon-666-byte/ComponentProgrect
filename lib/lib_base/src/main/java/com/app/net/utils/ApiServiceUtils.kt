package com.app.net.utils

import com.app.common.api.ApiLogin
import com.app.net.RetrofitClient


/**
 *
 */
object ApiServiceUtils {
    /**
     * 接口 地址
     *
     * @return 接口 地址
     */
    @JvmStatic
    val apiLogin: ApiLogin
        get() = RetrofitClient.instance.create(ApiLogin::class.java)
}