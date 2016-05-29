package com.qq.popular;


import com.qq.popular.api.UserAPI;
import com.qq.popular.bean.BaseResult;
import com.qq.popular.bean.user.FollowResult;
import com.qq.popular.bean.user.User;

/**
 * Created by sdyang on 2016/3/29.
 */
public class UserAPITest {

    private static String accesstoken = "1_4d80a2f2c1fbf3719c13606fb8d6cdb0";

    public static void main(String[] args){
        BaseResult result = null;

        //Group group = UserAPI.groupsCreate(accesstoken,"测试");//新增分组
        //System.out.println("GroupId:"+group.getGroup().getId()+",分组名称："+group.getGroup().getName());

        //result = UserAPI.groupsUpdate(accesstoken,"102","测试2");//修改分组

       // result = UserAPI.groupsDelete(accesstoken,"102");//删除分组


//        Group group = UserAPI.groupsGet(accesstoken);//查询所有分组
//        for(Group.GroupData data:group.getGroups()){
//            System.out.println("分组ID:"+data.getId()+"，分组名称："+data.getName()+"，用户人数："+data.getCount());
//        }
//       group.printErrInfo();

        FollowResult r = UserAPI.userGet(accesstoken, null);//获取用户列表
        if(r.isSuccess()){
            for(String u:r.getData().getOpenid()){
                //System.out.println("OpenId:"+u);
                User user = UserAPI.userInfo(accesstoken,u);//获取用户基本信息
                System.out.println("OpenId:"+u+",Name:"+user.getNickname());
            }
        }else{
            r.printErrInfo();
        }

//        User user = UserAPI.userInfo(accesstoken,"32C036E50AF0AFB853062C91DD914E50");//获取用户基本信息  32C036E50AF0AFB853062C91DD914E50

        //Group group = UserAPI.groupsGetid(accesstoken,"32C036E50AF0AFB853062C91DD914E50");//查询用户所在分组

        //result = UserAPI.groupsMembersUpdate(accesstoken,"32C036E50AF0AFB853062C91DD914E50","1");   //移动用户分组
    }
}
