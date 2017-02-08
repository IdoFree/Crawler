package com.rainful.crawler;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.rainful.entity.PageInfo;

public interface Frontier {
	public PageInfo getContent (String targetUrl)throws IOException;
	/**
	 * 
	 * @param url
	 * @return if return true,mean the url is not gonna be deal with
	 */
	public boolean filterUrl(String url);
	
}	
