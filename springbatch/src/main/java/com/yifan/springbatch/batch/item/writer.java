package com.yifan.springbatch.batch.item;

import com.yifan.springbatch.model.User;
import com.yifan.springbatch.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class writer implements ItemWriter<User> {

    private UserRepository userRepository;

    public writer(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends User> list) throws Exception {
        System.out.printf("In writer");
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).setDept("wsfdept");
//        }

        for (User item : list){
            item.setDept("write change dept");
        }

        userRepository.saveAll(list);
    }
}
