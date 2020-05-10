package com.yifan.mybatisdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisdemoApplication {

    static Logger logger = LoggerFactory.getLogger(MybatisdemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MybatisdemoApplication.class, args);
    }

}