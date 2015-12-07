package com.kingfong.webcrawler.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.kingfong.webcrawler.entity.CrawlMeta;
import com.kingfong.webcrawler.util.SeedFile;

@Component
public class Main implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private CrawlerByCity crawler;
	@Autowired
	private CrawlerToSupplement crawlerToSupplement;
	
	public static void main(String[] args) {
    Main main=new Main();
    main.start();

	}
	
	private void start() {
		SeedFile seedFile=new SeedFile();
		List<CrawlMeta> seedList=seedFile.getSeedFromFile();
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g110", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g132", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g508", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g117", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g111", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g112", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g113", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g116", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g311", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g102", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g103", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g114", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g115", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g251", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g104", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g101", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g106", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g248", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g108", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g109", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g3243", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g26481", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g2783", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g26483", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g105", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g246", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g118", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/beijing/food", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g1783p50", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/search/category/2/10/g110p50", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/shop/9419771", 1));
//		seedList.add(new CrawlMeta("http://www.dianping.com/shop/10655026", 1));
		crawler.addToQueue(seedList);
		crawler.start();
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if (event.getApplicationContext().getParent() == null) {
//			CThread crawlThread=new CThread();
//            crawlThread.start();
//        }
	if (event.getApplicationContext().getParent() == null) {
		CSThread cs=new CSThread();
		cs.setName("main-thread");
        cs.start();
    }
	}
	
	private class CThread extends Thread{
		public void run() {
			SeedFile seedFile=new SeedFile();
			List<CrawlMeta> seedList=seedFile.getSeedFromFile();
			crawler.addToQueue(seedList);
			crawler.start();
		}
	}
	private class CSThread extends Thread{
		public void run() {
			crawlerToSupplement.start();
		}
	}
}
