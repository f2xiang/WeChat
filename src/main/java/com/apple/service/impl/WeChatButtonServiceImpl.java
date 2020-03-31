package com.apple.service.impl;

import com.apple.button.*;
import com.apple.service.WeChatButtonService;
import com.apple.service.WeChatService;
import com.apple.utils.NetUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 20/3/27.
 */
@Service
public class WeChatButtonServiceImpl implements WeChatButtonService {

    private static final String BUTTON_QUERY =
            "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

    private static final String BUTTON_SAVE =
            "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";


    @Autowired
    private WeChatService weChatService;

    @Override
    public String findButton() {
        return  NetUtils.doGet(BUTTON_QUERY.replace("ACCESS_TOKEN",weChatService.getAccessToken()));
    }

    @Override
    public String saveButton() {
        return NetUtils.doPost(BUTTON_SAVE.replace("ACCESS_TOKEN",weChatService.getAccessToken()),createButtonData());
    }


    /**
     * 创建模拟的button数据
     * @return
     */
    private String createButtonData() {
        Map<String, Object> param = new HashMap<>();

        List<BaseButton> list = new ArrayList<>();
        param.put("button", list);

        list.add(new ClickButton("今日歌单","1"));
        list.add(new ViewButton("百度","http://www.baidu.com"));

        List<BaseButton> subButtons = new ArrayList<>();
        subButtons.add(new PhotoButton("选择图片","31"));
        subButtons.add(new ClickButton("子菜单2","32"));
        list.add(new Buttons("父菜单",subButtons));
        return new Gson().toJson(param);
    }



}
