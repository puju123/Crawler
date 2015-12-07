package com.kingfong.webcrawler.main;

import java.util.List;

import com.kingfong.webcrawler.entity.CrawlMeta;


public interface Crawler {
    void init();
    void start();
    void addToQueue(List<CrawlMeta> seedList);
    void addToQueue(CrawlMeta seed);
    void shutDown();
}
