package com.qq.popular.bean.xmlmessage;


import com.qq.popular.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by sdyang on 2016/3/28.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class XMLMessage {
    @XmlElement(name="ToUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    protected String ToUserName;

    @XmlElement(name="FromUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    protected String FromUserName;

    @XmlElement(name="MsgType")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String MsgType;

    @XmlElement(name="CreateTime")
    protected Long CreateTime;

    public XMLMessage(){

    }
    public XMLMessage(String toUserName, String fromUserName,String type) {
        this.ToUserName = toUserName;
        this.FromUserName = fromUserName;
        this.MsgType = type;
        CreateTime = System.currentTimeMillis()/1000;
    }
    public XMLMessage(String msgType) {
        this.MsgType = msgType;
        CreateTime = System.currentTimeMillis()/1000;
    }


    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        this.ToUserName = toUserName;
    }


    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }

    /**
     * 子类自定义XML
     * @return
     */
    public abstract String subXML();

    public String toXML(){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA["+ToUserName+"]]></ToUserName>");
        sb.append("<FromUserName><![CDATA["+FromUserName+"]]></FromUserName>");
        sb.append("<CreateTime>"+CreateTime+"</CreateTime>");
        sb.append("<MsgType><![CDATA["+MsgType+"]]></MsgType>");
        sb.append(subXML());
        sb.append("</xml>");
        System.out.println("回复xml字符串："+sb.toString());
        return sb.toString();
    }

    public boolean outputStreamWrite(OutputStream outputStream){
        try {
            outputStream.write(toXML().getBytes("utf-8"));
            outputStream.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
