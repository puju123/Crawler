package com.pujun.webcrawler.entity;

public class CrawlMeta {
    private String url;
    private int depth;
    public CrawlMeta(String url,int depth){
    	this.url=url;
    	this.depth=depth;
    }
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "CrawlMeta [url=" + url + ", depth=" + depth + "]";
	}
    
}
