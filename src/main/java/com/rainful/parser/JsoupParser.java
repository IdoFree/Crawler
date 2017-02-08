package com.rainful.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.bcel.generic.NEW;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser implements Parser {
	private static Parser parser = null;
	private static Document document;
	private JsoupParser(){
	}

	
	synchronized public static  Parser getInstance(String source){
		if(parser == null){
			document = Jsoup.parse(source);
			parser = new JsoupParser();
			return parser;
		}
		return parser;
	}




	@Override
	public String getDesciption() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getKeywords() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getCharSet() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> getUrlReferrence() {
		Elements links =  document.getElementsByTag("a");
		List<String> results = new ArrayList<>();
		for (Element link : links) {
			  String linkHref = link.attr("href");
			  String linkText = link.text();
			  results.add(linkHref);
			}
		return results;
	}


	@Override
	public void initParser(String source) {
		if(document == null){
			document=Jsoup.parse(source);
		}
		
	}


	@Override
	public void relaodSource(String source) {
		document=Jsoup.parse(source);
	}
	

}
