package com.apple.button;

/**
 * 拍照或者相册发图 按钮
 */
public class PhotoButton extends BaseButton {

    private String key;

    public PhotoButton(String name, String key) {
        super(name, "pic_photo_or_album");
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
