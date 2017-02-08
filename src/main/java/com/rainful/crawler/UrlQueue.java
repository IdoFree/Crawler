package com.rainful.crawler;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UrlQueue {
	private static Queue<String> unvistiedUrl = new PriorityQueue<String>();
	private static List<String> vistiedUrl = new LinkedList<>();
	
	public static void addUnvisitedUrl(String url) {
		getUnvistiedUrl().add(url);
	}

	public static void addvisitedUrl(String url) {
		getVistiedUrl().add(url);
		
	}

	public static String getNextUrl() {
		return getUnvistiedUrl().poll();
	}

//	public static boolean filterUrl(String url) {
//		if(unvistiedUrl.contains(url)){
//			return true;
//		}
//		return false;
//	}

	public static int getUnvisitedUrlSize() {
		return getUnvistiedUrl().size();
	}

	public static Queue<String> getUnvistiedUrl() {
		return unvistiedUrl;
	}

	public static void setUnvistiedUrl(Queue<String> unvistiedUrl) {
		UrlQueue.unvistiedUrl = unvistiedUrl;
	}

	public static List<String> getVistiedUrl() {
		return vistiedUrl;
	}

	public static void setVistiedUrl(List<String> vistiedUrl) {
		UrlQueue.vistiedUrl = vistiedUrl;
	}
}
