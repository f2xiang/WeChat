package com.apple.button;


import java.util.List;

/**
 * Created by apple on 20/3/31.
 */
public class Buttons extends BaseButton {


    private List<BaseButton> sub_button;

    public Buttons(String name, List<BaseButton> list) {
        super(name);
        this.sub_button = list;
    }


    public List<BaseButton> getList() {
        return sub_button;
    }

    public void setList(List<BaseButton> list) {
        this.sub_button = list;
    }
}
