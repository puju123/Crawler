package com.kingfong.webcrawler.util;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CrawlQueue {
    private static ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<String>();
    public String get() {
		return queue.poll();
	}
    public void add(String url) {
		queue.add(url);
	}
    public void add(List<String> list) {
		queue.addAll(list);
	}
}
