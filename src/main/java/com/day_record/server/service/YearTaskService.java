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

    YearTaskBean getYearTaskByMap(Map<String, Object> conditionMap);

    /**
     * 插入Task.
     *
     * @param yearTaskBean 有客户端请求参数反序列化而来
     */
    void insertYearTask(YearTaskBean yearTaskBean);

    /**
     * 根据给定的条件插入Task。
     *
     * @param insertConditionMap 例如：[taskName=百词斩记单词, target=21]
     */
    void insertYearTaskByMap(Map<String, Object> insertConditionMap);

    void updateYearTask(YearTaskBean yearTaskBean);

    void deleteYearTaskById(Long id);
}
