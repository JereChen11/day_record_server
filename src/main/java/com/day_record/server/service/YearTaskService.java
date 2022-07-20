package com.day_record.server.service;

import com.day_record.server.bean.YearTaskBean;

import java.util.List;
import java.util.Map;

public interface YearTaskService {

    List<YearTaskBean> getAllYearTasks();

    YearTaskBean getYearTaskById(int id);

    YearTaskBean getYearTaskByMap(Map<String, String> conditionMap);

    void insertYearTask(YearTaskBean yearTaskBean);

    void updateYearTask(YearTaskBean yearTaskBean);

    void deleteYearTaskById(int id);
}
