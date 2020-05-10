/**
 * Copyright © 2019 DJI All Rights Reserved.
 * 2020-05-09 Created
 */
package com.yifan.mybatisdemo.service.impl.base;


import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.dao.entity.base.MessagesExample;
import com.yifan.mybatisdemo.dao.mapper.MessagesMapper;
import com.yifan.mybatisdemo.dao.mapper.base.BaseMapper;
import com.yifan.mybatisdemo.dto.messages.MessageAddModel;
import com.yifan.mybatisdemo.dto.messages.MessageListModel;
import com.yifan.mybatisdemo.dto.messages.MessageModifyModel;
import com.yifan.mybatisdemo.service.base.MessagesService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl
        extends BaseServiceImpl<Messages,
        MessageListModel,
        MessagesExample,
        MessageModifyModel,
        MessageAddModel,
        MessageModifyModel>
        implements MessagesService {
    @javax.annotation.Resource
    MessagesMapper messagesMapper;

    @Override
    public BaseMapper<Messages, MessageListModel, MessagesExample, MessageModifyModel> getMapper() {
        return messagesMapper;
    }

    @Override
    public Messages getInsertEntity(MessageAddModel messageAddModel) {
        Messages entity = new Messages();
        BeanUtils.copyProperties(messageAddModel, entity);

        return entity;
    }

    @Override
    public Messages getUpdateEntity(MessageModifyModel messageModifyModel) {
        Messages entity = new Messages();
        BeanUtils.copyProperties(messageModifyModel, entity);

        return entity;
    }


    @Override
    public List<Messages> listJob(Short messageType) {
        return messagesMapper.listJob(messageType);
    }
}