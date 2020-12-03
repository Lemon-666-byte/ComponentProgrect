package com.app.utils.biz

import com.app.config.MMkvConfigs
import com.blankj.utilcode.util.JsonUtils
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
        get() = SPUtils.getInstance().getString(MMkvConfigs.UserData.userInfo)
        set(userInfo) {
            SPUtils.getInstance().put(MMkvConfigs.UserData.userInfo, userInfo, true)
        }

    var userTask: String
        get() = SPUtils.getInstance().getString(MMkvConfigs.UserData.userTask)
        set(userTask) {
            SPUtils.getInstance().put(MMkvConfigs.UserData.userTask, userTask, true)
        }

    var lastUserInfo: String
        get() = SPUtils.getInstance().getString(MMkvConfigs.UserData.lastUserInfo)
        set(lastUserInfo) {
            SPUtils.getInstance().put(MMkvConfigs.UserData.lastUserInfo, lastUserInfo, true)
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
        get() = SPUtils.getInstance().getString(MMkvConfigs.UserData.military)
        set(military) {
            SPUtils.getInstance().put(MMkvConfigs.UserData.military, military, true)
        }

}