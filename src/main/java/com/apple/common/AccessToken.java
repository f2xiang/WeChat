package com.apple.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 20/3/26.
 */
public class AccessToken {
    @SerializedName("access_token")
    private String accesstoken;

    @SerializedName("expires_in")
    private String expiresIn;

    private long expiresTime; //到期时间

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }



    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }



    public void initExpiresTime() {
        // //到期时间 = 当前时间+存储的时间
        this.expiresTime =  System.currentTimeMillis() + Long.parseLong(this.expiresIn) * 1000;
    }

    public boolean isExpires() {
        return System.currentTimeMillis() > expiresTime; //当前时间比过期时间要大  过期了
    }
}
