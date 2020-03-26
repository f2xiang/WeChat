package com.apple.utils;

import okhttp3.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Map;

/**
 * Created by apple on 20/3/26.
 */
public class NetUtils {
    public static String doGet(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request req = new Request.Builder().url(url).build();
            Response rep = client.newCall(req).execute();
//            System.out.println("返回码："+rep.code());
            //rep.header("这里写头，可以得到相关值")
            //rep.body().string() 只能被调用一次，在要对返回内容做多次操作时用字符串存一下
//            System.out.println("返回内容："+rep.body().string());
            return rep.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }


    public static void dopPost(Map<String, String> param) {
//        OkHttpClient client = new OkHttpClient();
//        RequestBody body = new FormBody.Builder();
//                .
//                .add("键", "值")
//                .build();
//        Request req = new Request.Builder()
//                .url("https://www.baidu.com/")
//                .addHeader("键", "值")　　　　
//                .addHeader("键", "值")
//                .post(body)
//                .build();
//        //同步请求
//        Call call = client.newCall(req);
//        Response response = call.execute();
//        System.out.println("返回码："+response.code());
//        System.out.println(response.body().toString());

    }
}
