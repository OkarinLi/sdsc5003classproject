package com.cityu.sdsc5003classproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cityu.sdsc5003classproject.dao")
@SpringBootApplication
public class Sdsc5003classprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sdsc5003classprojectApplication.class, args);
    }

}
