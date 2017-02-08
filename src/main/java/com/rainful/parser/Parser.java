package com.rainful.parser;

import java.io.InputStream;
import java.util.List;

public interface Parser {
	public void relaodSource(String source);
	public void initParser(String source);
	public String getDesciption();
	public String getKeywords();
	public String getContentType();
	public String getCharSet();
	public List<String> getUrlReferrence();
}
