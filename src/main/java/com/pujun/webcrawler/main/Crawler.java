package com.pujun.webcrawler.main;

import java.util.List;

import com.pujun.webcrawler.entity.CrawlMeta;


public interface Crawler {
    void init();
    void start();
    void addToQueue(List<CrawlMeta> seedList);
    void addToQueue(CrawlMeta seed);
    void shutDown();
}
