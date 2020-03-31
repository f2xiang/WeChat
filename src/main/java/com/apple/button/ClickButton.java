package com.apple.button;

/**
 * 公众号开发自定义菜单——点击菜单
 */
public class ClickButton extends BaseButton {

    private String key;

    public ClickButton(String name, String key) {
        super(name, "click");
        this.key = key;
    }
}
