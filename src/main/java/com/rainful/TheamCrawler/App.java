package com.rainful.TheamCrawler;

import com.rainful.crawler.Crawler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    		Frontier frontier = new HttpFrontier();
//    		Logger logger = LoggerFactory.getLogger();
//    		try {
//    			PageInfo content = frontier.getContent("http://www.baidu.com");
//    			PageInfoDao pageInfoDao = new PageInfoJPADao();
//    			pageInfoDao.save(content);
//    			logger.info(content.getContent());
//    		} catch (IOException e) {
//    			e.printStackTrace();
//    		}
    	
    	Crawler crawler = new Crawler();
    	String[] seeds = {"http://www.open-open.com/jsoup/dom-navigation.htm"};
    	crawler.crawling(seeds);
    	
    }
}
