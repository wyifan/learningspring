package com.yifan.springbatch.batch;

import com.yifan.springbatch.model.User;
import com.yifan.springbatch.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> list) throws Exception {
        System.out.println("Data Saved for Users:" + list);

        userRepository.saveAll(list);
    }
}
