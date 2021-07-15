package com.app.room.utils;

import android.content.Context;
import android.provider.SyncStateContract;

import androidx.room.Room;

import com.app.room.AppDatabase;
import com.blankj.utilcode.util.Utils;

/**
 * 数据库工具类
 */
public class DBUtils {
    public static final String DATABASE_NAME = "inspect.db";
    private AppDatabase appDatabase;
    private static volatile DBUtils instance;

    private DBUtils() {

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
            appDatabase = Room.databaseBuilder(Utils.getApp(), AppDatabase.class, DATABASE_NAME)
//                            .addMigrations(MIGRATION_1_2)
//                    INSTANCE = Room.databaseBuilder(Utils.getApp(), AppDatabase.class, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Constants.DATABASE_NAME)
                    .build();
        }
        return appDatabase;
    }

    /**
     * 添加表
     */
//    private static Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            String createSqlOfDog = "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `newsId` INTEGER NOT NULL)";
//            database.execSQL(RoomMigrationSqlHelper.addTable(VideoAd.class, createSqlOfDog));
//
//        }
//    };
    /**
     * 添加字段
     */
//    private static Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL(RoomMigrationSqlHelper.addTextColumn(Task.class, "delFile"));
//        }
//    };

}
