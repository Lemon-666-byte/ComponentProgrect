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

    var uid: String
        get() = SPUtils.getInstance().getString(MMkvConfigs.UserData.uid)
        set(userInfo) {
            SPUtils.getInstance().put(MMkvConfigs.UserData.uid, userInfo, true)
        }

    var token: String
        get() = SPUtils.getInstance().getString(MMkvConfigs.UserData.token)
        set(userTask) {
            SPUtils.getInstance().put(MMkvConfigs.UserData.token, userTask, true)
        }

}