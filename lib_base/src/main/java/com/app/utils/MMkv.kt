package com.app.utils

import com.tencent.mmkv.MMKV

/**
 * MMkv
 */
class MMkv private constructor() {

    companion object {
        @JvmStatic
        val instance: MMkv by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MMkv()
        }
    }

    fun putString(key: String, value: String) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun getString(key: String, defaultValue: String): String {
        return MMKV.defaultMMKV().decodeString(key, defaultValue)
    }

    fun getString(key: String): String {
        return MMKV.defaultMMKV().decodeString(key, "")
    }

    fun putInt(key: String, value: Int) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return MMKV.defaultMMKV().decodeInt(key, defaultValue)
    }

    fun getInt(key: String): Int {
        return MMKV.defaultMMKV().decodeInt(key, -1)
    }

    fun putBoolean(key: String, value: Boolean) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return MMKV.defaultMMKV().decodeBool(key, defaultValue)
    }

    fun getBoolean(key: String): Boolean {
        return MMKV.defaultMMKV().decodeBool(key, false)
    }
}