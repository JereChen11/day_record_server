package com.day_record.server.mapper;

import com.day_record.server.bean.YearTaskBean;

import java.util.List;

public interface YearTaskMapper {

    List<YearTaskBean> getAllYearTasks();

//    @Query("SELECT * FROM yearTasks WHERE task LIKE :task")
//    suspend fun findYearTaskByName(task: String): YearTask

    YearTaskBean findYearTaskByname(String taskName);
//
//    @Insert
//    suspend fun insertAllYearTask(vararg yearTasks: YearTask)

//
//    @Insert
//    suspend fun insertYearTask(yearTask: YearTask)

    void insertYearTask(YearTaskBean yearTaskBean);
//
//    @Update
//    suspend fun updateYearTasks(vararg yearTasks: YearTask)

    void updateYearTask(YearTaskBean yearTaskBean);
//
//    @Delete
//    suspend fun deleteYearTasks(yearTask: YearTask)

//    void deleteYearTask(YearTaskBean yearTaskBean);
}
