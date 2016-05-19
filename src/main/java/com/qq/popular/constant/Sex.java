package com.qq.popular.constant;

/**
 * Created by sdyang on 2016/3/29.
 */
public enum Sex {
    MEN(1, "男"),
    WOMEN(2,"女"),
    UNKNOW(3,"未知");

    private Sex(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private int value;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
