package com.qq.popular.bean;


import com.qq.popular.bean.xmlmessage.XMLNewsMessage;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * 发出去的消息
 * Created by fang on 2016/3/25.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SendMsg {
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

    @XmlElement(name="Content")
    private String Content;

    private int ArticleCount;

    @XmlElementWrapper(name="Articles")
    @XmlElement(name="item")
    private List<XMLNewsMessage.Article> articles;


    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Article {
        @XmlElement(name="Title")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String title;
        @XmlElement(name="Description")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String description;
        @XmlElement(name="Url")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String url;
        @XmlElement(name="PicUrl")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String picurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

    }
}
