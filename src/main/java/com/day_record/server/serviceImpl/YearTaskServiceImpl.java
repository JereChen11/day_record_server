package com.day_record.server.serviceImpl;

import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.mapper.YearTaskMapper;
import com.day_record.server.service.YearTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearTaskServiceImpl implements YearTaskService {

    @Autowired
    private YearTaskMapper yearTaskMapper;

    @Override
    public List<YearTaskBean> getAllUsers() {
        return yearTaskMapper.getAllYearTasks();
    }

    @Override
    public void insertYearTask(YearTaskBean yearTaskBean) {
        yearTaskMapper.insertYearTask(yearTaskBean);
    }

    @Override
    public void updateYearTask(YearTaskBean yearTaskBean) {
        yearTaskMapper.updateYearTask(yearTaskBean);
    }
}
