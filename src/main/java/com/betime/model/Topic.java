package com.betime.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WINDOWS 7 on 20/7/2558.
 */
public class Topic {

    private Integer id;
    private String topic;
    private String content;
    private String name;
    private List<Reply> replieList = new ArrayList<Reply>();

    public List<Reply> getReplieList() {
        return replieList;
    }

    public void setReplieList(List<Reply> replieList) {
        this.replieList = replieList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
