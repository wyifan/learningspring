package com.yifan.demo;

import com.yifan.demo.bean.Zoo;
import com.yifan.demo.config.AppConfig;
import com.yifan.demo.foundation.annotations.OverrideDemo;
import com.yifan.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoApplication {
    @Autowired
    private HelloService helloService;

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        OverrideDemo demo = new OverrideDemo();
        demo.testOverride();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DemoApplication app = context.getBean(DemoApplication.class);
        app.run();

        context.close();
    }

    private void run(){
        logger.info("Inside the demo application.");
        logger.info(helloService.sayHello());
    }
}
