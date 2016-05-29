package com.weixin.qiye.bean;

import java.util.List;

/**
 * Created by fang on 2015/12/31.
 */
public class DepartmentsResult extends BaseResult {

    private List<Department> department;

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
}
