package com.qq.popular.bean.media;

import java.util.List;

/**
 * 获取永久素材的返回结果
 * Created by sdyang on 2016/5/29.
 */
public class MaterialList {

    private String title;//视频素材标题

    private String description;//视频素材描述

    private String down_url;//视频素材下载url

    private List<Material> news_item;//图文素材

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDown_url() {
        return down_url;
    }

    public void setDown_url(String down_url) {
        this.down_url = down_url;
    }

    public List<Material> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<Material> news_item) {
        this.news_item = news_item;
    }
}
