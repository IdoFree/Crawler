package com.rainful.crawler;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

import com.rainful.entity.PageInfo;
import com.rainful.parser.JsoupParser;
import com.rainful.parser.Parser;
import com.rainful.util.InputStreamCacher;
import com.rainful.util.ResponseUtil;
import com.rainful.util.StringUtil;

public class HttpFrontier implements Frontier {
	private static Properties properties = null;
	private static final int URL_DEEPS = 5;
	private Parser parser = null;
//	static{
//		properties = new Properties();
//		try {
//			properties.load(new FileReader("application.properties"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	public PageInfo getContent(String targetUrl) throws IOException {
		if(StringUtil.isEmpty(targetUrl))
			throw new IllegalArgumentException();
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(targetUrl);
		httpget.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");    
	    
		httpget.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");    
    
		httpget.setHeader("Accept-Encoding", "gzip, deflate");    
    
		httpget.setHeader("Accept-Language", "zh-cn,zh;q=0.5");    
    
		httpget.setHeader("Connection", "keep-alive");    
    
//		httpget.setHeader("Cookie", "__utma=226521935.73826752.1323672782.1325068020.1328770420.6;");    
    
//		httpget.setHeader("Host", "www.cnblogs.com");    
    
//		httpget.setHeader("refer", "http://www.baidu.com/s?tn=monline_5_dg&bs=httpclient4+MultiThreadedHttpConnectionManager");    
    
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
		CloseableHttpResponse response = httpclient.execute(httpget);
		PageInfo result = new PageInfo();
		String charset = null;
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		        InputStream instream = new BufferedInputStream(entity.getContent());
		        InputStreamCacher ic = new InputStreamCacher(instream);
		        		
		        try {
		        	result.setStatusCode(response.getStatusLine().getStatusCode());
		        	
		        	if (entity != null&&result.getStatusCode()==HttpStatus.SC_OK) {
		        		int i = (int)entity.getContentLength();
		                if (i < 0) {
		                    i = 4096;
		                }
		        		 final Reader reader = new InputStreamReader(ic.getInputStream(), HTTP.DEF_CONTENT_CHARSET);
		                 final CharArrayBuffer buffer = new CharArrayBuffer(i);
		                 final char[] tmp = new char[1024];
		                 int l;
		                 while((l = reader.read(tmp)) != -1) {
		                     buffer.append(tmp, 0, l);
		                 }
		        		
		        		charset = ResponseUtil.getCharSetByBody(buffer.toString());
		        		byte[] bys = new byte[1024];
		        		StringBuilder sb= new StringBuilder();
		        		instream = ic.getInputStream();
			        	while(instream.read(bys)>0){
			        		sb.append(new String(bys,charset));
			        	}
		                	result.setContent(sb.toString());
		                	//TODO using the jsoup to parse the html
		                	parser = JsoupParser.getInstance(result.getContent());
		                	result.setCharSet(parser.getCharSet());
		                	result.setDescription(parser.getDesciption());
		                	result.setAbtractText(parser.getKeywords());
		                	result.setUrlReferrence(parser.getUrlReferrence());
		                	result.setDownloadDate(new Date());
		                	result.setUrl(targetUrl);
		                	result.setLayer(getUrlDeepth(targetUrl));
		            }
		        	
		        }catch (Exception e) {
					// TODO: handle exception
		        	e.printStackTrace();
				} finally {
		            instream.close();
		        }
		    }
		}catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		} finally {
		    response.close();
		}
		return result;
	}
	
	private int getUrlDeepth(String url){
		if(url == null)
			throw new IllegalArgumentException();
		String[] strings = url.split("/");
		return strings.length;
	}
	@Override
	public boolean filterUrl(String url) {
		int urlDeepth = getUrlDeepth(url) - 2 ; // minus 2, cause the schema contains 2 , like http://
		if(urlDeepth>=URL_DEEPS){
			return true;
		}
		return false;
	}





	

}
