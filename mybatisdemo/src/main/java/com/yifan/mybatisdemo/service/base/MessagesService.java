/**
 * Copyright © 2019 DJI All Rights Reserved.
 * 2020-05-09 Created
 */
package com.yifan.mybatisdemo.service.base;

import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.dao.entity.base.MessagesExample;
import com.yifan.mybatisdemo.dto.messages.MessageAddModel;
import com.yifan.mybatisdemo.dto.messages.MessageListModel;
import com.yifan.mybatisdemo.dto.messages.MessageModifyModel;
import com.yifan.mybatisdemo.service.impl.base.BaseServiceImpl;

import java.util.List;

public interface MessagesService extends BaseService<Messages,
        MessageListModel,
        MessagesExample,
        MessageModifyModel,
        MessageAddModel,
        MessageModifyModel> {

    List<Messages> listJob(Short messageType);
}