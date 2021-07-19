package com.app.utils

import com.tencent.mmkv.MMKV

/**
 * MMkv
 */
class MMkvUtils private constructor() {

    companion object {

        @JvmStatic
        fun putString(key: String, value: String) {
            MMKV.defaultMMKV()?.encode(key, value)
        }

        @JvmStatic
        fun getString(key: String, defaultValue: String): String {
            return MMKV.defaultMMKV()?.decodeString(key, defaultValue) ?: defaultValue
        }

        @JvmStatic
        fun getString(key: String): String {
            return getString(key, "")
        }

        @JvmStatic
        fun putInt(key: String, value: Int) {
            MMKV.defaultMMKV()?.encode(key, value)
        }

        @JvmStatic
        fun getInt(key: String, defaultValue: Int): Int {
            return MMKV.defaultMMKV()?.decodeInt(key, defaultValue) ?: defaultValue
        }

        @JvmStatic
        fun getInt(key: String): Int {
            return getInt(key, -1)
        }

        @JvmStatic
        fun putBoolean(key: String, value: Boolean) {
            MMKV.defaultMMKV()?.encode(key, value)
        }

        @JvmStatic
        fun getBoolean(key: String, defaultValue: Boolean): Boolean {
            return MMKV.defaultMMKV()?.decodeBool(key, defaultValue) ?: false
        }

        @JvmStatic
        fun getBoolean(key: String): Boolean {
            return getBoolean(key, false)
        }
    }


}