package com.kingfong.webcrawler.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kingfong.webcrawler.dao.DazhongdianpingMapper;
import com.kingfong.webcrawler.entity.CrawlMeta;
import com.kingfong.webcrawler.entity.Dazhongdianping;
import com.kingfong.webcrawler.fetch.HttpClientFetcher;
import com.kingfong.webcrawler.parse.DazhongParser;
import com.kingfong.webcrawler.parse.LinkParser;



@Component
public class CrawlerByCity implements Crawler {
	private final Logger logger=Logger.getLogger(CrawlerByCity.class);
	@Autowired
	DazhongdianpingMapper dMapper;
	@Value("${crawlInterval}")
	private Integer interval;
	@Value("${crawlThreads}")
	private Integer poolSize;
	
	private static ExecutorService pool = null;
	private ConcurrentLinkedQueue<CrawlMeta> queue = new ConcurrentLinkedQueue<CrawlMeta>();
	private Set<String> crawledSet=new HashSet<String>();
	
	private final String pageReg="http://www.dianping.com/search/category/[\\d]+/10/g[\\d]+p[\\d]+";
    private final String shopReg="http://www.dianping.com/shop/[\\d]+$";
    private final String cateReg="http://www.dianping.com/search/category/[\\d]+/10/g[\\d]+";
    
    @Override
    @PostConstruct
    public void init(){
    	pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
	public void start() {
		logger.info("开始执行！！！！！！！！！！！！！！");
		while (true) {
			CrawlMeta cm = queue.poll();
			if (cm==null) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.error(e);
				}
			} else {
				CrawlThread crawlThread = new CrawlThread(cm);
				pool.execute(crawlThread);
			}
			//System.out.println("目前抓取线程："+countDownLatch.getCount());
		}
	}

	@Override
	public void addToQueue(List<CrawlMeta> seedList) {
		queue.addAll(seedList);
	}
	
	@Override
	public void addToQueue(CrawlMeta seed) {
		queue.add(seed);
	} 
	
    @Override
	public void shutDown() {

		if (pool != null) {
			pool.shutdown();
			try {
				if (!(pool.awaitTermination(60, TimeUnit.SECONDS))) {
					logger.info("线程池停止失败！");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pool.isTerminated()) {
			logger.info("结束执行！！！！！！！！！！！！！！");
		}

	}

	private class CrawlThread implements Runnable {

		private CrawlMeta cm = null;
		
		public CrawlThread(CrawlMeta cm) {
			this.cm = cm;
		}

		@Override
		public void run() {
			String url=cm.getUrl();
			//如果url已经抓取，则返回
			if (crawledSet.contains(url)) {
				return;
			}
			try {
				int waitTime=new Random().nextInt(interval);
				logger.debug("等待。。。。。。。"+waitTime);
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpClientFetcher fetcher = new HttpClientFetcher();
			DazhongParser parser = new DazhongParser();
			
			String html=fetcher.fetch(url,5000,true);
			if (StringUtils.isNoneBlank(html)) {
				//url放入已抓取列表
				crawledSet.add(url);
				LinkParser linkParser=new LinkParser();
                //System.out.println(html);
				//元数据解析
				if (matchReg(url,shopReg)) {
					Dazhongdianping dazhongBean = parser.parse(html);
					dazhongBean.setShopid(StringUtils.split(url, "/")[3]);
					if (dazhongBean!=null) {
						dazhongBean.setFetchtime(new Date());
						dMapper.insert(dazhongBean);
						logger.info("解析结果为：" + dazhongBean.toString());
					}
				}else {
					try {
						//外链解析
						linkParser.parse(html,new URL(url));
						//解析完成外链放入待抓取队列
						addToQueue(linkParser.getOutlinks());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		private void addToQueue(HashSet<String> outlinks) {
			if (outlinks==null||outlinks.size()==0) {
				return;
			}
			int depth=cm.getDepth();
			if (depth<=4) {
				for (String url:outlinks) {
					//System.out.println("outlink="+url);
					if ((matchReg(url, cateReg)||matchReg(url, shopReg)||matchReg(url, pageReg))&&(!crawledSet.contains(url))) {
						if (matchReg(url, pageReg)) {
							queue.add(new CrawlMeta(findReg(url, pageReg), depth));
						}else {
							queue.add(new CrawlMeta(url, depth+1));
						}
						
					}
				}
			}
		}
	}

	public boolean matchReg(String from, String regStr) {
		Pattern p=Pattern.compile(regStr);
		Matcher matcher=p.matcher(from);
		return matcher.find();
	}
	public String findReg(String from, String regStr) {
		Pattern p=Pattern.compile(regStr);
		Matcher matcher=p.matcher(from);
		if (matcher.find()) {
			return matcher.group();
		}else {
			return "";
		}
		
	}
}
