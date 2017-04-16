package com.pujun.webcrawler.tool;

import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pujun.webcrawler.dao.ProxyMapper;
import com.pujun.webcrawler.entity.Proxy;

@Component
public class ProxyCrawler extends Crawler<Proxy> {
    @Autowired
    ProxyMapper pMapper;
	
	@Override
	public Proxy parseContent(String html) {
		if (StringUtils.isBlank(html)) {
			return null;
		}
		Proxy result=new Proxy();
		Document document=Jsoup.parse(html);
		Elements elements=document.select("table#ip_list > tr");
		for (Element element : elements) {
			if ("td".equals(element.children().first().tagName())) {
				result.setIp(element.child(1).text());
				result.setType(element.child(5).text());
				try {
					result.setPort(Integer.valueOf(element.child(2).text()));
				} catch (Exception e) {
					logger.error("端口转换成数字失败。port="+element.child(2).text(), e);
				}
			}
		}
		result.setCreattime(new Date());
		return result;
	}

	@Override
	public boolean contentFilt(String url) {
		String regex="http://www.xicidaili.com/nn/(\\d)+";
		return Pattern.matches(regex, url);
	}

	@Override
	public boolean outlinkFilt(String url) {
		String regex="http://www.xicidaili.com/nn/(\\d)+";
		return Pattern.matches(regex, url);
	}

	@Override
	public void save(Proxy content) {
		if (content!=null) {
			pMapper.insert(content);
		}
		
	}

}
