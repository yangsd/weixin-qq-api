package com.qq.popular.bean;

/**
 * ΢QQ请求状态数据
 *
 * @author sdyang
 */
public class BaseResult {


  private static final String SUCCESS_CODE = "0";

  private String errcode;
  private String errmsg;

  public String getErrcode() {
    return errcode;
  }

  public void setErrcode(String errcode) {
    this.errcode = errcode;
  }

  public String getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }

  public boolean isSuccess() {
    return errcode == null || errcode.isEmpty() || errcode.equals(SUCCESS_CODE);
  }

    public void printErrInfo(){
    System.out.println(String.format("errcode:%s , errmsg:%s ",this.errcode,this.errmsg));
  }

}
