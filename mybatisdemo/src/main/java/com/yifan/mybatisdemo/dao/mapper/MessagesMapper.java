/**
 * Copyright © 2019 DJI All Rights Reserved. 
 * 2020-05-09 Created
 * 
 */
package com.yifan.mybatisdemo.dao.mapper;

import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.dao.entity.base.MessagesExample;
import com.yifan.mybatisdemo.dao.mapper.base.BaseMapper;
import com.yifan.mybatisdemo.dao.mapper.base.MessagesBaseMapper;
import com.yifan.mybatisdemo.dto.messages.MessageListModel;
import com.yifan.mybatisdemo.dto.messages.MessageModifyModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessagesMapper extends BaseMapper<Messages, MessageListModel,
        MessagesExample, MessageModifyModel> {

    List<Messages> listJob(Short messageType);
}