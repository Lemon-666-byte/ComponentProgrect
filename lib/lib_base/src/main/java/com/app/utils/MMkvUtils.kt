package com.app.utils

import com.tencent.mmkv.MMKV

/**
 * MMkv
 */
class MMkvUtils private constructor() {

    companion object {
        @JvmStatic
        val instance: MMkvUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MMkvUtils()
        }
    }

    fun putString(key: String, value: String) {
        MMKV.defaultMMKV()?.encode(key, value)
    }

    fun getString(key: String, defaultValue: String): String {
        return MMKV.defaultMMKV()?.decodeString(key, defaultValue) ?: defaultValue
    }

    fun getString(key: String): String {
        return getString(key,"")
    }

    fun putInt(key: String, value: Int) {
        MMKV.defaultMMKV()?.encode(key, value)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return MMKV.defaultMMKV()?.decodeInt(key, defaultValue) ?: defaultValue
    }

    fun getInt(key: String): Int {
        return getInt(key,-1)
    }

    fun putBoolean(key: String, value: Boolean) {
        MMKV.defaultMMKV()?.encode(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return MMKV.defaultMMKV()?.decodeBool(key, defaultValue) ?: false
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key,false)
    }
}