package com.weixin.qiye.bean;

/**
 * AccessToken是企业号的全局唯一票据，调用接口时需携带AccessToken
 * Created by sdyang on 2016/5/29.
 */
public class AccessToken extends BaseResult{

    private String access_token;//获取到的凭证。长度为64至512个字节

    private int expires_in;//凭证的有效时间（秒）

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
