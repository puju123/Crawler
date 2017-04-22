package com.pujun.webcrawler.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.pujun.webcrawler.entity.Proxy;
import com.pujun.webcrawler.entity.ProxyData;

@Component
public class ProxyCrawler extends Crawler<Proxy> {
//    @Autowired
//    ProxyMapper pMapper;
	
	@Override
	public List<Proxy> parseContent(String html) {
		if (StringUtils.isBlank(html)) {
			return null;
		}
		List<Proxy> result=new ArrayList<>();
		Document document=Jsoup.parse(html);
		Elements elements=document.select("#index_free_list > table > tbody > tr");
		for (Element element : elements) {
			Proxy proxy=new Proxy();
			if ("td".equals(element.children().first().tagName())) {
				proxy.setIp(element.child(0).text());
				proxy.setType(element.child(3).text());
				try {
					proxy.setPort(Integer.valueOf(element.child(1).text()));
				} catch (Exception e) {
					logger.error("端口转换成数字失败。port="+element.child(1).text(), e);
				}
//				proxy.setCreattime(new Date());
				result.add(proxy);
			}
		}
//		result.setCreattime(new Date());
		return result;
	}

	@Override
	public boolean contentFilt(String url) {
		String regex="http://www.kuaidaili.com/proxylist/(\\d)+";
		return Pattern.matches(regex, url);
	}

	@Override
	public boolean outlinkFilt(String url) {
		String regex="http://www.kuaidaili.com/proxylist/(\\d)+";
		return Pattern.matches(regex, url);
	}

	@Override
	public void save(List<Proxy> content) {
		if (content!=null) {
//			pMapper.insert(content);
			ProxyData.setIpList(content);
			
		}
		
	}


}
