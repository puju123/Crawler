package com.kingfong.webcrawler.fetch;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


/**
 * url抓取类，封装抓取动作和内容取得
 * @Title: ResponseUtil.java 
 * @Description: TODO
 * @author xinhua
 * @date 2014年11月21日 下午1:50:16
 */
public class ResponseUtil {
	private final Logger logger=Logger.getLogger(ResponseUtil.class);
	private CloseableHttpResponse response;
	private int statusCode;
	private String html;
	private String charset;
	private static final int CHUNK_SIZE = 2000;

	// NUTCH-1006 Meta equiv with single quotes not accepted
	private static Pattern metaPattern = Pattern.compile(
			"<meta\\s+([^>]*http-equiv=(\"|')?content-type(\"|')?[^>]*)>",
			Pattern.CASE_INSENSITIVE);
	private static Pattern charsetPattern = Pattern.compile(
			"charset=\\s*([a-z][_\\-0-9a-z]*)", Pattern.CASE_INSENSITIVE);
   
	public void getResponse(String url,Integer timeOut,String useProxy) {
		if (StringUtils.isBlank(url)) {
			return;
		}
		try {
			get(url,timeOut,useProxy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("XXXXXXXXXXXXXX url抓取出错："+url+e.getMessage()+" : "+e.getCause().getMessage());
			statusCode=999;
		}
	}

	public void get(String url, Integer timeOut,String useProxy) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setPath(url);
//		uri.addParameters(params);
		HttpGet httpget;
		URI uri=null;
		try {
			uri=uriBuilder.build();
		} catch (URISyntaxException e1) {
			logger.error("uri创建出错："+url,e1);
		}
		httpget = new HttpGet(uri);
        if (StringUtils.isNotBlank(useProxy)) {
        	String[] proxyIp=useProxy.split(":");
    		HttpHost proxy=new HttpHost(proxyIp[0], Integer.valueOf(proxyIp[1]), "http");
    		RequestConfig config=RequestConfig.custom().setProxy(proxy).build();
    		httpget.setConfig(config);
		}
//		setWenxinHeader(httpget);
		setDianPingHeader(httpget);

		// set Timeout
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(timeOut)
				.setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
		httpget.setConfig(requestConfig);
		// get responce
		CloseableHttpResponse response=null;
		try {
			response = httpClient.execute(httpget);
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				// get result data
				HttpEntity hEntity = response.getEntity();
				ByteBuffer buffer;
				try {
					buffer = ByteBuffer.wrap(EntityUtils.toByteArray(hEntity));
					charset = sniffCharacterEncoding(buffer, "utf-8");
					html = Charset.forName(charset).decode(buffer).toString();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.info("读取数据出错："+url,e);
				}
			}
		} catch (IOException e1) {
			logger.info("抓取出错："+url,e1);
		}finally {
			if (response!=null) {
				try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (httpClient!=null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	private void setHeader(HttpGet httpget) {
		// TODO Auto-generated method stub
		// Set the User Agent in the header
		httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");
		// prefer English
		httpget.addHeader("Accept-Language", "en-us,en-gb,en;q=0.7,*;q=0.3");
		// prefer UTF-8
		httpget.addHeader("Accept-Charset",
				"utf-8,GBK,ISO-8859-1;q=0.7,*;q=0.7");
		// prefer understandable formats
		httpget.addHeader(
				"Accept",
				"text/html,application/xml;q=0.9,application/xhtml+xml,text/xml;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		// accept gzipped content
		httpget.addHeader("Accept-Encoding", "x-gzip, gzip, deflate");
	}
	private void setDianPingHeader(HttpGet httpget) {
		// TODO Auto-generated method stub
		// Set the User Agent in the header
		httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36");
		// prefer English
		httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		// prefer UTF-8
		httpget.addHeader("Accept-Charset",
				"utf-8,GBK,ISO-8859-1;q=0.7,*;q=0.7");
		// prefer understandable formats
		httpget.addHeader(
				"Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		// accept gzipped content
		httpget.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		
		httpget.addHeader("Cache-Control", "max-age=0");
		httpget.addHeader("Connection", "keep-alive");
		httpget.addHeader("Cookie", "navCtgScroll=0; showNav=#nav-tab|0|0; navCtgScroll=0; showNav=#nav-tab|0|0; _hc.v=\"\\\"60704ac2-de06-4cc2-9c06-12df15f98bc6.1444730310\\\"\"; PHOENIX_ID=0a01091b-15060a806ec-e061c; _tr.u=VEQUdDM8XnNlNYMb; _tr.s=evrSAOFlpd526cpM; s_ViewType=10; JSESSIONID=6BEDB5A0AAFAFFF83EB6582E23D742FA; aburl=1; cy=2; cye=beijing");
		httpget.addHeader("Upgrade-Insecure-Requests", "1");
	}

	/**
	 * @return the response
	 */
	public CloseableHttpResponse getResponse() {
		return response;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}
	/**
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}
	/**
	 * Given a <code>ByteBuffer</code> representing an html file of an
	 * <em>unknown</em> encoding, read out 'charset' parameter in the meta tag
	 * from the first <code>CHUNK_SIZE</code> bytes. If there's no meta tag for
	 * Content-Type or no charset is specified, <code>null</code> is returned. <br />
	 * FIXME: non-byte oriented character encodings (UTF-16, UTF-32) can't be
	 * handled with this. We need to do something similar to what's done by
	 * mozilla
	 * (http://lxr.mozilla.org/seamonkey/source/parser/htmlparser/src/nsParser
	 * .cpp#1993). See also http://www.w3.org/TR/REC-xml/#sec-guessing <br />
	 *
	 * @param content
	 *            <code>ByteBuffer</code> representation of an html file
	 */

	private static String sniffCharacterEncoding(ByteBuffer content,
			String defaultEncoding) {
		int length = Math.min(content.remaining(), CHUNK_SIZE);

		// We don't care about non-ASCII parts so that it's sufficient
		// to just inflate each byte to a 16-bit value by padding.
		// For instance, the sequence {0x41, 0x82, 0xb7} will be turned into
		// {U+0041, U+0082, U+00B7}.
		String str = "";
		try {
			str = new String(content.array(), content.arrayOffset()
					+ content.position(), length, Charset.forName("ASCII")
					.toString());
		} catch (UnsupportedEncodingException e) {
			// code should never come here, but just in case...
			return null;
		}

		Matcher metaMatcher = metaPattern.matcher(str);
		String encoding = null;
		if (metaMatcher.find()) {
			Matcher charsetMatcher = charsetPattern.matcher(metaMatcher
					.group(1));
			if (charsetMatcher.find())
				encoding = new String(charsetMatcher.group(1));
		}
		return encoding == null ? defaultEncoding : encoding;
	}
}
