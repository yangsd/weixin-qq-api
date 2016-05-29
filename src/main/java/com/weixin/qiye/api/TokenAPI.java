package com.weixin.qiye.api;

import com.client.LocalHttpClient;
import com.weixin.qiye.bean.AccessToken;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * AccessToken基础API
 * Created by sdyang on 2016/5/29.
 */
public class TokenAPI extends BaseAPI{

    /**
     * 获取AccessToken
     * AccessToken需要用CorpID和Secret来换取，不同的Secret会返回不同的AccessToken。
     * 正常情况下AccessToken有效期为7200秒，有效期内重复获取返回相同结果。
     * access_token至少保留512字节的存储空间。
     * 请求说明
     * https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
     * Https请求方式: GET
     * 每个secret代表了对应用、通讯录的不同权限；不同的管理组拥有不同的secret。
     * @param corpid
     * @param corpsecret
     * @return
     */
    public static AccessToken getToken(String corpid,String corpsecret){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/gettoken")
                .addParameter("corpid", corpid)
                .addParameter("corpsecret", corpsecret)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, AccessToken.class);
    }
}
