package com.app.room.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.app.room.bean.Task;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface TaskDao {

    /**
     * 插入一条数据
     *
     * @param task
     */
    @Insert
    void insert(Task task);

    /**
     * 根据用户名查询所有离线数据
     *
     * @param userName
     */
    @Query("SELECT * FROM task WHERE userName = :userName")
    Maybe<List<Task>> getTaskList(String userName);

    /**
     * 更新
     */
    @Update()
    Maybe<Integer> updateTask(Task task);

    @Query("DELETE FROM task WHERE taskId = :taskId")
    void delete(String taskId);

    @Query("SELECT * FROM task WHERE userName = :userName AND taskId = :taskId")
    Maybe<Task> getTask(String userName, String taskId);
}
