package com.yifan.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Value("${app.message}")
    private String message;

    public String sayHello() {
        return message;
    }
}
