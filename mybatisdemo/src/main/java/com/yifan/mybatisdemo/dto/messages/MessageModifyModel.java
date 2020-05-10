package com.yifan.mybatisdemo.dto.messages;

import com.yifan.mybatisdemo.dto.base.BaseModel;
import com.yifan.mybatisdemo.dto.base.BaseRowModel;

public class MessageModifyModel extends BaseRowModel {

    public Short getIsSend() {
        return isSend;
    }

    public void setIsSend(Short isSend) {
        this.isSend = isSend;
    }

    private Short isSend;

}
