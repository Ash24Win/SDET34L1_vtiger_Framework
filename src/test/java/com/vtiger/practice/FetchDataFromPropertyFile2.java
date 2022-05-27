package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.sdet34l1.genericUtility.GeneralFileUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;

public class FetchDataFromPropertyFile2 
{

	public static void main(String[] args) throws IOException 
	{
	
		GeneralFileUtility.ToOpenPropertyfile(GeneralIConstantUtility.PATHOFPROPERTYFILE);
		
		
		String url = GeneralFileUtility.getDataFromPropertyFile("url");
		String username = GeneralFileUtility.getDataFromPropertyFile("userName");
		String password = GeneralFileUtility.getDataFromPropertyFile("password");
		String browser = GeneralFileUtility.getDataFromPropertyFile("browser");
		String timeout = GeneralFileUtility.getDataFromPropertyFile("timeout");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(browser);
		System.out.println(timeout);
		
		
	}
}
