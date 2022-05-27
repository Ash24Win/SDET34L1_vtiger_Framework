package com.vtiger.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest 

{

	public static void main(String[] args) 
	{
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("SDET356");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String cont = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(cont);
		if(cont.contains("SDET356"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement log = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		Actions act = new Actions(driver);
		act.moveToElement(log).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();	
	}
	
}
