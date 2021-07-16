package com.app.config

import android.os.Environment

object Constants {
    val SDPATH = Environment.getExternalStorageDirectory().path

    object MapType {
        const val navi = "navi" // 导航
        const val offline = "offline" // 离线
    }

    object PackageName {
        const val amap = "com.autonavi.minimap" // 高德
    }
}