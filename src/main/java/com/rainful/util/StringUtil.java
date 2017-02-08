package com.rainful.util;

public class StringUtil {
	public static boolean isEmpty(String s){
		if(s == null || s.equals("") ){
			return true;
		}else {
			return false;
		}
	}
}
