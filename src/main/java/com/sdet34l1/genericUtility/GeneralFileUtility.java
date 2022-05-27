package com.sdet34l1.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only methods to handle property file
 * @author omc
 *
 */

public class GeneralFileUtility {

	static Properties property;
	/**
	 * This method is used to open the data from property file
	 * @throws IOException 
	 */
	public static void ToOpenPropertyfile(String path) throws IOException
	{
		FileInputStream fis = new FileInputStream(path );
		property = new Properties();
		property.load(fis);
	}
/**
 * This method is used to get data from property file 
 * @param key
 * @return
 * @throws IOException
 */
	public static String getDataFromPropertyFile(String key) throws IOException 
	{
		String value = property.getProperty(key);
		return value;
	}
}





