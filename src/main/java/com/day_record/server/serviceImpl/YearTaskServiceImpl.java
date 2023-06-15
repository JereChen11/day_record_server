package com.day_record.server.serviceImpl;

import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.mapper.YearTaskMapper;
import com.day_record.server.service.YearTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author JereChen
 */
@Service
public class YearTaskServiceImpl implements YearTaskService {

    @Autowired
    private YearTaskMapper yearTaskMapper;

    @Override
    public List<YearTaskBean> getAllYearTasks() {
        return yearTaskMapper.getAllYearTasks();
    }

    @Override
    public YearTaskBean getYearTaskById(Long id) {
        return yearTaskMapper.getYearTaskById(id);
    }

    @Override
    public YearTaskBean getYearTaskByMap(Map<String, String> conditionMap) {
        return yearTaskMapper.getYearTaskByMap(conditionMap);
    }

    @Override
    public void insertYearTask(YearTaskBean yearTaskBean) {
        yearTaskMapper.insertYearTask(yearTaskBean);
    }

    @Override
    public void updateYearTask(YearTaskBean yearTaskBean) {
        yearTaskMapper.updateYearTask(yearTaskBean);
    }

    @Override
    public void deleteYearTaskById(Long id) {
        yearTaskMapper.deleteYearTaskById(id);
    }
}
