package com.yifan.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TaskDemo.class})
public class TaskDemoTest {

    @Autowired
    TaskDemo taskDemo;

    @Test
    public void doTaskOne() throws Exception{
        taskDemo.doTaskOne();
    }

    @Test
    public void doTaskTwo() {
    }

    @Test
    public void doTaskThree() {
    }
}