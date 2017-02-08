package com.rainful.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.rainful.crawler.Frontier;
import com.rainful.crawler.HttpFrontier;
import com.rainful.entity.PageInfo;

public class JunitTest {
//	@Test
	public void testGet(){
		Frontier frontier = new HttpFrontier();
		try {
			PageInfo content = frontier.getContent("http://op.hanhande.com/");
			System.out.println(content.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testLoadFile(){
		System.out.println(System.getProperty("classpath"));
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("application.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
