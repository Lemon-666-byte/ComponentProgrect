package com.app.common.utils.biz

import com.app.common.config.MMkvConfigs
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
        get() = MMkvUtils.getString(MMkvConfigs.User.uid)
        set(userInfo) {
            MMkvUtils.putString(MMkvConfigs.User.uid, userInfo)
        }

    var sessionid: String
        get() = MMkvUtils.getString(MMkvConfigs.User.sessionid)
        set(userTask) {
            MMkvUtils.putString(MMkvConfigs.User.sessionid, userTask)
        }

}