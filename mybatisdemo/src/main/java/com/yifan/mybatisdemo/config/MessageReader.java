package com.yifan.mybatisdemo.config;

import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.dao.entity.base.MessagesExample;
import com.yifan.mybatisdemo.dto.base.BaseModel;
import com.yifan.mybatisdemo.service.base.MessagesService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageReader  implements ItemReader<Messages>
{
    private List<Messages> list;
    private int count =0;

    private final MessagesService messagesService;

    public MessageReader(MessagesService messagesService){
        this.messagesService = messagesService;
        short isSend=0;
        MessagesExample filter = new MessagesExample();
        filter.createCriteria().andIsSendEqualTo(isSend);
        this.list = messagesService.getListByFilter(filter);
        this.count=0;
    }

    @Override
    public Messages read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < list.size()){
            return list.get(count++);
        }
        return  null;
    }
}
