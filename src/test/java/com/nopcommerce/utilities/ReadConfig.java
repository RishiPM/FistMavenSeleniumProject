package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception found is "+e.getMessage());
		}
	}
	
	public String getBaseURL() {
		String bURL = pro.getProperty("baseURL");
		return bURL;
	}
	
	public String getUsername() {
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromeDriver() {
		String cpath = pro.getProperty("chromepath");
		return cpath;
	}
	
	public String getFirefoxDriver() {
		String fpath = pro.getProperty("firefoxpath");
		return fpath;
	}
	
	public String getEdgeDriver() {
		String epath = pro.getProperty("edgepath");
		return epath;
	}
}
