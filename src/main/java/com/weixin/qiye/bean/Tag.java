package com.weixin.qiye.bean;

/**
 * Created by sdyang on 2016/5/29.
 */
public class Tag {

    private String tagname;//标签名称，长度为1~64个字节，标签名不可与其他标签重名。

    private String tagid;//标签id，整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }
}
