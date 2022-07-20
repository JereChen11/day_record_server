package com.day_record.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.day_record.server.mapper")
public class DayRecordServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DayRecordServerApplication.class, args);
    }

}
