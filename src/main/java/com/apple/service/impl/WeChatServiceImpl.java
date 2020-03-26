package com.apple.service.impl;

import com.apple.Message.TextMessage;
import com.apple.common.AccessToken;
import com.apple.service.WeChatService;
import com.apple.utils.NetUtils;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信公众号业务
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    private static final String TOKEN = "token";
    private static final String APPID = "wx2756a360a672f728";
    private static final String APPSECRET = "da66cd245a91235aa5335b26ea15a0bd";
    private static final String WECHAT_ACCESS_TOKEN_URL
            = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";



    private AccessToken accessToken;





    //    1）将token、timestamp、nonce三个参数进行字典序排序 2）将三个参数字符串拼接成一个字符串进行sha1加密
    //    3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
    @Override
    public boolean check(String signature, String timestamp, String nonce) {
        boolean isSuccess = true;

//       1）将token、timestamp、nonce三个参数进行字典序排序
        String [] arr = new String [] {TOKEN, timestamp, nonce};
        Arrays.sort(arr);

//       2）将三个参数字符串拼接成一个字符串进行sha1加密
        String mdResult = getMdAh1Result(arr[0] + arr[1] + arr[2]);

//       3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

        return signature.endsWith(mdResult);
    }


    //解析XML =》 Map
    @Override
    public Map<String, String> parse(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(request.getInputStream());
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    //回复消息模板
// <xml>
//  <ToUserName><![CDATA[toUser]]></ToUserName>
//  <FromUserName><![CDATA[fromUser]]></FromUserName>
//  <CreateTime>12345678</CreateTime>
//  <MsgType><![CDATA[text]]></MsgType>
//  <Content><![CDATA[你好]]></Content>
//</xml>
    @Override
    public String getResponse(Map<String, String> requestMap) {
        String type = requestMap.get("MsgType");

        String responseXml = "";
        switch (type) {
            case "text":
                responseXml = dealTextMessage(requestMap);
                break;
            case "image":
                break;
            case "voice":
                break;
            case "video":
                break;
            case "music":
                break;
            case "news":
                break;
        }
        return responseXml;
    }


    /**
     * 获取accesstoken
     * @return accesstoken
     */
    @Override
    public String getAccessToken() {
        if (accessToken == null || accessToken.isExpires()) {
            String accessTokenStr = NetUtils
                    .doGet(WECHAT_ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET));
            accessToken = new Gson().fromJson(accessTokenStr,AccessToken.class);
            accessToken.initExpiresTime();
        }

        return accessToken.getAccesstoken();
    }


    //处理文本信息回复
    private String dealTextMessage(Map<String, String> requestMap) {
        TextMessage textMessage = new TextMessage(requestMap, "12ssssa121");
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMessage.class);//激活注解
        xStream.alias("xml", TextMessage.class);
        return xStream.toXML(textMessage);
    }


    //加密
    private String getMdAh1Result(String str) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
