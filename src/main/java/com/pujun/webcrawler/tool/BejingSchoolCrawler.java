package com.pujun.webcrawler.tool;

import java.util.regex.Pattern;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BejingSchoolCrawler extends Crawler {

	@Override
	public JSONObject parseContent(String html) {
		JSONObject result=new JSONObject();
		Document document=Jsoup.parse(html);
		//总价解析
		Elements total=document.select("div.content > div.price >span.total");
		//基本信息解析
		Elements baseInfo=document.select("div.base > div.content > ul");
		if (baseInfo.hasText()) {
             extractInfo(baseInfo,result);
		}
		//交易信息解析
		Elements transactionInfo=document.select("div.transaction > div.content > ul");
		if (transactionInfo.hasText()) {
			extractInfo(transactionInfo,result);
		}
		return result;
	}

	private void extractInfo(Elements baseInfo, JSONObject result) {
		Elements baseNode=baseInfo.first().children();
		for (Element element : baseNode) {
			String key=element.select("span").text();
			String value=element.child(1).text();
			result.put(key, value);
		}
		
	}

	@Override
	public boolean contentFilt(String url) {
		String regex="http://bj.lianjia.com/.+/(\\d)+.html";
		return Pattern.matches(regex, url);
	}

	@Override
	public boolean outlinkFilt(String url) {
		String regex="http://bj.lianjia.com/(xiaoqu|chengjiao|ershoufang).+";
		return Pattern.matches(regex, url);
	}

	@Override
	public void save(JSONObject content) {
		// TODO Auto-generated method stub

	}

}
