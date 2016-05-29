package com.qq.popular;


import com.qq.popular.api.MessageAPI;
import com.qq.popular.bean.templatemessage.TemplateMessage;
import com.qq.popular.bean.templatemessage.TemplateMessageResult;

/**
 * Created by sdyang on 2016/3/29.
 */
public class MessageAPITest {

    private static String accessToken = "1_6986876fdc3f70650ba83fc94100f162";

    private static String fanstempletId = "52ec28e50bd223bb";//粉丝消息模板

    private static String openId = "32C036E50AF0AFB853062C91DD914E50";//用户（自己）
    //private static String openId = "E98E999E266EE31CC72702704E698285";//（佛爷）

    private static String templetId="52ec237eb0d0d3c5";//非粉丝消息模板

    public static void main(String[] args){

        //发送粉丝模板消息
        TemplateMessage t = TemplateMessage.newFansTemplateMessage(openId,fanstempletId);

        //参数按顺序排列，跟key无关
        t.putMessageItem("keynote1", "测试1");
        t.putMessageItem("keynote2", "测试2");
        t.putMessageItem("keynote3", "测试3");
        t.putMessageItem("keynote4", "测试4");
        t.putMessageItem("keynote5", "测试5");
        t.putMessageItem("商品详情",  "测试6");
        t.putMessageItem("keynote7", "www.baidu.com");

        TemplateMessageResult r = MessageAPI.fansMessageTemplateSend(accessToken, t);


        //发送非粉丝模板消息   Errcode:50001,ErrMsg:用户未授权该api
//        TemplateMessage t = TemplateMessage.newTemplateMessage("13610405524",templetId);
//
//        //参数按顺序排列，跟key无关
//        t.putMessageItem("keynote1", "测试1");
//        t.putMessageItem("keynote2", "测试2");
//        t.putMessageItem("keynote3", "测试3");
//        t.putMessageItem("keynote4", "测试4");
//        t.putMessageItem("keynote5", "测试5");
//        t.putMessageItem("商品详情",  "测试6");
//
//        TemplateMessageResult r = MessageAPI.messageTemplateSendByMobile(accessToken, t);

        r.printErrInfo();

        //根据分组群发消息      Errcode:50001,ErrMsg:用户未授权该api
//        MassMessage m= new MassMessage();
//
//        Filter f = new Filter(false,"109");
//        m.setFilter(f);
//        m.setMsgtype("text");
//        m.setTextMessage("测试");
//
//        MessageSendResult mr = MessageAPI.messageMassSendall(accessToken,m);
//        mr.printErrInfo();


        //根据openid列表群发消息
//        MassMessage m = new MassMessage();
//        m.setMsgtype("text");
//        m.setTextMessage("测试");
//        Set<String> touser = new HashSet<String>();
//        touser.add(openId);
//        m.setTouser(touser);
//        MessageSendResult mr = MessageAPI.messageMassSend(accessToken,m);
//        mr.printErrInfo();



//        BaseResult result = MessageAPI.messageMassDelete(accessToken,"123");//删除群发
//        MessageSendResult result = MessageAPI.messageMassGet(accessToken,"123");//查询发送状态
//        result.printErrInfo();


    }
}
