package com.apple.template;

/**
 * 公众号模板实体对应
 *  "value":"2014年9月22日",
 *  "color":"#173177"
 */
public class KeyWord {
    private String value;
    private String color;


    public KeyWord(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
