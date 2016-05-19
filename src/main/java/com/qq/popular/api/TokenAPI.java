package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.AccessToken;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * AccessToken基础API
 * 1、获取accesstoken   token
 */
public class TokenAPI extends BaseAPI {

	/**
	 * 获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	public static AccessToken token(String appid,String secret){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI + "/cgi-bin/token")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, AccessToken.class);
	}

}
