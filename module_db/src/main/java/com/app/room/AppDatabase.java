package com.app.room;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.app.config.Constants;
import com.blankj.utilcode.util.Utils;
import com.cantwell.inspect.room.bean.Task;
import com.cantwell.inspect.room.dao.TaskDao;
import com.cantwell.inspect.room.utils.RoomMigrationSqlHelper;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract TaskDao taskDao();

    public static AppDatabase getInstance() {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(Utils.getApp(), AppDatabase.class, Constants.DATABASE_NAME)
//                            .addMigrations(MIGRATION_1_2)
//                    INSTANCE = Room.databaseBuilder(Utils.getApp(), AppDatabase.class, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Constants.DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
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