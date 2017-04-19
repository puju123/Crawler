package com.pujun.webcrawler.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pujun.webcrawler.tool.BejingSchoolCrawler;
import com.pujun.webcrawler.tool.ProxyCrawler;

@Component
public class Main implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	ProxyCrawler proxyCrawler;
	public static void main(String[] args) {
//        BejingSchoolCrawler crawler=new BejingSchoolCrawler(); 
//        crawler.init(1, 10000, 1, "D:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\seeds.txt");
//        crawler.start();
		System.out.println("爬虫启动。。。。");
		proxyCrawler.init(8, 5000, 3, "F:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\ProxySeeds.txt");
		proxyCrawler.start();

	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if (event.getApplicationContext().getParent() == null) {
//			CThread crawlThread=new CThread();
//            crawlThread.start();
//        }
	if (event.getApplicationContext().getParent() == null) {
//		CrawlThread ct=new CrawlThread();
//		ct.setName("crawl-thread");
//        ct.start();
		System.out.println("爬虫启动。。。。");
		proxyCrawler.init(8, 5000, 3, "F:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\ProxySeeds.txt");
		proxyCrawler.start();
    }
	}
	private class CrawlThread extends Thread{
		@Autowired
		BejingSchoolCrawler crawler;
		@Autowired
		ProxyCrawler proxyCrawler;
		public void run() {
//	        crawler.init(8, 0, 3, "D:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\seeds.txt");
//	        crawler.start();
			System.out.println("爬虫启动。。。。");
			proxyCrawler.init(8, 5000, 3, "D:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\ProxySeeds.txt");
			proxyCrawler.start();
		}
	}
}
