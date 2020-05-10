package com.yifan.mybatisdemo.config;

import com.yifan.mybatisdemo.dao.entity.base.Messages;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;

@StepScope
public class MessageProcessor implements ItemProcessor<Messages, Messages> {
    @Override
    public Messages process(Messages messages) throws Exception {

        Messages msg = new Messages();
        short isSend = 1;
        BeanUtils.copyProperties(messages, msg);
        msg.setIsSend(isSend);

        System.out.println("Process msg: " + msg.getMessageTitle());

        return msg;
    }
}
