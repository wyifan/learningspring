package com.yifan.demo;

import com.yifan.demo.service.TaskAsyncDemo;
import com.yifan.demo.service.TaskDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private TaskDemo taskDemo;

    @Autowired
    private TaskAsyncDemo taskAsyncDemo;

    @Test
    void task() throws Exception{
        taskDemo.doTaskOne();
        taskDemo.doTaskTwo();
        taskDemo.doTaskThree();
    }

    @Test
    void taskAsync() throws Exception{
        taskAsyncDemo.doTaskOne();
        taskAsyncDemo.doTaskTwo();
        taskAsyncDemo.doTaskThree();

        System.out.println("I'm here");
        TimeUnit.SECONDS.sleep(15);
        System.out.println("over");
    }

    @Test
    void contextLoads() {
    }

}
