/**
 * Copyright © 2019 DJI All Rights Reserved.
 * 2020-05-09 Created
 */
package com.yifan.mybatisdemo.controller;

import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.dao.entity.base.MessagesExample;
import com.yifan.mybatisdemo.dto.messages.MessageAddModel;
import com.yifan.mybatisdemo.dto.messages.MessageListModel;
import com.yifan.mybatisdemo.dto.messages.MessageModifyModel;
import com.yifan.mybatisdemo.service.base.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    private final MessagesService messagesService;

    @Autowired
    MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping
    public MessageAddModel add(@RequestBody MessageAddModel messages) {
        messagesService.add(messages);
        return messages;
    }

    @GetMapping("/{id}")
    public Messages findById(@PathVariable String id) {
        return messagesService.findById(id);
    }

    @GetMapping("/all")
    public List<Messages> listJob() {
        Short messageType = 0;
        return messagesService.listJob(messageType);
    }


//    @GetMapping
//    public Result<PageResp<MessageListModel>> query(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size) {
//        MessagesExample example = new MessagesExample();
//        // 添加查询条件
//        example.createCriteria();
//        return messagesService.queryPage(page ,size, example);
//    }
//
//    @PatchMapping
//    public Result<MessageModifyModel> modify(@RequestBody MessageModifyModel messages) {
//        messagesService.modify(messages);
//        return Result.success(messages);
//    }
//
//    @DeleteMapping("/{id}")
//    public Result remove(@PathVariable String id) {
//        messagesService.remove(id);
//        return Result.success();
//    }
}