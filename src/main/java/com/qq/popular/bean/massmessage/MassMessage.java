package com.qq.popular.bean.massmessage;


import java.util.Set;

/**
 * Created by sdyang on 2016/3/29.
 */
public class MassMessage {

    protected String msgtype;

    private Filter filter;//用于特定组

    private Set<String> touser;//用于指定用户

    private TextMessage text;//文本消息

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Set<String> getTouser() {
        return touser;
    }

    public void setTouser(Set<String> touser) {
        this.touser = touser;
    }

    public TextMessage getText() {
        if(this.text == null){
            this.text = new TextMessage();
        }
        return text;
    }

    public void setText(TextMessage text) {

        this.text = text;
    }

    public void setTextMessage(String content){
        this.getText().setContent(content);
    }
}
