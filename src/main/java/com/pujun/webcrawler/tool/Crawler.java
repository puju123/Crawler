package com.pujun.webcrawler.tool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.pujun.webcrawler.entity.CrawlMeta;
import com.pujun.webcrawler.fetch.HttpClientFetcher;
import com.pujun.webcrawler.parse.LinkParser;
import com.pujun.webcrawler.util.SeedFile;

public abstract class Crawler<T> {
	protected final Logger logger = Logger.getLogger(this.getClass());
	//抓取线程池
	private static ExecutorService pool = null;
	//待抓取队列
	private ConcurrentLinkedQueue<CrawlMeta> queue = new ConcurrentLinkedQueue<CrawlMeta>();
	//已抓取队列
	private Set<String> crawledSet = new HashSet<String>();
	//每次抓取间隔时间，执行时会随机生成interval范围内的数值。
	private int interval = 0;
	//最大抓取层数
	private int maxDepth=3;
	//种子文件路径
	private String seedFilePath=null;
   /**
    * @Title: init 
    * @Description: 初始化
    * @param poolSize 抓取线程池大小
    * @param interval 抓取间隔
    * @param maxDepth 最去最大层数
    * @param seedFilePath 种子文件路径
    * void
    * @throws
    */
	public void init(int poolSize, int interval,int maxDepth,String seedFilePath) {
		pool = Executors.newFixedThreadPool(poolSize);
		this.interval = interval;
		this.maxDepth=maxDepth;
		this.seedFilePath=seedFilePath;
	};

	public abstract T parseContent(String html);

	public abstract boolean contentFilt(String url);
	
	public abstract boolean outlinkFilt(String url);

	public abstract void save(T content);

	public void start() {
		logger.info("开始执行！！！！！！！！！！！！！！");
		fillSeed();
		while (true) {
			CrawlMeta cm = queue.poll();
			if (cm == null) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.error(e);
				}
			} else {
				CrawlThread crawlThread = new CrawlThread(cm);
				pool.execute(crawlThread);
			}
			// System.out.println("目前抓取线程："+countDownLatch.getCount());
		}
	}
    /**
     * @Title: fillSeed 
     * @Description: 种子url加入队列
     * void
     * @throws
     */
	private void fillSeed() {
		SeedFile seedFile=new SeedFile(seedFilePath);
		List<CrawlMeta> seedList=seedFile.getSeedFromFile();
		queue.addAll(seedList);
	}
    /**
     * @Title: shutdown 
     * @Description: 关闭线程池
     * void
     * @throws
     */
	public void shutdown() {
		if (pool != null) {
			pool.shutdown();
			try {
				if (!(pool.awaitTermination(60, TimeUnit.SECONDS))) {
					logger.info("线程池停止失败！");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (pool.isTerminated()) {
			logger.info("结束执行！！！！！！！！！！！！！！");
		}
	}
    /**
     * @ClassName: CrawlThread 
     * @Description: 抓取流程处理
     * @author pujun 
     * @date 2017年4月15日 上午9:50:54 
     *
     */
	private class CrawlThread implements Runnable {

		private CrawlMeta cm = null;

		public CrawlThread(CrawlMeta cm) {
			this.cm = cm;
		}

		@Override
		public void run() {
			String url = cm.getUrl();
			// 如果url已经抓取，则返回
			if (crawledSet.contains(url)) {
				return;
			}
			try {
				int waitTime = new Random().nextInt(interval);
				logger.debug("等待。。。。。。。" + waitTime);
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			HttpClientFetcher fetcher = new HttpClientFetcher();
            //html抓取
			String html = fetcher.fetch(url, 5000, false);
			if (StringUtils.isNoneBlank(html)) {
				// url放入已抓取列表
				crawledSet.add(url);
				LinkParser linkParser = new LinkParser();
				// System.out.println(html);
				// 元数据解析
				try {
					// 外链解析
					linkParser.parse(html, new URL(url));
					// 解析完成外链放入待抓取队列
					addToQueue(linkParser.getOutlinks());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//如果符合内容页，则解析内容
				if (contentFilt(url)) {
					//内容解析
					T content=parseContent(html);
					//内容存储
					save(content);
				}
			}
		}
        /**
         * @Title: addToQueue 
         * @Description: 添加外链到待抓取队列
         * @param outlinks
         * void
         * @throws
         */
		private void addToQueue(HashSet<String> outlinks) {
			if (outlinks == null || outlinks.size() == 0) {
				return;
			}
			int depth = cm.getDepth();
			if (depth <= maxDepth) {
				for (String url : outlinks) {
					// System.out.println("outlink="+url);
					if (outlinkFilt(url)) {
							queue.add(new CrawlMeta(url, depth + 1));
					}
				}
			}
		}
	}

}
