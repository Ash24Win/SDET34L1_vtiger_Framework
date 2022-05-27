package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithPropertyFileAndCreateContactTest 
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
		
		Long longTimeout = Long.parseLong(timeout);
		WebDriver driver =null;
		
		switch (browser)
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		
		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
		
		default:
			System.out.println("Please specify proper browser key");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("trump22");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		String a = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		if (a.contains("trump22")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
