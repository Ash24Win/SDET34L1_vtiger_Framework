package com.vtiger.practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest 
{

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("SDET56");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(org);
		if(org.contains("SDET56"))
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
		driver.findElement(By.linkText("Sign Out")).click();
		}
	
}
