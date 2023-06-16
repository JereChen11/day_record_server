package com.day_record.server.controller;

import com.day_record.server.bean.BaseBean;
import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.service.YearTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author JereChen
 */
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
    public BaseBean<YearTaskBean> getYearTaskById(@RequestParam("id") Long id) {

        YearTaskBean yearTaskBean = null;
        String errorMsg = "can't find the year task by this id";
        try {
            yearTaskBean = yearTaskService.getYearTaskById(id);
        } catch (Exception exception) {
            //站在后端业务考虑，完全没必要将真正的异常信息抛出给客户端。
            errorMsg = exception.getMessage();
            System.out.println("getYearTaskById error: " + errorMsg);
        }

        if (yearTaskBean != null) {
            return new BaseBean<YearTaskBean>(200, yearTaskBean, "success");
        } else {
            return new BaseBean<YearTaskBean>(403, null, errorMsg);
        }
    }

    @GetMapping("/year/get_year_task_by_name")
    public BaseBean<List<YearTaskBean>> getYearTaskByName(@RequestParam("taskName") String taskName) {
        String msg = "success";
        if (!taskName.isBlank()) {
            return new BaseBean<>(200, yearTaskService.getYearTaskByName(taskName), msg);
        } else {
            msg = "params error";
            return new BaseBean<>(403, null, msg);
        }
    }

    @GetMapping("/year/get_year_task_by_map")
    public BaseBean<YearTaskBean> getYearTaskByMap(@RequestParam Map<String, String> map) {
        //todo 这里只是对 taskName 与 createData 进行了处理，那对其它条件没有适配吗？ 而且用的还是AND 用 OR 呢？需考虑
        //这里需要对客户端传过来的 request params 进行处理判断。
        System.out.println("taskName" + map.get("taskName"));
        System.out.println("createDate" + map.get("createDate"));
        if (map.get("taskName") == null || map.get("createDate") == null) {
            return new BaseBean<YearTaskBean>(403, null, "params error, please check params again.");
        }

        YearTaskBean yearTaskBean = yearTaskService.getYearTaskByMap(map);
        if (yearTaskBean != null) {
            return new BaseBean<YearTaskBean>(200, yearTaskBean, "success");
        } else {
            return new BaseBean<YearTaskBean>(403, null, "can't find this year task");
        }
    }


    @PostMapping("/year/insert_year_task")
    public BaseBean<String> insertYearTask(YearTaskBean yearTaskBean) {
        //todo 需要对新插入的数据进行校验
        String msg;
        System.out.println("insertYear Task -> " + yearTaskBean.toString());
        try {
            yearTaskService.insertYearTask(yearTaskBean);
            msg = "insert (" + yearTaskBean.getTaskName() + ") success";
        } catch (Exception exception) {
            msg = "insert (" + yearTaskBean.getTaskName() + ") error: " + exception.getCause().getMessage();
        }

        return new BaseBean<>(msg);
    }

    @PutMapping("/year/update_year_task")
    public BaseBean<String> updateYearTask(YearTaskBean yearTaskBean) {
        //todo how to check YearTaskBean???
        //todo use yearTaskBean.id to find the YearTaskBean on the database;then to update content.
        System.out.println("the params yearTaskBean is: " + yearTaskBean.toString());
        //todo updateYearTask 的时候，需要对finish date 进行处理呢。
        yearTaskService.updateYearTask(yearTaskBean);
        return new BaseBean<>("update " + yearTaskBean.getTaskName() + " success");
    }

    @DeleteMapping("/year/delete_year_task_by_id")
    public BaseBean<String> deleteYearTaskById(@RequestParam("id") Long id) {
        YearTaskBean yearTaskBean = yearTaskService.getYearTaskById(id);
        if (yearTaskBean != null) {
            yearTaskService.deleteYearTaskById(id);
            return new BaseBean<>("delete " + yearTaskBean.getTaskName() + " success");
        } else {
            return new BaseBean<>(303, null, "can't find the year task by this id");
        }
    }


}
