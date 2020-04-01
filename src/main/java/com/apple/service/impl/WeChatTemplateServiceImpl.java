package com.apple.service.impl;

import com.apple.service.WeChatService;
import com.apple.service.WeChatTemplateService;
import com.apple.template.KeyWord;
import com.apple.utils.NetUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 20/4/1.
 */

@Service
public class WeChatTemplateServiceImpl implements WeChatTemplateService {

    //设置行业 URL
    private static final String SET_INDUSTRY_URL =
            "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

    //行业查询 URL
    private static final String GET_INDUSTRY_URL =
            "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";

    //发送模板
    private static final String SEND_TEMPLATE_URL =
            "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    //获取模板列表
    private static final String GET_TEMPLATE_LIST_URL =
            "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";


    @Autowired
    private WeChatService weChatService;


    @Override
    public String setIndustry() {
        String industryJson = "{\n" +
                "    \"industry_id1\":\"2\",\n" +
                "    \"industry_id2\":\"3\"\n" +
                "}";

        return NetUtils.doPost(SET_INDUSTRY_URL.replace("ACCESS_TOKEN",
                weChatService.getAccessToken()),industryJson);
    }

    @Override
    public String getIndustry() {
        return NetUtils.doGet(GET_INDUSTRY_URL.replace("ACCESS_TOKEN",
                weChatService.getAccessToken()));
    }

    @Override
    public String sendTemplate() {
         return NetUtils.doPost(SEND_TEMPLATE_URL.replace("ACCESS_TOKEN",
                weChatService.getAccessToken()), createTemplateJson());
    }





//    {
//          "touser":"OPENID",
//          "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
//          "url":"http://weixin.qq.com/download",
//          "miniprogram":{
//                "appid":"xiaochengxuappid12345",
//                "pagepath":"index?foo=bar"
//           },
//          "data":{
//                "first": {
//                    "value":"恭喜你购买成功！",
//                     "color":"#173177"
//                },
//                "keyword1":{
//                    "value":"巧克力",
//                            "color":"#173177"
//                },
//                "keyword2": {
//                    "value":"39.8元",
//                            "color":"#173177"
//                },
//                "keyword3": {
//                    "value":"2014年9月22日",
//                            "color":"#173177"
//                },
//                "remark":{
//                    "value":"欢迎再次购买！",
//                            "color":"#173177"
//                }
//         }
//    }
    private String createTemplateJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("touser","og1fyvqzQN5GkRQSDL2eDhLFpYIU"); //接收人openid
        map.put("template_id","tajZi_t-Gc6D6sePnlDyi3x9PrEooeyzEWucZOwH18s"); //模板id
        map.put("url","http://baidu.com"); //点击跳转到哪里的url

        Map<String, Object> data = new HashMap<>();
        data.put("first",new KeyWord("物业缴费提醒通知","#fff177"));
        data.put("userName",new KeyWord("张三名","#003177"));
        data.put("address",new KeyWord("华业大厦海知慧科技","#173177"));
        data.put("pay",new KeyWord("5679","#333666"));
        data.put("remark",new KeyWord("请及时缴费，以免停电！！","#173177"));
        map.put("data",data);
        return new Gson().toJson(map);
    }
}
