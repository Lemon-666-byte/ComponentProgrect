package com.app.room.utils;

import android.content.Context;
import android.provider.SyncStateContract;

import androidx.room.Room;

import com.app.room.AppDatabase;

/**
 * 数据库工具类
 */
public class DBUtils {

    private AppDatabase appDatabase;
    private static volatile DBUtils instance;
    private Context context;
    private String dbName;

    private DBUtils() {

    }

    public void init(Context context, String dbName) {
        this.context = context.getApplicationContext();
        this.dbName = dbName;
        // create database
        appDatabase = getDB();
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
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, dbName)
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
