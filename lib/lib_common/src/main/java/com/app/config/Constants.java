package com.app.config;

import android.os.Environment;

public class Constants {

    public static final String SDPATH = Environment.getExternalStorageDirectory().getPath();
    public static final String DATABASE_NAME = "inspect_db.db";


    public static class MapType {
        public static final String navi = "navi";// 导航
        public static final String offline = "offline";// 离线
    }

    public static class PackageName {
        public static final String amap = "com.autonavi.minimap";// 高德
    }
}
