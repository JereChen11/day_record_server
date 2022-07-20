package com.day_record.server.controller;

import com.day_record.server.bean.BaseBean;
import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.service.YearTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    YearTaskService yearTaskService;

    @GetMapping("/year/get_all_year_tasks")
    public BaseBean<List<YearTaskBean>> getAllYearTasks() {
        List<YearTaskBean> allYearTasks = yearTaskService.getAllYearTasks();
        return new BaseBean<>(200, allYearTasks, "success");
    }

    @GetMapping("/year/get_year_task_by_id")
    public BaseBean<YearTaskBean> getYearTaskById(@RequestParam("id") int id) {
        YearTaskBean yearTaskBean = yearTaskService.getYearTaskById(id);
        if (yearTaskBean != null) {
            return new BaseBean<YearTaskBean>(200, yearTaskBean, "success");
        } else {
            return new BaseBean<YearTaskBean>(303, null, "can't find the year task by this id");
        }
    }

    @GetMapping("/year/get_year_task_by_map")
    public BaseBean<YearTaskBean> getYearTaskByMap(@RequestParam Map<String, String> map) {
        System.out.println("taskName" + map.get("taskName"));
        System.out.println("createDate" + map.get("createDate"));
        YearTaskBean yearTaskBean = yearTaskService.getYearTaskByMap(map);
        if (yearTaskBean != null) {
            return new BaseBean<YearTaskBean>(200, yearTaskBean, "success");
        } else {
            return new BaseBean<YearTaskBean>(303, null, "can't find the year task");
        }
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

    @PostMapping("/year/delete_year_task_by_id")
    public BaseBean<String> deleteYearTaskById(@RequestParam("id") int id) {
        YearTaskBean yearTaskBean = yearTaskService.getYearTaskById(id);
        if (yearTaskBean != null) {
            yearTaskService.deleteYearTaskById(id);
            return new BaseBean<>("delete " + yearTaskBean.getTaskName() + " success");
        } else {
            return new BaseBean<>(303, null, "can't find the year task by this id");
        }
    }


}
