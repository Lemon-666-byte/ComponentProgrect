package com.app.room.utils;


import com.app.room.AppDatabase;

/**
 * 数据库工具类
 */
public class DBUtils {

    private AppDatabase appDatabase;
    private static volatile DBUtils instance;

    private DBUtils() {
        // create database
        appDatabase = AppDatabase.getInstance();
    }

    public static DBUtils getInstance() {
        if (instance == null) {
            synchronized (DBUtils.class) {
                if (instance == null) {
                    instance = new DBUtils();
                }
            }
        }
        return instance;
    }

    public AppDatabase getDB() {
        if (appDatabase == null) {
            appDatabase = AppDatabase.getInstance();
        }
        return appDatabase;
    }

}
