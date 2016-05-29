package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.BaseResult;
import com.qq.popular.bean.media.*;
import com.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.nio.charset.Charset;

/**
 * 上传临时素材  https://api.mp.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE

 * 获取临时素材  https://api.mp.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID

 * 新增永久素材  https://api.mp.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN

 * 获取永久素材  https://api.mp.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN

 * 删除永久素材  https://api.mp.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN

 * 获取永久素材总数  https://api.mp.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN

 * Created by sdyang on 2016/3/29.
 */
public class MediaAPI extends BaseAPI{

    /**
     * 上传临时素材
     * 媒体文件在后台保存时间为3天，即3天后media_id失效。
     * 请求方式：POST/FORM（请使用https协议）
     * @param access_token
     * @param mediaType
     * @param media        多媒体文件有格式和大小限制，如下：
     *                     图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
     *                     语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
     *                     视频（video）：10MB，支持MP4格式
     *                     缩略图（thumb）：64KB，支持JPG格式
     * @return
     */
    public static Media uploadMedia(String access_token, MediaType mediaType, File media) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/upload?" + ACCESS_TOKEN + "=" + access_token + "&type=" + mediaType.uploadType());
        FileBody fileBody = new FileBody(media, ContentType.create(mediaType.contentType()),media.getName());
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("media", fileBody)
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }

    /**
     * 获取临时素材
     * @param access_token
     * @param mediaid
     * @return
     */
    public static Media getMedia(String access_token,String mediaid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/media/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("media_id", mediaid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Media.class);
    }

    /**
     * 新增永久素材
     *
     * 通过POST表单来调用接口，表单id为media，包含需要上传的素材内容，有filename、filelength、content-type等信息。
     * 请注意：图片素材将进入公众平台官网素材管理模块中的默认分组。
     *请注意：
     *1、新增的永久素材也可以在公众平台官网素材管理模块中看到
     *2、永久素材的数量是有上限的，请谨慎新增。图片素材的上限为5000，其他类型为1000
     *3、素材的格式大小等要求与公众平台官网一致。具体是，图片大小不超过2M，支持bmp/png/jpeg/jpg/gif格式；语音大小不超过5M，长度不超过60秒，支持mp3/wma/wav/amr格式；视频大小不超过10M，格式仅支持MP4
     *4、在上传视频素材时需要POST另一个表单，id为description，包含素材的描述信息
     *5、调用该接口需https协议
     * @param access_token
     * @param mediaType
     * @param media
     * @param description
     * @return
     */
    public static Media uploadMaterial(String access_token, MediaType mediaType,File media,Description description){
        HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/material/add_material?" + ACCESS_TOKEN + "=" + access_token + "&type=" + mediaType.uploadType());
        FileBody bin = new FileBody(media, ContentType.create(mediaType.contentType()),media.getName());
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .addPart("media", bin);
        if(description != null){
            multipartEntityBuilder.addTextBody("description", JsonUtil.toJSONString(description));
        }
        HttpEntity reqEntity = multipartEntityBuilder .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }

    /**
     * 获取永久素材
     *
     * 1、获取永久素材也可以获取公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材（但需要先通过获取素材列表来获知素材的media_id）
     * 2、临时素材无法通过本接口获取
     * 3、调用该接口需https协议,请求方式POST
     *
     * @param access_token
     * @param media_id     媒体文件ID
     * @return
     */
    public static MaterialList getMaterial(String access_token, String media_id) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/material/get_material?" + ACCESS_TOKEN + "=" + access_token);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addTextBody("media_id", media_id)
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, MaterialList.class);

    }

    /**
     * 获取永久素材总数
     * 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。
     *请注意：
     * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材
     * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
     * 3.调用该接口需https协议get请求方式
     * @param access_token
     * @return
     */
    public static MediaCount getMaterialCount(String access_token) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/material/get_materialcount")
                .addParameter(ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, MediaCount.class);
    }


    /**
     * 删除永久素材
     *在新增了永久素材后，开发者可以根据本接口来删除不再需要的永久素材，节省空间。
     *请注意：
     * 1、请谨慎操作本接口，因为它可以删除公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材（但需要先通过获取素材列表来获知素材的media_id）
     * 2、临时素材无法通过本接口删除
     * 3、调用该接口需https协议请求方式post
     * @param access_token
     * @param media_id     媒体文件ID
     * @return
     */
    public static BaseResult deleteMaterial(String access_token, String media_id) {
        String materialJson = String.format("{\"media_id\":%1$s}", media_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/del_material")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(materialJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

}
