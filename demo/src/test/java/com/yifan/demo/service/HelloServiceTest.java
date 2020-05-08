package com.yifan.demo.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={HelloService.class})
@TestPropertySource("/appTest.properties")
public class HelloServiceTest {
    @Value("${app.message}")
    private String message;

    @Autowired
    private HelloService helloService;

    @Test
    public void testHelloMessage() {

        String message = helloService.sayHello();
        assertThat(message, equalTo(message));
    }
}
