package com.pcx.spider;

import org.apache.commons.httpclient.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class TestHttpClient {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("deprecation")
		HttpClient hclient = new DefaultHttpClient();

		hclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000)
				.setParameter(CoreConnectionPNames.SO_TIMEOUT, 1000)
				.setParameter(ConnRouteParams.DEFAULT_PROXY, new HttpHost("127.0.0.1", 8080));

		HttpGet get = new HttpGet("http://www.cnblogs.com/chengzhipcx/");

		HttpResponse response = hclient.execute(get);

		String content = EntityUtils.toString(response.getEntity(), "utf-8");

		System.out.println(content);
	}
}
