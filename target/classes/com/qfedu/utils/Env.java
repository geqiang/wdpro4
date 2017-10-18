package com.qfedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env extends Properties {
	
	private static final long serialVersionUID = 1L;
	private static Env instance = null;
	private Env(){
		InputStream is = getClass().getResourceAsStream("/db.properties");
		try {
			load(is);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public static Env getInstance(){
		
		if(instance == null){
			makeInstance();
			
		}
		return instance;
		
		
	}
	private static synchronized void makeInstance(){
		if(instance ==null){
			
			instance = new Env();
		}
	}

}
