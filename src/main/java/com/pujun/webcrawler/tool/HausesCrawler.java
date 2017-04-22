package com.pujun.webcrawler.tool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pujun.webcrawler.dao.HausesMapper;
import com.pujun.webcrawler.entity.Hauses;

@Component
public class HausesCrawler extends Crawler<Hauses> {
	@Autowired
	HausesMapper hMapper;
	@Override
	public List<Hauses> parseContent(String html) {
		Hauses result = new Hauses();
		result.setCrawldate(new Date());
		Document document = Jsoup.parse(html);
		// ID解析
		Elements id = document.select("div.aroundInfo > div.houseRecord > span.info");
		if (id.hasText()) {
			result.setId(id.first().ownText());
		}
		// 总价解析
		Elements total = document.select("div.content > div.price > span.total");
		if (total.hasText()) {
			result.setPrice(Integer.valueOf(total.text()));
		}
		// 地域解析
		Elements areaName = document.select("div.aroundInfo > div.areaName > span.info");
		if (areaName.hasText()) {
			result.setAreaname(areaName.text());
		}
		// 小区解析
		Elements community = document.select("div.aroundInfo > div.communityName > a.info");
		if (community.hasText()) {
			result.setCommunity(community.text());
		}
		// 基本信息解析
		Elements baseInfo = document.select("div.base > div.content > ul");
		if (baseInfo.hasText()) {
			extractInfo(baseInfo, result);
		}
		// 交易信息解析
		Elements transactionInfo = document.select("div.transaction > div.content > ul");
		if (transactionInfo.hasText()) {
			extractInfo(transactionInfo, result);
		}
		List<Hauses> resultList=new ArrayList<>();
		resultList.add(result);
		return resultList;
	}

	private void extractInfo(Elements baseInfo, Hauses result) {
		Elements baseNode = baseInfo.first().children();
		for (Element element : baseNode) {
			String key = element.children().first().text();
			String value = element.ownText();
			switch (key) {
			case "房屋户型":
				result.setHuxing(value);
				break;
			case "所在楼层":
				result.setLouceng(value);
				break;
			case "建筑面积":
				result.setJianmian(Float.valueOf(StringUtils.replace(value, "㎡", "")));
				break;
			case "套内面积":
				result.setTaomian(Float.valueOf(StringUtils.replace(value, "㎡", "")));
				break;
			case "建筑类型":
				result.setLouxing(value);
				break;
			case "房屋朝向":
				result.setChaoxiang(value);
				break;
			case "建筑结构":
				result.setJiegou(value);
				break;
			case "装修情况":
				result.setZhuangxiu(value);
				break;
			case "梯户比例":
				result.setTihubili(value);
				break;
			case "供暖方式":
				result.setGongnuan(value);
				break;
			case "配备电梯":
				result.setHasdianti(value);
				break;
			case "产权年限":
				result.setChanquan(value);
				break;
			case "交易权属":
				result.setJiaoyiquanshu(value);
				break;
			case "挂牌时间":
				result.setGuapaishijian(value);
				break;
			case "上次交易":
				result.setShangcijiaoyi(value);
				break;
			case "房屋用途":
				result.setYongtu(value);
				break;
			case "房屋年限":
				result.setChiyounianxian(value);
				break;
			case "产权所属":
				result.setSuoyouquan(value);
				break;
//			case "抵押信息":
//				result.setDiya(value);
//				break;
			default:
				break;
			}
		}

	}

	@Override
	public boolean contentFilt(String url) {
		String regex = "http://bj.lianjia.com/.+/(\\d)+.html";
		return Pattern.matches(regex, url);
	}

	@Override
	public boolean outlinkFilt(String url) {
		String regex = "http://bj.lianjia.com/(xiaoqu|chengjiao|ershoufang)/(c[^o0-9]|[^c]).+";
		return Pattern.matches(regex, url);
	}

	@Override
	public void save(List<Hauses> content) {
		Hauses record=content.get(0);
		record.setCreatetime(new Date());
		hMapper.insert(record);

	}

}
