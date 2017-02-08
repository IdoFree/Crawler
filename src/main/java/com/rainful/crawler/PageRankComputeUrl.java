package com.rainful.crawler;

import java.util.List;

import com.rainful.entity.PageInfo;

public class PageRankComputeUrl implements ComputeUrl {


	@Override
	public boolean accept(PageInfo pageInfo) {
		if(pageInfo.getCharSet().equalsIgnoreCase("UTF-8")&&pageInfo.getContentType().equalsIgnoreCase("html/text")&&pageInfo.getDescription().contains("电影")){
			return false;
		}
		return true;
	}

	@Override
	public List<String> getNewUrls(PageInfo pageInfo) {
		return pageInfo.getUrlReferrence();
	}

}
