package com.apple.pojo;

import java.util.Date;

public class Passage {
    private Integer id;

    private Integer typeId;

    private String userId;

    private Date pulishDate;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(Date pulishDate) {
        this.pulishDate = pulishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}