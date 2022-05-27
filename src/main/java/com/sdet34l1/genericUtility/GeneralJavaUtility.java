 package com.sdet34l1.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific common methods
 * @author omc
 *
 */

public class GeneralJavaUtility {

	/**
	 * This method is used to convert String value to Long Datatype
	 * @param value
	 * @return
	 */
	public static long stringToLong(String value) {
		return Long.parseLong(value);
	}
	
	/**
	 * This method is used to get random number
	 * @param limit
	 * @return
	 */
	public static int getRandomNumber(int limit) {
		Random ran = new Random();
		return ran.nextInt(limit);
	}
	/**
	 * This method is used to print message
	 * @param message
	 */
	public static void printStatement(String message) {
		System.out.println(message);
	}
	/**
	 * This method is used to verify using if block statements
	 * @param driver
	 * @param contain
	 * @param message
	 */
	
	public static void assertionByIfStatement(WebDriver driver,String contain, String message) {
		if(driver.getCurrentUrl().contains(contain)) {
			GeneralJavaUtility.printStatement(message);
		}
	}
	/**
	 * This method is used to verfiy using if and else block statements
	 * @param expectedValue
	 * @param actualValue
	 * @param element
	 * @param contain
	 */
	public static void assertionByIfElseStatement(String expectedValue,String actualValue,String ifValue,String elseValue) {
		if (expectedValue.contains(actualValue)) {
			GeneralJavaUtility.printStatement(ifValue);
		} else {
			GeneralJavaUtility.printStatement(elseValue);
		}
	}
	/**
	 * This method is used to provide custom wait
	 * @param element
	 * @param duration
	 * @param Polingtime
	 * @throws InterruptedException 
	 */
	public static void customWait(WebElement element, long duration , int Polingtime ) throws InterruptedException {
		int count=0;
		while(count<=duration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(Polingtime*500);
				count++;
			}
		}
	}
	/**
	 * This method is get date and time in format
	 */
	public static void dateTimeInFormat() {
		String dateTime = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
	}


	 
}
