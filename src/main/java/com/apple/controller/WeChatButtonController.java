package com.apple.controller;

import com.apple.service.WeChatButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by apple on 20/3/27.
 */
@RestController
@RequestMapping("/button")
public class WeChatButtonController  {

    @Autowired
    private WeChatButtonService weChatButtonService;

    @GetMapping("/save")
    private String save() {

        return weChatButtonService.saveButton();
    }

    @GetMapping("/query")
    private String query() {
        return weChatButtonService.findButton();
    }





}
