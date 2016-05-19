package com.qq.popular.bean.xmlmessage;


import com.qq.popular.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by sdyang on 2016/3/28.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLTextMessage extends XMLMessage{

    @XmlElement(name="Content")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String content;

    public XMLTextMessage(){
        super("text");
    }
    public XMLTextMessage(String toUserName, String fromUserName,String content) {
        super("text");
        this.ToUserName = toUserName;
        this.FromUserName = fromUserName;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String subXML() {
        return "<Content><![CDATA["+(content==null?"":content)+"]]></Content>";
    }
}
