package com.qq.popular.api;

import com.client.LocalHttpClient;
import com.qq.popular.bean.AccessToken;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。
 * access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
 * 公众平台的API调用所需的access_token的使用及生成方式说明:
 * 1、为了保密appsecrect，第三方需要一个access_token获取和刷新的中控服务器。而其他业务逻辑服务器所使用的  access_token均来自于该中控服务器，不应该各自去刷新，否则会造成access_token覆盖而影响业务；
 * 2、目前access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。中控服务器需要根据这个有效时间提前去刷新access_token。在刷新过程中，中控服务器对外输出的依然是老access_token，
 *    此时公众平台后台会保证在刷新短时间内，新老access_token都可用，这保证了第三方业务的平滑过渡；
 * 3、access_token的有效时间可能会在未来有调整，所以中控服务器不仅需要内部定时主动刷新，还需要提供被动刷新access_token的接口，这样便于业务服务器在API调用获知access_token已超时的情况下，
 *   可以触发access_token的刷新流程。如果第三方不使用中控服务器，而是选择各个业务逻辑点各自去刷新access_token，那么就可能会产生冲突，导致服务不稳定。
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
