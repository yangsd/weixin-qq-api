package com.weixin.qiye.bean;

import java.util.List;

/**
 * Created by sdyang on 2016/5/29.
 */
public class UserList extends BaseResult{

    private List<User> userlist;//成员列表

    private String[] partylist;//成员所属部门

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public String[] getPartylist() {
        return partylist;
    }

    public void setPartylist(String[] partylist) {
        this.partylist = partylist;
    }
}
