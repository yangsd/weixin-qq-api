package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.BaseResult;
import com.qq.popular.bean.user.FollowResult;
import com.qq.popular.bean.user.Group;
import com.qq.popular.bean.user.User;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 *       用户分组基础API
 *
 * 1、创建分组          groupsCreate
 * 2、修改分组名称      groupsUpdate
 * 3、删除分组          groupsDelete
 * 4、查询所有分组      groupsGet
 * 5、获取用户列表      userGet
 * 6、获取用户基本信息  userInfo
 * 7、查询用户所在分组  groupsGetid
 * 8、移动用户分组      groupsMembersUpdate
 *
 * Created by sdyang on 2016/3/28.
 */
public class UserAPI extends BaseAPI{

    /**
     * 1、创建分组
     * @param access_token
     * @param name
     * @return
     */
    public static Group groupsCreate(String access_token,String name){
        String groupJson = String.format("{\"group\":{\"name\":\"%1$s\"}}",name);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/groups/create")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Group.class);
    }

    /**
     * 2、修改分组名
     * @param access_token
     * @param id 分组ID
     * @param name	分组名
     * @return
     */
    public static BaseResult groupsUpdate(String access_token,String id,String name){
        String groupJson = "{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/groups/update")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

    /**
     * 3、删除分组
     * @param access_token
     * @param id
     * @return
     */
    public static BaseResult groupsDelete(String access_token,String id){
        String groupJson = String.format("{\"group\":{\"id\":%1$s}}",id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/groups/delete")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

    /**
     * 4、查询所有分组
     * @param access_token
     * @return
     */
    public static Group groupsGet(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI+"/cgi-bin/groups/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
    }

    /**
     * 5、获取用户列表
     * @param access_token
     * @param next_openid 第一次获取使用null
     * @return
     */
    public static FollowResult userGet(String access_token,String next_openid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("next_openid", next_openid == null ? "" : next_openid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,FollowResult.class);
    }

    /**
     * 6、获取用户基本信息
     * @param access_token
     * @param openid
     * @return
     */
    public static User userInfo(String access_token,String openid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI+"/cgi-bin/user/info")
                .addParameter(ACCESS_TOKEN,access_token)
                .addParameter("openid",openid)
                .addParameter("lang","zh_CN")
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, User.class);
    }


    /**
     * 7、查询用户所在分组
     * @param access_token
     * @param openid
     * @return
     */
    public static Group groupsGetid(String access_token,String openid){
        String groupJson = String.format("{\"openid\":\"%1$s\"}",openid);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/groups/getid")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
    }


    /**
     * 8、移动用户分组
     * @param access_token
     * @param openid
     * @param to_groupid
     * @return
     */
    public static BaseResult groupsMembersUpdate(String access_token,String openid,String to_groupid){
        String groupJson = "{\"openid\":\""+openid+"\",\"to_groupid\":"+to_groupid+"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/groups/members/update")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

}
