package com.pcx.spider;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TesthttpClientVjsoup {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("deprecation")
		HttpClient hclient = new DefaultHttpClient();


		HttpGet get = new HttpGet("http://www.cnblogs.com/chengzhipcx/");

		HttpResponse response = hclient.execute(get);

		String content = EntityUtils.toString(response.getEntity(), "utf-8");
		
		Document parse = Jsoup.parse(content);
		Elements elements = parse.select("div.postTitle a");
		for (Element element : elements) {
			System.out.println(element.text()+"--"+element.attr("href"));
		}

	}
}
