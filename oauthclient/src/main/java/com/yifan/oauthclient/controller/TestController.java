package com.yifan.oauthclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @RequestMapping("/invoke")
    public String err403(HttpServletResponse response){
        response.setStatus(403);
        return "";
    }

    @RequestMapping("/test")
    public String test(){
        throw new RuntimeException("error in test");
    }
}
