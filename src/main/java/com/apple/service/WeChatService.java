package com.apple.service;


import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;

/**
 * 微信公众号业务
 */

public interface WeChatService {

//    开发者通过检验signature对请求进行校验（下面有校验方式）。
//    若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
//    加密/校验流程如下：
//
//    1）将token、timestamp、nonce三个参数进行字典序排序 2）将三个参数字符串拼接成一个字符串进行sha1加密
//    3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

    boolean check(String signature, String timestamp, String nonce);


    Map<String, String> parse(HttpServletRequest request);


    String getResponse(Map<String, String> requestMap);

    String getAccessToken();
}
