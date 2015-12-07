package com.kingfong.webcrawler.parse;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kingfong.webcrawler.entity.Dazhongdianping;


public class DazhongParser implements Parser<Dazhongdianping> {

	@Override
	public Dazhongdianping parse(String html) {
		Dazhongdianping dazhongBean=null;
		if (StringUtils.isNotBlank(html)) {
			dazhongBean=new Dazhongdianping();
		    Document doc=Jsoup.parse(html);
		    //地址解析
//		    Elements addrElement=doc.select("div[class=breadcrumb]");
//		    if (addrElement!=null) {
//				dazhongBean.setAddrCity(addrElement.first().child(0).text());
//				String shopName=doc.select("h1[class=shop-name]").text().split(" ")[0];
//				dazhongBean.setShopname(shopName);
//				dazhongBean.setAddrDistrict(addrElement.first().child(1).text());
//				dazhongBean.setShoptype(addrElement.first().child(3).text());
//			}
		    //基本信息解析
		    Elements baseElements=doc.select("div#basic-info");
		    String level=baseElements.select("span[title]").attr("title");
		    Elements comEle=baseElements.select("div[class=brief-info]>span");
		    String comPer=null;
		    for (Element element:comEle) {
				if (StringUtils.contains(element.text(), "人均：")) {
					comPer=StringUtils.replace(element.text(), "人均：", "");
					break;
				}
			}
//		    String address=doc.select("span[itemprop=street-address]").text();
//		    String phoneNo=baseElements.select("span[itemprop=tel]").text();
//		    Elements workTimeElement=baseElements.select("p[class=info info-indent]");
//		    String workTime=null;
//		    for (Element element : workTimeElement) {
//				if (StringUtils.contains(element.text(), "营业时间")) {
//					workTime=element.select("span[class=item]").text();
//					break;
//				}
//			}
		    dazhongBean.setLevel(level);
		    dazhongBean.setComperperson(comPer);
//		    dazhongBean.setAddr(address);
//		    dazhongBean.setPhoneno(phoneNo);
//		    dazhongBean.setWorktime(workTime);
		}
		return dazhongBean;
	}

}
