package com.yifan.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskAsyncDemoTest {

    @Autowired
    TaskAsyncDemo taskAsyncDemo;

    @Test
    public void doTaskOne() throws Exception{
        taskAsyncDemo.doTaskOne();
    }

    @Test
    public void doTaskTwo() {
    }

    @Test
    public void doTaskThree() {
    }
}