package com.weixin.qiye.api;

import com.client.LocalHttpClient;
import com.util.JsonUtil;
import com.weixin.qiye.bean.BaseResult;
import com.weixin.qiye.bean.CreateDepartmentResult;
import com.weixin.qiye.bean.Department;
import com.weixin.qiye.bean.DepartmentsResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * Created by sdyang on 2016/5/29.
 */
public class DepartmentAPI extends BaseAPI{

    /**
     创建部门
     Https请求方式: POST
     https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN
     **/
    public static CreateDepartmentResult createDepartment(String token,Department dept){
        String json = JsonUtil.toJSONString(dept);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/department/create")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, CreateDepartmentResult.class, CHARSET);
    }
    /**
     更新部门
     请求说明
     Https请求方式: POST
     https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN
     **/
    public static CreateDepartmentResult updateDepartment(String token,Department dept){
        String json = JsonUtil.toJSONString(dept);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/department/update")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,CreateDepartmentResult.class,CHARSET);
    }


    /**
     * 删除部门
     请求说明
     Https请求方式: GET
     https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID
     */
    public static BaseResult deleteDepartment(String token,String id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/department/delete")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("id", id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,CHARSET);
    }
    /**
     获取部门列表

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID
     */
    public static DepartmentsResult listDepartment(String token,String id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/department/list")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("id", id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,DepartmentsResult.class,CHARSET);
    }

}
