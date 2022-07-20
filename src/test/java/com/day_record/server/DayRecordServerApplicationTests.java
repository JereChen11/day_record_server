package com.day_record.server;

import com.day_record.server.bean.YearTaskBean;
import com.day_record.server.service.YearTaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DayRecordServerApplicationTests {

    @Autowired
    YearTaskService yearTaskService;

    @Test
    void contextLoads() {

        /*
         * test insertYearTask
         */
//        YearTaskBean insertTask = new YearTaskBean(0, "hei ha", 221, 0, "2022-7-19", null, 0);
//        yearTaskService.insertYearTask(insertTask);


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
        yearTaskService.deleteYearTaskById(0);
    }

}
