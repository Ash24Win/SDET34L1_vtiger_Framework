package com.vtiger.practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor 
{

	public static void main(String[] args) throws IOException 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		driver.manage().window().maximize();
		js.executeScript("window.location='http://localhost:8888'");
		js.executeScript("arguments[0].value='admin'", driver.findElement(By.name("user_name")));
		js.executeScript("arguments[0].value='admin'", driver.findElement(By.name("user_password")));
		js.executeScript("arguments[0].click()", driver.findElement(By.id("submitButton")));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td/div/div[8]/table[1]/tbody/tr/td[1]/b")));

		File src = ts.getScreenshotAs(OutputType.FILE);
		String fileName= new javaScriptExecutor().getClass().getName();
		String dataTime = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
		File dst =new File("./screenshot/"+fileName+"_"+dataTime+".png");
		System.out.println(dst.getAbsolutePath());
		Files.copy(src, dst);


	}




}
