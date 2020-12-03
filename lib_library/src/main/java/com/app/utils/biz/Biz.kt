package com.app.utils.biz

import com.app.config.SharedConfigs
import com.blankj.utilcode.util.JsonUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SPUtils

/**
 * 状态记录业务类
 */
class Biz private constructor() {

    companion object {
        @JvmStatic
        val instance: Biz by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Biz()
        }
    }


    var userInfo: String
        get() = SPUtils.getInstance().getString(SharedConfigs.UserData.userInfo)
        set(userInfo) {
            SPUtils.getInstance().put(SharedConfigs.UserData.userInfo, userInfo, true)
        }

    var userTask: String
        get() = SPUtils.getInstance().getString(SharedConfigs.UserData.userTask)
        set(userTask) {
            SPUtils.getInstance().put(SharedConfigs.UserData.userTask, userTask, true)
        }

    var lastUserInfo: String
        get() = SPUtils.getInstance().getString(SharedConfigs.UserData.lastUserInfo)
        set(lastUserInfo) {
            SPUtils.getInstance().put(SharedConfigs.UserData.lastUserInfo, lastUserInfo, true)
        }

    fun token(): String {
        var tokenStr = ""
        val userInfoStr = userInfo
        if (userInfoStr.isNotEmpty()) {
            tokenStr = JsonUtils.getString(userInfoStr, "token", "")
        }
        return tokenStr
    }

    fun uid(): String {
        var uidStr = ""
        val userInfoStr = userInfo
        if (userInfoStr.isNotEmpty()) {
            uidStr = JsonUtils.getString(userInfoStr, "uid", "")
        }
        return uidStr
    }

    var military: String
        get() = SPUtils.getInstance().getString(SharedConfigs.UserData.military)
        set(military) {
            SPUtils.getInstance().put(SharedConfigs.UserData.military, military, true)
        }

}