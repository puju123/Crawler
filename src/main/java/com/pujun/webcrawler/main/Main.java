package com.pujun.webcrawler.main;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pujun.webcrawler.tool.BejingSchoolCrawler;

@Component
public class Main implements ApplicationListener<ContextRefreshedEvent>{
	
	public static void main(String[] args) {
        BejingSchoolCrawler crawler=new BejingSchoolCrawler(); 
        crawler.init(1, 10000, 1, "F:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\seeds.txt");
        crawler.start();

	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if (event.getApplicationContext().getParent() == null) {
//			CThread crawlThread=new CThread();
//            crawlThread.start();
//        }
	if (event.getApplicationContext().getParent() == null) {
		CrawlThread ct=new CrawlThread();
		ct.setName("crawl-thread");
        ct.start();
    }
	}
	private class CrawlThread extends Thread{
		public void run() {
	        BejingSchoolCrawler crawler=new BejingSchoolCrawler(); 
	        crawler.init(8, 0, 3, "F:\\java\\workspace\\WebCrawler\\src\\main\\resources\\seed\\seeds.txt");
	        crawler.start();
		}
	}
}
