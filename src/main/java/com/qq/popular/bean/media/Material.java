package com.qq.popular.bean.media;

/**
 * 永久素材：图文消息
 * Created by sdyang on 2016/5/29.
 */
public class Material {

    private String title;//图文消息的标题

    private String thumb_media_id;//图文消息的封面图片素材id（必须是永久mediaID）

    private int show_cover_pic;//是否显示封面，1为显示，0为不显示

    private String author;//图文消息的作者

    private String digest;//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空

    private String content;//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS

    private String url;//图文页的URL

    private String content_source_url;//图文消息的原文地址，即点击“阅读原文”后的URL

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public int getShow_cover_pic() {
        return show_cover_pic;
    }

    public void setShow_cover_pic(int show_cover_pic) {
        this.show_cover_pic = show_cover_pic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent_source_url() {
        return content_source_url;
    }

    public void setContent_source_url(String content_source_url) {
        this.content_source_url = content_source_url;
    }
}
