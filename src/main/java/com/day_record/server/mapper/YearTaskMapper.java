package com.day_record.server.mapper;

import com.day_record.server.bean.YearTaskBean;

import java.util.List;
import java.util.Map;

/**
 * @author JereChen
 */
public interface YearTaskMapper {

    /**
     * 查询所有 year task
     *
     * @return
     */
    List<YearTaskBean> getAllYearTasks();

    /**
     * 通过指定id来查询 year task
     *
     * @param id
     * @return
     */
    YearTaskBean getYearTaskById(Long id);

    /**
     * 通过指定taskName来查询 year task
     *
     * @param taskName
     * @return
     */
    List<YearTaskBean> getYearTaskByName(String taskName);

    /**
     * 根据指定条件来查询 year task，例如：使用 taskName 与 createDate 来查询
     *
     * @param conditionMap
     * @return
     */
    YearTaskBean getYearTaskByMap(Map<String, String> conditionMap);

    /**
     * 插入指定 year task
     *
     * @param yearTaskBean
     */
    void insertYearTask(YearTaskBean yearTaskBean);

    /**
     * 更新 year task
     *
     * @param yearTaskBean
     */
    void updateYearTask(YearTaskBean yearTaskBean);

    /**
     * 通过 id 来删除指定 year task
     *
     * @param id
     */
    void deleteYearTaskById(Long id);
}
