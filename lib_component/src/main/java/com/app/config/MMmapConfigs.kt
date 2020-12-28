package com.app.config

/**
 * SharedPreferences 保存的key
 */
class MMmapConfigs {
    /**
     * 加密串
     */
    object Secret {
        const val SECRET_KEY = "secret_key"
    }

    /**
     * 用户信息 key
     */
    object UserData {
        const val userInfo = "userInfo"
        const val userTask = "userTask"
        const val military = "military"
        const val lastUserInfo = "lastUserInfo"
    }

    object AppConfig {
        const val channel = "channel"

    }
}