package com.qq.popular.bean.templatemessage;


import java.util.LinkedHashMap;

/**
 * 模板消息
 * Created by sdyang on 2016/3/29.
 */
public class TemplateMessage {

    private String tousername;//粉丝openid

    private String tousermob;//非粉丝手机号

    private String templateid;//消息模板id

    private String type;

    private LinkedHashMap<String, TemplateMessageItem> data;

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LinkedHashMap<String, TemplateMessageItem> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, TemplateMessageItem> data) {
        this.data = data;
    }

    public String getTousermob() {
        return tousermob;
    }

    public void setTousermob(String tousermob) {
        this.tousermob = tousermob;
    }

    /**
     * 粉丝模板消息
     * @param tousername  粉丝openid
     * @param templateid  消息模板id
     * @return
     */
    public static TemplateMessage newFansTemplateMessage(String tousername,String templateid) {
        TemplateMessage message = new TemplateMessage();
        message.setTemplateid(templateid);
        message.setTousername(tousername);
        message.setData(new LinkedHashMap<String,TemplateMessageItem>());
        return message;
    }

    /**
     * 非粉丝模板消息
     * @param tousermob    手机号码
     * @param templateid   消息模板id
     * @return
     */
    public static TemplateMessage newTemplateMessage(String tousermob,String templateid){
        TemplateMessage message = new TemplateMessage();
        message.setTemplateid(templateid);
        message.setTousermob(tousermob);
        message.setData(new LinkedHashMap<String,TemplateMessageItem>());
        return message;
    }

    /**
     * 模板参数
     * @param key
     * @param parm
     */
    public  void putMessageItem(String key,String parm){
        TemplateMessageItem item = new TemplateMessageItem(parm);
        this.getData().put(key,item);
    }

}
