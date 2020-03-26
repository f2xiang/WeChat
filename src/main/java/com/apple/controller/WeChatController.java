package com.apple.controller;

import com.apple.service.WeChatService;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by apple on 20/3/15.
 * 公众号平台开发
 */
@RestController
@RequestMapping("/wx")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    @GetMapping("/get")
    private String get(String signature, String timestamp, String nonce, String echostr) {
        System.out.println("signature=" + signature);
        System.out.println("timestamp=" + timestamp);
        System.out.println("nonce=" + nonce);
        System.out.println("echostr=" + echostr);

        boolean isSuccess = weChatService.check(signature, timestamp, nonce);
        if (isSuccess) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }

        return echostr;
    }

//
// <xml>
//  <ToUserName><![CDATA[toUser]]></ToUserName>
//  <FromUserName><![CDATA[fromUser]]></FromUserName>
//  <CreateTime>1348831860</CreateTime>
//  <MsgType><![CDATA[text]]></MsgType>
//  <Content><![CDATA[this is a test]]></Content>
//  <MsgId>1234567890123456</MsgId>
//</xml>

    @PostMapping("/get")
    private String get(HttpServletRequest request) {
        Map<String, String> requestMap = weChatService.parse(request);
        System.out.println("requestMap=" + requestMap);

        String response = weChatService.getResponse(requestMap);
        System.out.println(response);

        return response;
    }


    @GetMapping("/access_token")
    private String getAccessToken() {
        return weChatService.getAccessToken();
    }
}