package com.sid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sid.mapper.*.*")
public class SidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidApplication.class, args);
    }

}
