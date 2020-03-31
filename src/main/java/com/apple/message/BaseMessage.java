package com.apple.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * 公众号开发自动回复的基础类
 */
public class BaseMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;

    @XStreamAlias("FromUserName")
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private String createTime;

    @XStreamAlias("MsgType")
    private String msgType;

    public BaseMessage(Map<String,String> requestMap, String msgType) {
        this.toUserName = requestMap.get("FromUserName");
        this.fromUserName = requestMap.get("ToUserName");
        this.createTime = System.currentTimeMillis() / 1000 + "";
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
