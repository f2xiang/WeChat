package com.apple.Message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * 公众号开发自动回复文本消息类
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;


    public TextMessage(Map<String, String> requestMap, String content) {
        super(requestMap, "text");
        this.content = content;
    }




}
