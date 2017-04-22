package com.pujun.webcrawler.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pujun.webcrawler.tool.ProxyCrawler;

@Component("taskJob")
public class ProxyTask {
	@Autowired
	ProxyCrawler proxyCrawler;
	@Scheduled(cron = "0 0/1 * * * ?")  
	public void fetchProxyData() {
		System.out.println("代理爬虫启动。。。。");
		proxyCrawler.init(1, 5000, 1, "F:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\ProxySeeds.txt",false);
		proxyCrawler.start();
	}
}
