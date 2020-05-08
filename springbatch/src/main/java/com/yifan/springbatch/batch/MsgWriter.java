package com.yifan.springbatch.batch;

import com.yifan.springbatch.model.Message;
import com.yifan.springbatch.repository.MessageRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MsgWriter implements ItemWriter<Message> {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void write(List<? extends Message> list) throws Exception {
        messageRepository.saveAll(list);
    }
}
