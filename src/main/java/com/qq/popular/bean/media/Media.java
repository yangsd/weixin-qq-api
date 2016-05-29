package com.qq.popular.bean.media;

/**
 * 上传素材后的返回结果
 */
import com.qq.popular.bean.BaseResult;

public class Media extends BaseResult {

	private String type;//媒体文件类型，分别有图片（image）、语音（voice）、视频（video）

	private String media_id;//媒体文件上传后，获取时的唯一标识

	private Integer created_at;//媒体文件上传时间戳

	private String url;//新增的图片素材的图片URL（仅新增图片素材时会返回该字段）

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String mediaId) {
		media_id = mediaId;
	}

	public Integer getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Integer createdAt) {
		created_at = createdAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
