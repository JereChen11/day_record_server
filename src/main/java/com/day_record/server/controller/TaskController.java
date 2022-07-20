package com.day_record.server.controller;

import com.day_record.server.bean.BaseBean;
import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.service.YearTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    YearTaskService yearTaskService;

    @GetMapping("/year/get_all_year_tasks")
    public BaseBean<List<YearTaskBean>> getAllYearTasks() {
        return new BaseBean<List<YearTaskBean>>(200, yearTaskService.getAllUsers(), System.currentTimeMillis(), "success");
    }

    @PostMapping("/year/insert_year_task")
    public BaseBean<String> insertYearTask(YearTaskBean yearTaskBean) {
        yearTaskService.insertYearTask(yearTaskBean);
        return new BaseBean<>("insert " + yearTaskBean.getTaskName() + " success");
    }

    @PostMapping("/year/update_year_task")
    public BaseBean<String> updateYearTask(YearTaskBean yearTaskBean) {
        yearTaskService.updateYearTask(yearTaskBean);
        return new BaseBean<>("update " + yearTaskBean.getTaskName() + " success");
    }




}
