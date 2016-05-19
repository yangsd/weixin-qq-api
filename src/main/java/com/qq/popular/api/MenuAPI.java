package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.BaseResult;
import com.qq.popular.bean.menu.Menu;
import com.util.JsonUtil;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 *      菜单基础API
 *
 * 1、创建菜单   menuCreate
 * 2、获取菜单   menuGet
 * 3、删除菜单   menuDelete
 *
 * Created by sdyang on 2016/3/28.
 */
public class MenuAPI extends BaseAPI{

    /**
     * 1、点击事件
     */
    public static final String MENU_CLICK="click";
    /**
     * 2、跳转RUL
     */
    public static final String MENU_VIEW="view";
    /**
     * 3、扫码推事件
     */
    public static final String MENU_SCANCODE_PUSH="scancode_push";
    /**
     * 4、扫码推事件且弹出,消息接收中,提示框
     */
    public static final String MENU_SCANCODE_WAITMSG="scancode_waitmsg";
    /**
     * 5、弹出系统拍照发图
     */
    public static final String MENU_PIC_SYSPHOTO="pic_sysphoto";
    /**
     * 6、弹出相册发图
     */
    public static final String MENU_PIC_PHOTO_OR_ALBUM="pic_album";

    /**
     * 7、弹出地理位置选择器
     */
    public static final String MENU_LOCATION_SELECT="location_select";
    /**
     * 8、下发消息(除文本消息)
     */
    public static final String MENU_MEDIA="media_id";

    /**
     * 创建菜单
     * 如果url无法访问会报错误40017（不合法的按钮类型）
     * @param access_token
     * @param menuJson 菜单json 数据 例如{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}
     * @return
     */
    public static BaseResult menuCreate(String access_token,String menuJson){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/menu/create")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(menuJson, Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 创建菜单
     * @param access_token
     * @param menu
     * @return
     */
    public static BaseResult menuCreate(String access_token,Menu menu){
        String str = JsonUtil.toJSONString(menu);
        return menuCreate(access_token,str);
    }

    /**
     * 获取菜单
     * @param access_token
     * @return
     */
    public static Menu menuGet(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI+"/cgi-bin/menu/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,Menu.class);
    }

    /**
     * 删除菜单
     * @param access_token
     * @return
     */
    public static BaseResult menuDelete(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI+"/cgi-bin/menu/delete")
                .addParameter(ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

}
