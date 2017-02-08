package com.rainful.crawler;

import java.io.IOException;
import java.util.List;

import com.rainful.dao.PageInfoDao;
import com.rainful.entity.PageInfo;

public class Crawler {
		Frontier frontier = null;
		ComputeUrl computeUrl = new PageRankComputeUrl();
		PageInfoDao pageInfoDao = null;
		public Crawler() {
			frontier = new HttpFrontier();
		}
		
		private void initCrawler(String[] seeds){
			for(String seed : seeds){
				UrlQueue.addUnvisitedUrl(seed);
			}
		}
		
		
		public void crawling(String[] seeds){
			initCrawler(seeds);
			//get content from the target url
			String targetUrl = null;
			while((targetUrl=UrlQueue.getNextUrl()) !=null && UrlQueue.getUnvisitedUrlSize() <1000){
				try {
					//if the url has been visited before or the is full fill the filter, then we just drop the url
					if(frontier.filterUrl(targetUrl)||UrlQueue.getVistiedUrl().contains(targetUrl)){
						continue;
					}
					PageInfo pageInfo  = frontier.getContent(targetUrl);
					// here to compute if the return page info contain what we need
					List<String> newSeeds = computeUrl.getNewUrls(pageInfo);
					if(computeUrl.accept(pageInfo)){
						pageInfoDao.save(pageInfo);
					}
					if(newSeeds!=null){
						for(String seed : newSeeds){
							UrlQueue.addUnvisitedUrl(seed);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
}
