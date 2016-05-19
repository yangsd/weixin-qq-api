package com.qq.popular.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 收到的消息
 * xml格式
 * Created by fang on 2016/3/25.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMsg {

    @XmlElement(name="ToUserName")
    private String ToUserName;

    @XmlElement(name="FromUserName")
    private String FromUserName;

    @XmlElement(name="CreateTime")
    private String CreateTime;

    @XmlElement(name="MsgType")
    private String MsgType;//消息类型

    @XmlElement(name="MsgID")
    private String MsgId;

    @XmlElement(name="Content")
    private String Content;//文本消息内容

    @XmlElement(name="Location_X")
    private String Location_X;//地理位置维度

    @XmlElement(name="Location_Y")
    private String Location_Y;//地理位置经度

    @XmlElement(name="Scale")
    private String Scale;//地图缩放大小

    @XmlElement(name="Label")
    private String Label;//地理位置信息

    @XmlElement(name="Event")
    private String Event;

    @XmlElement(name="EventKey")
    private String EventKey;

    @XmlElement(name="Ticket")
    private String Ticket;

    @XmlElement(name="Latitude")
    private String Latitude;

    @XmlElement(name="Longitude")
    private String Longitude;

    @XmlElement(name="Precision")
    private String Precision;

    @XmlElement(name="Status")
    private String Status;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
