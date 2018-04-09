package com.example.netty.decoder;

import java.io.Serializable;

/**
 * 序列化对象
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class Message implements Serializable{

    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
