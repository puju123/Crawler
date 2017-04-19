package com.pujun.webcrawler.fetch;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.pujun.webcrawler.entity.ProxyData;


public class HttpClientFetcher implements Fetcher {
	private final Logger logger=Logger.getLogger(HttpClientFetcher.class);
	private static ProxyData proxyData=new ProxyData();
	@Override
	public String fetch(String url,int timeOut,Boolean useProxy) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
	    ResponseUtil responseUtil=new ResponseUtil();
	    String html=null;
	    int statusCode=0;
	    String proxy=null;
	    int retryCount=1;
	    if (useProxy) {
	    	do {
	    		proxy=proxyData.getProxy();
	    		logger.info("第"+retryCount+"次抓取!!!!"+proxy);
	    		responseUtil.getResponse(url,timeOut,proxy);
	    		statusCode=responseUtil.getStatusCode();
			}while(statusCode!=200&&(++retryCount<=3));
		}else {
			responseUtil.getResponse(url,timeOut,proxy);
			statusCode=responseUtil.getStatusCode();
		}
	    if (statusCode==200||statusCode==304) {
	    	html=responseUtil.getHtml();
	    	logger.info("抓取成功："+proxy+","+url);
		}else {
			logger.error("抓取失败！code="+ statusCode +",url="+url);
		}
	    responseUtil=null;
	    return html;
	}
    
}
