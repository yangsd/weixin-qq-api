package com.qq.popular.bean;

/**
 * Created by sdyang on 2016/3/29.
 */
public class MessageSendResult extends BaseResult{

    private String type;//媒体文件类型，分别有图片（image），图文消息（news）

    private Integer msg_id;//消息发送任务的ID

    private Integer msg_data_id;//消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Integer msg_id) {
        this.msg_id = msg_id;
    }

    public Integer getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(Integer msg_data_id) {
        this.msg_data_id = msg_data_id;
    }
}
