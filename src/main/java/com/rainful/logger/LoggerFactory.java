package com.rainful.logger;

import com.rainful.constants.LoggerType;

public class LoggerFactory {
	private static Logger logger = null;
	public static Logger getLogger(int logerType){
		if(logger!=null)
			return logger;
		
		switch (logerType) {
		case LoggerType.CONSOLE:
			logger = new ConsoleLogger();
			return logger;
		default:
			break;
		}
		
		return null;
	}
	
	public static Logger getLogger(){
		if(logger!=null)
			return logger;
		logger =  new ConsoleLogger(); 
		return logger;
		
	}
	
	
	
}
