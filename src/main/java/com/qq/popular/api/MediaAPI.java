package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.media.Description;
import com.qq.popular.bean.media.Media;
import com.qq.popular.bean.media.MediaType;
import com.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;

/**
 * 上传临时素材  https://api.mp.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE

 获取临时素材  https://api.mp.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID

 新增永久素材  https://api.mp.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN

 获取永久素材  https://api.mp.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN

 删除永久素材  https://api.mp.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN

 获取永久素材总数  https://api.mp.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN

 * Created by sdyang on 2016/3/29.
 */
public class MediaAPI extends BaseAPI{

       /**
        * 新增临时素材
        * 媒体文件在后台保存时间为3天，即3天后media_id失效。
        * @param access_token
        * @param mediaType
        * @param media  	多媒体文件有格式和大小限制，如下：
              图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
              语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
              视频（video）：10MB，支持MP4格式
              缩略图（thumb）：64KB，支持JPG格式
        * @return
        */
       public static Media mediaUpload(String access_token,MediaType mediaType,File media){
        HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/upload");
        FileBody fileBody = new FileBody(media);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("media", fileBody)
                .addTextBody(ACCESS_TOKEN, access_token)
                .addTextBody("type", mediaType.uploadType())
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
       }

    /**
     * 新增其他类型永久素材
     * @param access_token
     * @param mediaType
     * @param media  	多媒体文件有格式和大小限制，如下：
    图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
    语音（voice）：5M，播放长度不超过60s，支持AMR\MP3格式
    视频（video）：10MB，支持MP4格式
    缩略图（thumb）：64KB，支持JPG格式
     * @param description 视频文件类型额外字段，其它类型不用添加
     * @return
     */
    public static Media materialAdd_material(String access_token, MediaType mediaType,File media,Description description){
        HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/material/add_material");
        FileBody bin = new FileBody(media);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .addPart("media", bin);
        if(description != null){
            multipartEntityBuilder.addTextBody("description", JsonUtil.toJSONString(description));
        }
        HttpEntity reqEntity = multipartEntityBuilder.addTextBody(ACCESS_TOKEN, access_token)
                .addTextBody("type",mediaType.uploadType())
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }
}
