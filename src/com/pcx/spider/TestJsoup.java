package com.pcx.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {
	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("http://www.cnblogs.com/chengzhipcx/").get();
		Elements els = doc.select("div.postTitle a");
		for (Element element : els) {
			System.out.println(element.text()+"   "+element.attr("href"));
		}
	}
}
