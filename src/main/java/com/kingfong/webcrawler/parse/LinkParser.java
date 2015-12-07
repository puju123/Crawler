package com.kingfong.webcrawler.parse;

import java.net.URL;
import java.util.HashSet;

import com.kingfong.webcrawler.util.DOMContentUtils;

public class LinkParser {
	private HashSet<String> outlinks=new HashSet<String>();

	/**
	 * @return the outlinks
	 */
	public HashSet<String> getOutlinks() {
		return outlinks;
	}

	/**
	 * @param outlinks the outlinks to set
	 */
	public void setOutlinks(HashSet<String> outlinks) {
		this.outlinks = outlinks;
	}

	public void parse(String html,URL url) {
		// TODO Auto-generated method stub
		outlinks.clear();
        DOMContentUtils domContentUtils=new DOMContentUtils();
        domContentUtils.setConf();
        domContentUtils.getOutlinks(html,url, outlinks);
	}

}
