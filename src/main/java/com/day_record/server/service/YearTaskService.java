package com.day_record.server.service;

import com.day_record.server.bean.YearTaskBean;

import java.util.List;
import java.util.Map;

/**
 * @author JereChen
 */
public interface YearTaskService {

    /**
     * 获取所有的任务
     *
     * @return
     */
    List<YearTaskBean> getAllYearTasks();

    /**
     * 通过ID获取指定的任务
     *
     * @param id
     * @return
     */
    YearTaskBean getYearTaskById(Long id);

    /**
     * 通过打卡任务名来获取指定的任务列表
     *
     * @param taskName
     * @return
     */
    List<YearTaskBean> getYearTaskByName(String taskName);

    /**
     * 通过指定的条件来获取相对应的任务
     *
     * @param conditionMap
     * @return
     */
    YearTaskBean getYearTaskByMap(Map<String, Object> conditionMap);

    /**
     * 添加任务
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

    /**
     * 更新任务
     *
     * @param yearTaskBean
     */
    void updateYearTask(YearTaskBean yearTaskBean);

    /**
     * 通过ID删除指定任务
     *
     * @param id
     */
    void deleteYearTaskById(Long id);
}
