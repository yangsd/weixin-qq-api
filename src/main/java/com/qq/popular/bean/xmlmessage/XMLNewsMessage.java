package com.qq.popular.bean.xmlmessage;


import com.qq.popular.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by sdyang on 2016/3/28.
 */
public class XMLNewsMessage extends XMLMessage{
    @XmlElement(name="Articles")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private List<Article> articles;

    public XMLNewsMessage(){
        super("news");
    }
    /**
     * @param toUserName
     * @param fromUserName
     * @param articles
     */
    public XMLNewsMessage(String toUserName, String fromUserName,
                          List<Article> articles) {
        super(toUserName, fromUserName, "news");
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String subXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ArticleCount>"+articles.size()+"</ArticleCount>");
        sb.append("<Articles>");
        for(Article a : articles){
            sb.append("<item>");
            sb.append("<Title><![CDATA["+(a.title==null?"":a.title)+"]]></Title>");
            sb.append("<Description><![CDATA["+(a.description==null?"":a.description)+"]]></Description>");
            sb.append("<PicUrl><![CDATA["+(a.picurl==null?"":a.picurl)+"]]></PicUrl>");
            sb.append("<Url><![CDATA["+(a.url==null?"":a.url)+"]]></Url>");
            sb.append("</item>");
        }
        sb.append("</Articles>");
        return sb.toString();
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="Articles")
    public class Article {
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
