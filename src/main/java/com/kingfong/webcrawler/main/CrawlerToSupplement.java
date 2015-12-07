package com.kingfong.webcrawler.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
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
import com.kingfong.webcrawler.entity.Dazhongdianping;
import com.kingfong.webcrawler.fetch.HttpClientFetcher;
import com.kingfong.webcrawler.parse.DazhongParser;


@Component
public class CrawlerToSupplement {
	private final Logger logger=Logger.getLogger(CrawlerToSupplement.class);
	@Autowired
	DazhongdianpingMapper dMapper;
	@Value("${crawlInterval}")
	private Integer interval;
	@Value("${crawlThreads}")
	private Integer poolSize;
	
	private static ExecutorService pool = null;
	private static BlockingQueue<Runnable> threadQueue = null;
//	private ConcurrentLinkedQueue<CrawlMeta> queue = new ConcurrentLinkedQueue<CrawlMeta>();
	private Set<String> crawledSet=new HashSet<String>();
	
	private final String pageReg="http://www.dianping.com/search/category/[\\d]+/10/g[\\d]+p[\\d]+";
    private final String shopReg="http://www.dianping.com/shop/[\\d]+$";
    private final String cateReg="http://www.dianping.com/search/category/[\\d]+/10/g[\\d]+";
    
    @PostConstruct
    public void init(){
    	threadQueue=new ArrayBlockingQueue<>(1000);
//    	pool = Executors.newFixedThreadPool(poolSize);
    	pool=new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.SECONDS, threadQueue);
    }
	public void start(){
		logger.info("开始执行！！！！！！！！！！！！！！");
		List<Dazhongdianping> selectList=null;
		while (true) {
			selectList=dMapper.selectAll();
			for(Dazhongdianping dz:selectList) {
				if (threadQueue.size()>900) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				CrawlThreadToSupp crawlThread = new CrawlThreadToSupp(dz.getShopid());
				pool.execute(crawlThread);
				dz=null;
			}
			selectList.clear();
			selectList=null;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//System.out.println("目前抓取线程："+countDownLatch.getCount());
	}

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

	private class CrawlThreadToSupp implements Runnable {

		private String shopId = null;
		
		public CrawlThreadToSupp(String shopId) {
			this.shopId = shopId;
		}

		@Override
		public void run() {
			String url="http://www.dianping.com/shop/"+shopId;
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
			if (StringUtils.isNotBlank(html)) {
                //System.out.println(html);
				//元数据解析
					Dazhongdianping dazhongBean = parser.parse(html);
					dazhongBean.setShopid(shopId);
					if (dazhongBean!=null) {
						dazhongBean.setFetchtime(new Date());
						dMapper.updateByPrimaryKeySelective(dazhongBean);
						logger.info("解析结果为：" + dazhongBean.toString());
					}
					dazhongBean=null;
			}
			html=null;
			fetcher=null;
			parser=null;
		}

//		private void addToQueue(HashSet<String> outlinks) {
//			if (outlinks==null||outlinks.size()==0) {
//				return;
//			}
//			int depth=cm.getDepth();
//			if (depth<=4) {
//				for (String url:outlinks) {
//					//System.out.println("outlink="+url);
//					if ((matchReg(url, cateReg)||matchReg(url, shopReg)||matchReg(url, pageReg))&&(!crawledSet.contains(url))) {
//						if (matchReg(url, pageReg)) {
//							queue.add(new CrawlMeta(findReg(url, pageReg), depth));
//						}else {
//							queue.add(new CrawlMeta(url, depth+1));
//						}
//						
//					}
//				}
//			}
//		}
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
