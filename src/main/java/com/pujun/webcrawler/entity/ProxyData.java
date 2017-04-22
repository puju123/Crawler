package com.pujun.webcrawler.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProxyData {
    private static List<Proxy> ipList=new ArrayList<Proxy>();
   
	/**
	 * @return the ipList
	 */
	public static List<Proxy> getIpList() {
		return ipList;
	}

	/**
	 * @param ipList the ipList to set
	 */
	public static void setIpList(List<Proxy> ipList) {
		ProxyData.ipList = ipList;
	}
	public static void setProxy(Proxy proxy) {
		ProxyData.ipList.add(proxy);
	}

	public static String getProxy() {
		String result=null;
        if (ipList.size()>0) {
    		Random random=new Random();
    		int no=random.nextInt(ipList.size()-1);
    		System.out.println("代理列表下标"+no);
    		Proxy proxy=ipList.get(no);
    		result=proxy.getIp()+":"+proxy.getPort();
		}
		return result;
	}
    
}
