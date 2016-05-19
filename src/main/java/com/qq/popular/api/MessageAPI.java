package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.BaseResult;
import com.qq.popular.bean.MessageSendResult;
import com.qq.popular.bean.massmessage.MassMessage;
import com.qq.popular.bean.templatemessage.TemplateMessage;
import com.qq.popular.bean.templatemessage.TemplateMessageResult;
import com.util.JsonUtil;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 *      消息基础API
 *
 * 1、发送模版消息                 fansMessageTemplateSend
 * 2、根据手机号发送非粉模版消息   messageTemplateSendByMobile
 * 3、根据分组进行群发             messageMassSendall
 * 4、根据OpenID列表群发           messageMassSend
 * 5、删除群发                     messageMassDelete
 * 6、查询群发消息发送状态         messageMassGet
 *
 * Created by sdyang on 2016/3/28.
 */
public class MessageAPI extends BaseAPI{

    /**
     * 1、根据openid发送粉丝模板消息
     * @param access_token
     * @param templateMessage
     * @return
     */
    public static TemplateMessageResult fansMessageTemplateSend(String access_token,TemplateMessage templateMessage){
        String messageJson = JsonUtil.toJSONString(templateMessage);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/message/template/send")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson, Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, TemplateMessageResult.class);
    }

    /**
     * 2、根据手机号发送非粉模版消息
     * @param access_token
     * @param templateMessage
     * @return
     */
    public static TemplateMessageResult messageTemplateSendByMobile(String access_token,TemplateMessage templateMessage){
        String messageJson = JsonUtil.toJSONString(templateMessage);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/message/template/sendmob")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson, Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, TemplateMessageResult.class);
    }

    /**
     * 3.1、根据分组进行群发
     * @param access_token
     * @param messageJson
     * @return
     */
    public static MessageSendResult messageMassSendall(String access_token,String messageJson){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/message/mass/sendall")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson,Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,MessageSendResult.class);
    }

    /**
     * 3.2、根据分组进行群发
     * @param access_token
     * @param massMessage
     * @return
     */
    public  static MessageSendResult messageMassSendall(String access_token,MassMessage massMessage){
        String str = JsonUtil.toJSONString(massMessage);
        return messageMassSendall(access_token,str);
    }

    /**
     * 4.1、根据OpenID列表群发
     * @param access_token
     * @param messageJson
     * @return
     */
    public static MessageSendResult messageMassSend(String access_token,String messageJson){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/message/mass/send")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson,Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,MessageSendResult.class);
    }

    /**
     * 4.2、跟据OpenID列表群发
     * @param access_token
     * @param massMessage
     * @return
     */
    public static MessageSendResult messageMassSend(String access_token,MassMessage massMessage){
        String str = JsonUtil.toJSONString(massMessage);
        return messageMassSend(access_token,str);
    }

    /**
     * 5、删除群发
     * 请注意，只有已经发送成功的消息才能删除删除消息只是将消息的图文详情页失效，
     * 已经收到的用户，还是能在其本地看到消息卡片。
     * 另外，删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
     * @param access_token
     * @param msg_id
     * @return
     */
    public static BaseResult messageMassDelete(String access_token,String msg_id){
        String messageJson = String.format("{\"msg_id\":\"%s\"}",msg_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/message/mass/delete")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson,Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

    /**
     * 6、查询群发消息发送状态
     * @param access_token
     * @param msg_id
     * @return
     */
    public static MessageSendResult messageMassGet(String access_token,String msg_id){
        String messageJson = String.format("{\"msg_id\":\"%s\"}",msg_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/message/mass/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson,Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,MessageSendResult.class);
    }
}
