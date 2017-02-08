package com.rainful.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ResponseUtil {
	/**  
	 * 根据页面body获取字符编码  
	 * @param html  
	 * @param charset  
	 * @return  
	 */    
	public static String getCharSetByBody(String html){    
		String charset = null;
	    Document document = Jsoup.parse(html);    
	    Elements elements = document.select("meta");    
	    for(Element metaElement : elements){    
	        if(metaElement!=null && !StringUtil.isEmpty(metaElement.attr("http-equiv")) && metaElement.attr("http-equiv").toLowerCase().equals("content-type")){    
	            String content = metaElement.attr("content");    
	            charset = getCharSet(content);    
	            break;    
	        }    
	    }    
	    return charset;    
	}    
	    

	/**  
	 * 正则获取字符编码  
	 * @param content  
	 * @return  
	 */    
	private static String getCharSet(String content){    
	    String regex = ".*charset=([^;]*).*";    
	    Pattern pattern = Pattern.compile(regex);    
	    Matcher matcher = pattern.matcher(content);    
	    if(matcher.find())    
	        return matcher.group(1);    
	    else    
	        return null;    
	}
}	
