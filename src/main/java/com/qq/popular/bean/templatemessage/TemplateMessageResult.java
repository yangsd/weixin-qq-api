package com.qq.popular.bean.templatemessage;


import com.qq.popular.bean.BaseResult;

/**
 * Created by sdyang on 2016/3/29.
 */
public class TemplateMessageResult extends BaseResult {

    private Long msgid;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public void printErrInfo(){
        System.out.println(String.format("MsgId:%s , errcode:%s , errmsg:%s ",this.msgid,super.getErrcode(),super.getErrmsg()));
    }

}
