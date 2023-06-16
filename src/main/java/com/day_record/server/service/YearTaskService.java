package com.day_record.server.service;

import com.day_record.server.bean.YearTaskBean;

import java.util.List;
import java.util.Map;

/**
 * @author JereChen
 */
public interface YearTaskService {

    List<YearTaskBean> getAllYearTasks();

    YearTaskBean getYearTaskById(Long id);

    List<YearTaskBean> getYearTaskByName(String taskName);

    YearTaskBean getYearTaskByMap(Map<String, String> conditionMap);

    void insertYearTask(YearTaskBean yearTaskBean);

    void updateYearTask(YearTaskBean yearTaskBean);

    void deleteYearTaskById(Long id);
}
