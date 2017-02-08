package com.rainful.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private static Properties properties;
	
	public static String getProperties(String fileName,String key) throws FileNotFoundException, IOException{
		if(properties == null){
			properties = new Properties();
			properties.load(new FileReader(fileName));
		}
		String result =  properties.getProperty(key);
		return result;
	}

}
