package com.pujun.webcrawler.fetch;

public interface Fetcher {
	public String fetch(String url,int timeOut,Boolean useProxy);
}
