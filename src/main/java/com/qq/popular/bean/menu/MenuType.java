package com.qq.popular.bean.menu;

/**
 * Created by fang on 2015/10/19.
 */
public enum MenuType {
    CLICK("click","点击推事件"),
    VIEW("view","跳转URL"),
    CANCODE_WAITMSG("scancode_waitmsg","扫码推事件且弹出提示框"),
    SCANCODE_PUSH("scancode_push","扫码推事件"),
    PIC_SYSPHOTO("pic_sysphoto","系统拍照发图"),
    PIC_PHOTO_OR_ALBUM("pic_album","弹出相册发图"),
    PIC_WEIXIN("pic_weixin","微信相册发图"),
    LOCATION_SELECT("location_select","弹出地理位置选择器"),
    MEDIA_ID("media_id","下发消息（除文本消息）");

    private MenuType(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    private String name;
    private String desc;

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public String toString(){
        return name;
    }
}
