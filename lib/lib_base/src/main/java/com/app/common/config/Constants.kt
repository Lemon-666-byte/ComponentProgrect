package com.app.common.config

import android.os.Environment

object Constants {
    val SDPATH = Environment.getExternalStorageDirectory().path

    object Regex {
        var url = ("(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)") //设置正则表达式

    } object BaseUrl {
        const val tldz = "rtmp://20.64.26.29:11935/live" //
    }

    object MapType {
        const val navi = "navi" // 导航
        const val offline = "offline" // 离线
    }

    object PackageName {
        const val amap = "com.autonavi.minimap" // 高德
    }
}