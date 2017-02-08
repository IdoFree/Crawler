package com.rainful.crawler;

import java.util.List;

import com.rainful.entity.PageInfo;

public interface ComputeUrl {
	List<String> getNewUrls(PageInfo pageInfo);

	boolean accept(PageInfo pageInfo);

}
