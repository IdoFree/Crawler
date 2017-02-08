package com.rainful.logger;

public class ConsoleLogger implements Logger {

	@Override
	public void info(String msg) {
		print(msg);
	}

	@Override
	public void warn(String msg) {
		print(msg);
	}

	@Override
	public void error(String msg) {
		System.err.println(msg);
	}
	
	private void print(String msg){
		System.out.println(msg);
	}
}
