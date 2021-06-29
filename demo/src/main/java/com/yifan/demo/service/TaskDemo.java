package com.yifan.demo.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TaskDemo {
    static Random random = new Random();

    // 任务一;
        public void doTaskOne() throws Exception {
            System.out.println("开始做任务一");
            long start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(10000));
            long end = System.currentTimeMillis();
            System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        }

        // 任务二;
        public void doTaskTwo() throws Exception {
            System.out.println("开始做任务二");
            long start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(10000));
            long end = System.currentTimeMillis();
            System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        }

        // 任务3;
        public void doTaskThree() throws Exception {
            System.out.println("开始做任务三");
            long start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(10000));
            long end = System.currentTimeMillis();
            System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        }

}
