package com.yifan.springbatch.batch;

import com.yifan.springbatch.model.Message;
import com.yifan.springbatch.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MsgProcessor implements ItemProcessor<User, Message> {
    @Override
    public Message process(User user) throws Exception {

        String content = user.getName() + user.getDept();
        String salary = "Salary:" + user.getSalary().toString();

        Message message = new Message(user.getId(), content, salary, new Date());

        return message;
    }
}
