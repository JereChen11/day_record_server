package com.day_record.server;

import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.service.YearTaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class DayRecordServerApplicationTests {

    @Autowired
    YearTaskService yearTaskService;

    @Test
    void contextLoads() {

        Date createDate = new Date();
        try {
            createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-7-19");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
         * test insertYearTask
         */
        YearTaskBean insertTask = new YearTaskBean(102L, "练习羽毛球", 100, 5,
                createDate, null, false);

        yearTaskService.insertYearTask(insertTask);


        /*
         * test updateYearTask
         */
//        YearTaskBean updateTask =
//                new YearTaskBean(1, "hu haha",
//                        121, 0, "2022-7-19", null, 0);
//        System.out.println("update...");
//        yearTaskService.updateYearTask(updateTask);

        /**
         * delete year task by id
         */
//        yearTaskService.deleteYearTaskById(0);
    }

}
