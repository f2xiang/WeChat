package com.apple.controller;

import com.apple.service.WeChatTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公众号开发之模板消息
 */

@RestController
@RequestMapping("/template")
public class WeChatTemplateController {

    @Autowired
    private WeChatTemplateService weChatTemplateService;

    @GetMapping("/industry/set")
    private String setIndustry() {
        return weChatTemplateService.setIndustry();
    }

    @GetMapping("/industry")
    private String getIndustry() {
        return weChatTemplateService.getIndustry();
    }


    @GetMapping("/send")
    private String send() {
        return weChatTemplateService.sendTemplate();
    }



}
