package com.yifan.springbatch.batch.item;

import com.yifan.springbatch.model.User;
import org.springframework.batch.item.ItemProcessor;

import java.util.Date;

public class process implements ItemProcessor<String, User> {
    int count = 5;

    @Override
    public User process(String s) throws Exception {
        User user = new User();
        user.setId(count++);
        user.setName(s);
        user.setSalary(13949);
        user.setTime(new Date());

        System.out.printf("process user ...");
        return user;
    }
}
