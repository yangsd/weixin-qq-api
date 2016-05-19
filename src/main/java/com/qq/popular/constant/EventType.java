package com.qq.popular.constant;

/**
 * 事件类型
 * Created by sdyang on 2016/3/28.
 */
public class EventType {

    public static final String SUBSCRIBE = "subscribe";//订阅

    public static final String UNSUBSCRIBE = "unsubscribe";//取消订阅

    public static final String LOCATION= "LOCATION";//上报地理位置

    public static final String CLICK = "CLICK";//点击菜单拉取消息时的事件推送

    public static final String VIEW = "VIEW";//点击菜单跳转链接时的事件推送

    public static final String TEMPLATENONFANSENDJOBFINISH = "TEMPLATENONFANSENDJOBFINISH";//非粉模板消息推送成功（手机号）

    public static final String TEMPLATENONFANMSGREAD = "TEMPLATENONFANMSGREAD";//非粉模板消息阅读（手机号）

    public static final String TEMPLATESENDJOBFINISH = "TEMPLATEFANMOBSENDJOBFINISH";//模板消息推送成功（openId）

    public static final String TEMPLATEFANMSGREAD = "TEMPLATEFANMOBMSGREAD";//模板消息阅读回执（openId）

    public static final String TEMPLATEFANMOBSENDJOBFINISH = "TEMPLATEFANMOBSENDJOBFINISH";//粉丝模板消息推送成功（手机号）

    public static final String TEMPLATEFANMOBMSGREAD = "TEMPLATEFANMOBMSGREAD";//粉丝模板消息阅读（手机号）
}
