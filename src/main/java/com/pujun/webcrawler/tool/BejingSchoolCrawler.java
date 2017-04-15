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
		if (total.hasText()) {
			result.put("price", total);
		}
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
			String key=element.child(0).text();
			String value=element.child(1).text();
			switch (key) {
			case "房屋户型":
				result.put("huxing", value);
				break;
			case "所在楼层":
				result.put("louceng", value);
				break;
			case "建筑面积":
				result.put("jianmian", value);
				break;
			case "套内面积":
				result.put("taomian", value);
				break;
			case "建筑类型":
				result.put("louxing", value);
				break;
			case "房屋朝向":
				result.put("chaoxiang", value);
				break;
			case "建筑结构":
				result.put("jiegou", value);
				break;
			case "装修情况":
				result.put("zhuangxiu", value);
				break;
			case "梯户比例":
				result.put("tihubili", value);
				break;
			case "供暖方式":
				result.put("gongnuan", value);
				break;
			case "配备电梯":
				result.put("hasDianti", value);
				break;
			case "产权年限":
				result.put("chanquan", value);
				break;
			case "交易权属":
				result.put("jiaoyiquanshu", value);
				break;
			case "挂牌时间":
				result.put("guapaishijian", value);
				break;
			case "上次交易":
				result.put("shangcijiaoyi", value);
				break;
			case "房屋用途":
				result.put("yongtu", value);
				break;
			case "房屋年限":
				result.put("chiyounianxian", value);
				break;
			case "产权所属":
				result.put("suoyouquan", value);
				break;
			case "抵押信息":
				result.put("diya", value);
				break;
			default:
				break;
			}
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
