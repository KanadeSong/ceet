package com.ljj.ceet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "org.n3r.idworker"})
//@MapperScan("com.ljj.ceet.mapper")
public class CeetApplication {

    //private static final Logger logger = LoggerFactory.getLogger(CeetApplication.class);
    private static final Logger logger = LoggerFactory.getLogger(CeetApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CeetApplication.class , args);
        //logger.info("人事管理系统启动");
    }

}
