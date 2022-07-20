package com.day_record.server.service;

import com.day_record.server.bean.YearTaskBean;

import java.util.List;

public interface YearTaskService {

    List<YearTaskBean> getAllUsers();

    void insertYearTask(YearTaskBean yearTaskBean);

    void updateYearTask(YearTaskBean yearTaskBean);
}
