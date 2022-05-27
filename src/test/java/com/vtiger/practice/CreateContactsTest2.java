package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest2 

{

	public static void main(String[] args) 
	{
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		GeneralWebDriverUtility.waitTillLoad(driver, 10);
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("SDET356");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String cont = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		GeneralJavaUtility.printStatement(cont);
		if(cont.contains("SDET356"))
		{
			GeneralJavaUtility.printStatement("pass");
		}
		else
		{
			GeneralJavaUtility.printStatement("fail");
		}
		WebElement log = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		GeneralWebDriverUtility.mouseHoverOnTheElement(driver, log);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		GeneralWebDriverUtility.quitBrowser(driver);
	}
	
}
