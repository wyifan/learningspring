package com.yifan.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.yifan.demo")
@PropertySource("application.properties")
public class AppConfig {
}
