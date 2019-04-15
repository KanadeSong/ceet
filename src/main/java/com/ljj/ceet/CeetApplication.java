package com.ljj.ceet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan
@ComponentScan(basePackages = { "org.n3r.idworker"})
//@MapperScan("com.ljj.ceet.mapper")
public class CeetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeetApplication.class , args);
    }

}
