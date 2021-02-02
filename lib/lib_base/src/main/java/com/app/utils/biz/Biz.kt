package com.app.utils.biz

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
        get() = MMkvUtils.instance.getString(UserConfigs.uid)
        set(userInfo) {
            MMkvUtils.instance.putString(UserConfigs.uid, userInfo)
        }

    var token: String
        get() = MMkvUtils.instance.getString(UserConfigs.token)
        set(userTask) {
            MMkvUtils.instance.putString(UserConfigs.token, userTask)
        }

}