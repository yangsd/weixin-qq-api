package com.weixin.qiye.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

/**
 * Created by sdyang on 2016/5/29.
 */
public class BaseAPI {

    protected static final String BASE_URI = "https://qyapi.weixin.qq.com/cgi-bin";

    protected static final String ACCESS_TOKEN = "access_token";

    protected static final String CHARSET = "utf-8";

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());

}
