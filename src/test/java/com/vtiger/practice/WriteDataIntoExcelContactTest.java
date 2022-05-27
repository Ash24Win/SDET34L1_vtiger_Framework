package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataIntoExcelContactTest 
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

		FileInputStream fisEx = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisEx);

		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		String lastName = wb.getSheet("contacts").getRow(2).getCell(1).getStringCellValue()+randomNumber;

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

		if(driver.getTitle().contains("Home"))
		{
			wb.getSheet("contacts").getRow(3).createCell(5).setCellValue("Homepage is Displayed");
			wb.getSheet("contacts").getRow(3).createCell(6).setCellValue("pass");

		}

		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
		{
			wb.getSheet("contacts").getRow(4).createCell(5).setCellValue("Contacts page is Displayed");
			wb.getSheet("contacts").getRow(4).createCell(6).setCellValue("pass");

		}

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		if(driver.getTitle().contains("Creating"))
		{
			wb.getSheet("contacts").getRow(5).createCell(5).setCellValue("Create Contacts page is Displayed");
			wb.getSheet("contacts").getRow(5).createCell(6).setCellValue("pass");

		}

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("trump4");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		WebElement ActualFirstName = driver.findElement(By.id("dtlview_First Name"));
		WebElement ActualLastName = driver.findElement(By.id("dtlview_Last Name"));

		if(ActualLastName.getText().equalsIgnoreCase(lastName))
		{
			System.out.println("contact created Successfully");
			System.out.println("tc pass");
		}

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();

	}
}
