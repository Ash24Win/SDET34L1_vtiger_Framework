package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile 
{

	public static void main(String[] args) throws IOException 
	{
	
		//convert the file into java readble object
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//create object for properties class
		Properties property = new Properties();
		
		//load all keys
		property.load(fis);
		
		//fetch the data by using key
		String url = property.getProperty("url");
		String username = property.getProperty("userName");
		String password = property.getProperty("password");
		String browser = property.getProperty("browser");
		String timeout = property.getProperty("timeout");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(browser);
		System.out.println(timeout);
		
		
	}
}
