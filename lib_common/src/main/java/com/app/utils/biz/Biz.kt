package com.app.utils.biz

import com.app.config.MMkvConfigs
import com.app.utils.MMkvUtils

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
        get() = MMkvUtils.instance.getString(MMkvConfigs.UserData.uid)
        set(userInfo) {
            MMkvUtils.instance.putString(MMkvConfigs.UserData.uid, userInfo)
        }

    var token: String
        get() = MMkvUtils.instance.getString(MMkvConfigs.UserData.token)
        set(userTask) {
            MMkvUtils.instance.putString(MMkvConfigs.UserData.token, userTask)
        }

}