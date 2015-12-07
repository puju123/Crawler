package com.kingfong.webcrawler.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.kingfong.webcrawler.entity.CrawlMeta;


public class SeedFile extends File {
	private final Logger logger=Logger.getLogger(SeedFile.class);
	private final String path="G:\\java\\apache-tomcat-7.0.63\\wtpwebapps\\crawler\\WEB-INF\\classes\\seed\\seeds.txt";
	public List<CrawlMeta> getSeedFromFile() {
		List<CrawlMeta> resultList=new ArrayList<CrawlMeta>();
		logger.info("读取种子url："+path);
		List<String> urlList=getFileContent(path);
		for (String url:urlList) {
			resultList.add(new CrawlMeta(url, 1));
		}
		return resultList;
	}
}
