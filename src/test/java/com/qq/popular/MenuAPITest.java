package com.qq.popular;


import com.qq.popular.api.MenuAPI;
import com.qq.popular.bean.BaseResult;
import com.qq.popular.bean.menu.Menu;
import com.qq.popular.bean.menu.MenuButton;
import com.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdyang on 2016/3/29.
 */
public class MenuAPITest {


    private static String accessToken = "1_776f9b2d2eadcc1db250ef7ad449f1e9";

    public static void main(String[] args){
        Menu menu  = null;
        BaseResult result = null;

        //String menuStr = "{\"button\":[{\"key\":\"V1001_TODAY_MUSIC\",\"name\":\"今日歌曲\",\"type\":\"click\"},{\"name\":\"菜单\",\"sub_button\":[{\"name\":\"搜索\",\"type\":\"view\",\"url\":\"http://www.soso.com/\"},{\"key\":\"V1001_GOOD\",\"name\":\"赞一下我们\",\"type\":\"click\"}]}]}\n";
//        String menuStr = "{\"button\":[{\"key\":\"1\",\"name\":\"社群互动\",\"sub_button\":[{\"key\":\"2\",\"name\":\"进入群聊\",\"type\":\"view\",\"url\":\"http://jq.qq.com/?_wv=1027&k=2B3SCjL&mp_sourceid=0.0.2\"},{\"key\":\"3\",\"name\":\"铁粉社区\",\"type\":\"view\",\"url\":\"http://fans.tcl.com?mp_sourceid=0.0.2\"}]},{\"key\":\"4\",\"name\":\"小T服务\",\"sub_button\":[{\"key\":\"5\",\"name\":\"我要维修\",\"type\":\"view\",\"url\":\"http://125.93.53.91/multimedia/create?type=%E7%BB%B4%E4%BF%AE&appname=gh_42bda7e744cf&from=singlemessage&isappinstalled=0&mp_sourceid=0.0.2\"},{\"key\":\"6\",\"name\":\"我要安装\",\"type\":\"view\",\"url\":\"http://125.93.53.91/multimedia/create?type=%E5%AE%89%E8%A3%85&appname=gh_42bda7e744cf&mp_sourceid=0.0.2\"},{\"key\":\"7\",\"name\":\"我是教程\",\"type\":\"view\",\"url\":\"https://wap.koudaitong.com/v2/showcase/feature?alias=1851b7sqy&mp_sourceid=0.0.2\"},{\"key\":\"8\",\"name\":\"服务单查询\",\"type\":\"view\",\"url\":\"http://125.93.53.91/multimedia/GetCaseOrder?mp_sourceid=0.0.2\"}]},{\"key\":\"9\",\"name\":\"积分兑换\",\"sub_button\":[{\"key\":\"10\",\"name\":\"积分商城\",\"type\":\"view\",\"url\":\"http://hy.tcl.com?mp_sourceid=0.0.2\"},{\"key\":\"11\",\"name\":\"积分攻略\",\"type\":\"view\",\"url\":\"http://www.rabbitpre.com/m/yj727AQQr?mp_sourceid=0.0.2\"},{\"key\":\"12\",\"name\":\"注册会员\",\"type\":\"view\",\"url\":\"http://fans.tcl.com/member.php?mod=logging&action=login&mobile=2&mp_sourceid=0.0.2\"},{\"key\":\"13\",\"name\":\"签到赚积分\",\"type\":\"view\",\"url\":\"http://fans.tcl.com/k_misign-sign.html?auth=Mzg3M0ZLcHd6VER2clpvc0RxU1FsMThxWVZ6T0NnWVk1MVVsRU8yNGFId1hZRmMyRlNlRytVdVdCdw&mp_sourceid=0.0.2\"},{\"key\":\"14\",\"name\":\"官网商城\",\"type\":\"view\",\"url\":\"http://mall.tcl.com?mp_sourceid=0.0.2\"}]}]}";
        result= MenuAPI.menuCreate(accessToken, buildMenu());//创建菜单
        result.printErrInfo();



//        menu = MenuAPI.menuGet(accessToken);//查询菜单
//        System.out.println(JsonUtil.toJSONString(menu));

//        result = MenuAPI.menuDelete(accessToken);//删除菜单
//        result.printErrInfo();

    }

    private static String buildMenu1(){
        String result = "";
        MenuButton btn1 = MenuButton.newClickButton("今日歌曲","V1001_TODAY_MUSIC");

        List<MenuButton> subBtn1 = new ArrayList<MenuButton>();
        subBtn1.add(MenuButton.newViewButton("搜索", "2", "http://www.soso.com/"));
        subBtn1.add(MenuButton.newViewButton("视频","3","http://v.com.qq.com/"));
        subBtn1.add(MenuButton.newClickButton("赞一下我们","V1001_GOOD"));
        MenuButton btn2 = MenuButton.newParentButton("菜单", "1", subBtn1);

        MenuButton[] buttons = new MenuButton[]{btn1,btn2};

        Menu menu = new Menu(buttons);

        result = JsonUtil.toJSONString(menu);
        System.out.println(result);
        return result;
    }

    private static String buildMenu(){
        String  result= "";
        List<MenuButton> subBtn1 = new ArrayList<MenuButton>();
        subBtn1.add(MenuButton.newViewButton("进入群聊", "2", "http://jq.com.qq.com/?_wv=1027&k=28l30Pd"));
        subBtn1.add(MenuButton.newViewButton("铁粉社区","3","http://fans.tcl.com/tv/f448/?mp_sourceid=0.0.2"));
        MenuButton btn1 = MenuButton.newParentButton("社群互动", "1", subBtn1);

        List<MenuButton> subBtn2 = new ArrayList<MenuButton>();
        subBtn2.add(MenuButton.newViewButton("我要维修","5","http://125.93.53.91/multimedia/create?type=%E7%BB%B4%E4%BF%AE&appname=gh_42bda7e744cf&from=singlemessage&isappinstalled=0&mp_sourceid=0.0.2"));
        subBtn2.add(MenuButton.newViewButton("我要安装","6","http://125.93.53.91/multimedia/create?type=%E5%AE%89%E8%A3%85&appname=gh_42bda7e744cf&mp_sourceid=0.0.2"));
        subBtn2.add(MenuButton.newViewButton("我要教程","7","https://wap.koudaitong.com/v2/showcase/feature?alias=1851b7sqy&mp_sourceid=0.0.2"));
        subBtn2.add(MenuButton.newViewButton("服务单查询","8","http://125.93.53.91/multimedia/GetCaseOrder?mp_sourceid=0.0.2"));
        MenuButton btn2 = MenuButton.newParentButton("小T服务", "4", subBtn2);

        List<MenuButton> subBtn3 = new ArrayList<MenuButton>();
        subBtn3.add(MenuButton.newViewButton("官网商城", "10", "mail.tcl.com"));
        subBtn3.add(MenuButton.newViewButton("积分商城","11","http://hy.tcl.com"));
        subBtn3.add(MenuButton.newViewButton("积分攻略","12","http://www.rabbitpre.com/m/yj727AQQr?mp_sourceid=0.0.2"));
        subBtn3.add(MenuButton.newViewButton("会员中心","13","mall.tcl.com/usercenter"));
        subBtn3.add(MenuButton.newViewButton("签到赚积分","14","http://fans.tcl.com/k_misign-sign.html?auth=Mzg3M0ZLcHd6VER2clpvc0RxU1FsMThxWVZ6T0NnWVk1MVVsRU8yNGFId1hZRmMyRlNlRytVdVdCdw&mp_sourceid=0.0.2"));
        MenuButton btn3 = MenuButton.newParentButton("积分兑换", "9", subBtn3);

        MenuButton[] buttons = new MenuButton[]{btn1,btn2,btn3};

        Menu menu = new Menu(buttons);

        result = JsonUtil.toJSONString(menu);
        System.out.println(result);
        return result;
    }


}
