package com.day_record.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author JereChen
 */
@Configuration
public class DatabaseInitConfig {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        // 项目启动初始化基本数据
        log.info("开始数据库初始化工作");
        //通过直接读取sql文件，执行其sql语句
        Resource sqlResources = new ClassPathResource("sql/schema.sql");
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScripts(sqlResources);
        resourceDatabasePopulator.execute(dataSource);
        log.info("结束数据库初始化工作");
    }


}
