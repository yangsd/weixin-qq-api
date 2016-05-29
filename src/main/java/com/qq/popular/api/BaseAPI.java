package com.qq.popular.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 基础API
 * Created by sdyang on 2016/3/25.
 */
public abstract class BaseAPI {

    protected static final String BASE_URI = "https://api.mp.qq.com";

    protected static final String ACCESS_TOKEN = "access_token";

    protected static final String CHARSET = "utf-8";

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());

    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());

    private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");

}