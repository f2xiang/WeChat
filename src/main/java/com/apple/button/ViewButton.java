package com.apple.button;

/**
 * 公众号开发自定义菜单——查看菜单
 */
public class ViewButton extends BaseButton {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ViewButton(String name, String url) {
        super(name, "view");
        this.url = url;
    }
}
