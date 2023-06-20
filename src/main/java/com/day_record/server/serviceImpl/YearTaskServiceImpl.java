package com.day_record.server.serviceImpl;

import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.mapper.YearTaskMapper;
import com.day_record.server.service.YearTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author JereChen
 */
@Service
public class YearTaskServiceImpl implements YearTaskService {
    Logger logger = LoggerFactory.getLogger(getClass());

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
    public List<YearTaskBean> getYearTaskByName(String taskName) {
        return yearTaskMapper.getYearTaskByName(taskName);
    }

    @Override
    public YearTaskBean getYearTaskByMap(Map<String, Object> conditionMap) {
        return yearTaskMapper.getYearTaskByMap(conditionMap);
    }

    @Override
    public void insertYearTask(YearTaskBean yearTaskBean) {
        yearTaskMapper.insertYearTask(yearTaskBean);
    }

    @Override
    public void insertYearTaskByMap(Map<String, Object> insertConditionMap) {
        int target = Integer.parseInt(insertConditionMap.get("target").toString());
        int progress = 0;
        if (insertConditionMap.get("progress") != null) {
            progress = Integer.parseInt(insertConditionMap.get("progress").toString());
        }

        /*
        if (insertConditionMap.get("finishDate") != null) {
            try {
                finishDate = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(insertConditionMap.get("finishDate").toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
         */


        boolean isFinish = false;
        Date finishDate = null;
        if (progress >= target) {
            isFinish = true;
            finishDate = new Date();
        }

        YearTaskBean yearTaskBean = new YearTaskBean(null,
                insertConditionMap.get("taskName").toString(),
                target,
                progress,
                new Date(),
                finishDate,
                isFinish);

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
