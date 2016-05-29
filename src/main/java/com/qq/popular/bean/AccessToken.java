package com.qq.popular.bean;


/**
 * Created by fang on 2016/3/25.
 */
public class AccessToken extends BaseResult {

    private String access_token;//获取到的凭证

    private int expire;//凭证有效时间

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
