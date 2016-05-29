package com.qq.popular;


import com.qq.popular.api.QrcodeAPI;

import java.awt.image.BufferedImage;

/**
 * Created by sdyang on 2016/3/30.
 */
public class QrcodeAPITest {

    private static String accessToken = "1_18bab20b87394f05c9a387af8582bd90";

    public static void main(String[] args){


//        QrcodeTicket t = QrcodeAPI.qrcodeCreateTemp(accessToken,180,123456);//创建临时二维码
//        QrcodeTicket t = QrcodeAPI.qrcodeCreateFinal(accessToken,180);//创建永久二维码1    Ticket:RmFhYUVsSDg= , Seconds:0 , Url:http://p.qq.com/s/FaaaElH8?c2b=1
        //QrcodeTicket t = QrcodeAPI.qrcodeCreateFinal(accessToken,"yang");//创建永久二维码2  Ticket:UnlYTFFKSVc= , Seconds:0 , Url:http://p.qq.com/s/RyXLQJIW?c2b=1
//        if(t.isSuccess()){
//            System.out.println(String.format("Ticket:%s , Seconds:%s , Url:%s",t.getTicket(),t.getExpire_seconds(),t.getUrl()));
//        }
//        t.printErrInfo();


        BufferedImage image = QrcodeAPI.showqrcode("RmFhYUVsSDg");//通过ticket换取二维码

    }
}
