package com.yifan.demo;

import com.yifan.demo.service.TaskAsyncDemo;
import com.yifan.demo.service.TaskDemo;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTestByJunit {

    @Autowired
    private TaskDemo taskDemo;

    @Autowired
    private TaskAsyncDemo taskAsyncDemo;

    @Test
    public void task() throws Exception{
        taskDemo.doTaskOne();
        taskDemo.doTaskTwo();
        taskDemo.doTaskThree();
    }

    @Test
    public void taskAsync() throws Exception{
        taskAsyncDemo.doTaskOne();
        taskAsyncDemo.doTaskTwo();
        taskAsyncDemo.doTaskThree();

        System.out.println("I'm here");
        TimeUnit.SECONDS.sleep(15);
        System.out.println("over");
    }
}
