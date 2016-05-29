package com.weixin.qiye.bean;

import java.util.List;

/**
 * 成员User
 * Created by sdyang on 2016/5/29.
 */
public class User {

    private String userid;//成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节

    private String name;//成员名称。长度为1~64个字节

    private int department;//成员所属部门id列表,不超过20个

    private String  position;//职位信息。长度为0~64个字节

    private String mobile;//手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空

    private int gender;//性别。1表示男性，2表示女性

    private String email;//邮箱。长度为0~64个字节。企业内必须唯一

    private String weixinid;//微信号。企业内必须唯一。（注意：是微信号，不是微信的名字）

    private String avatar_mediaid;//成员头像的mediaid，通过多媒体接口上传图片获得的mediaid

    private Attrs extattr;//扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值

    public static class Attrs{
        List<Attr> attrs;

        public List<Attr> getAttrs() {
            return attrs;
        }

        public void setAttrs(List<Attr> attrs) {
            this.attrs = attrs;
        }

        public Attrs(){

        }
        public Attrs(List<Attr> list){
            this.attrs = list;
        }
    }

    public static class Attr{
        private String name;
        private String value;

        public Attr(){

        }

        public Attr(String name,String value){
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getAvatar_mediaid() {
        return avatar_mediaid;
    }

    public void setAvatar_mediaid(String avatar_mediaid) {
        this.avatar_mediaid = avatar_mediaid;
    }

    public Attrs getExtattr() {
        return extattr;
    }

    public void setExtattr(Attrs extattr) {
        this.extattr = extattr;
    }
}
