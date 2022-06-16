package com.demoproj.utilities;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
		
				pro.load(fis);
			
			
		    } catch (Exception e) {
			System.out.println("Exception is " +e.getMessage());
			
		    }
		
	}
	
	
	public String getApplicationURL() {
		String URL = pro.getProperty("baseURL");
		return URL;
		
	}
	
	public String getUsername() {
		String user = pro.getProperty("username");
		return user;
		
	}
	
	public String getPassword() {
		String psw = pro.getProperty("password");
		return psw;
		
	}
	
	public String getChromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
		
	}
	public String iepath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
		
	}
	public String getFirefoxth() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	    
}
