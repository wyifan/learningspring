package com.yifan.springbatch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "message", schema = "public")
public class Message {
    @Id
    private Integer id;
    private String content;
    private String data;
    private Date time;

    public Message() {
    }

    public Message(Integer id, String content, String data, Date time){
        this.id = id;
        this.content = content;
        this.data = data;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
