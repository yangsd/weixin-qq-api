package com.qq.popular;


import com.qq.popular.api.TokenAPI;
import com.qq.popular.bean.AccessToken;

/**
 * Created by sdyang on 2016/3/25.
 */
public class TokenAPITest {
    private static String appid = "";
    private static String secret= "";

    public static void main(String[] args){
        AccessToken token = TokenAPI.token(appid, secret);
        if(token.isSuccess()){
            System.out.println("AccessToken:"+token.getAccess_token());
        }else {
            token.printErrInfo();
        }
    }

    public static String getToken(){
        AccessToken token = TokenAPI.token(appid, secret);
        if(token.isSuccess()){
            System.out.println("AccessToken:"+token.getAccess_token());
        }else {
            token.printErrInfo();
        }
        return token.getAccess_token();
    }
}
