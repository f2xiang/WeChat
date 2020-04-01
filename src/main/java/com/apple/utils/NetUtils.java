package com.apple.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * 网络请求访问
 */
public class NetUtils {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public static String doGet(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request req = new Request.Builder().url(url).build();
            Response rep = client.newCall(req).execute();
            return rep.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }


    public static String doPost(String url, String json) {
        try {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String doPost(String url, Map<String, String> param) {
        try {
            OkHttpClient client = new OkHttpClient();
            FormBody.Builder builder = new FormBody.Builder();
            Iterator<Map.Entry<String, String>> queryIterator = param.entrySet().iterator();
            queryIterator.forEachRemaining(e -> {
                builder.add(e.getKey(),  e.getValue());
            });
            RequestBody body = builder.build();

            Request req = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            //同步请求
            Call call = client.newCall(req);
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }


    }
}
