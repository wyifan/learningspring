package com.yifan.mybatisdemo.dto.messages;

import com.yifan.mybatisdemo.dto.base.BaseRowModel;

import java.util.Date;

public class MessageListModel extends BaseRowModel {
    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Short getMessageType() {
        return messageType;
    }

    public void setMessageType(Short messageType) {
        this.messageType = messageType;
    }

    public String getMessageTo() {
        return messageTo;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Short getIsSend() {
        return isSend;
    }

    public void setIsSend(Short isSend) {
        this.isSend = isSend;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    private String messageCode;
    private Short messageType;
    private String messageTo;
    private String messageTitle;
    private String messageContent;
    private Short isSend;
    private Date sendTime;

}
