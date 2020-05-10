package com.yifan.mybatisdemo.config;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.dao.entity.base.MessagesExample;
import com.yifan.mybatisdemo.dto.messages.MessageModifyModel;
import com.yifan.mybatisdemo.service.base.MessagesService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class MessageWriter implements ItemWriter<Messages> {

    private final MessagesService messagesService;

    public MessageWriter(MessagesService messagesService){
        this.messagesService = messagesService;
    }

    @Override
    public void write(List<? extends Messages> list) throws Exception {
        System.out.println("Inside Writer:");
        for (Messages msg : list){
            MessageModifyModel modifiedModel = new MessageModifyModel();
            BeanUtils.copyProperties(msg, modifiedModel);
            modifiedModel.setUpdateBy("MailSendJob");
            messagesService.modify(modifiedModel);
        }
    }
}
