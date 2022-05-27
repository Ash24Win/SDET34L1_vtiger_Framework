package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithPropertyFileAndFetchDataFromExcelAndCreateOrganizationAndHandleDropDownTest 
{
	public static void main(String[] args) throws IOException, InterruptedException 
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

		//convert the physical file into java readable object

		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// open the excel

		Workbook wb = WorkbookFactory.create(fis1);

		//get the control on sheet

		Sheet sheet = wb.getSheet("Sheet1");

		//get the control on row

		Row row = sheet.getRow(5);

		//get the control on cell

		Cell cell = row.getCell(1);

		//fetch the data from the cell

		String data = cell.getStringCellValue();

		Random ran = new Random();
		int random = ran.nextInt(1000);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(data+random);

		WebElement drop1 = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(drop1);
		s.selectByValue("Education");
		Thread.sleep(2000);

		WebElement drop2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s1 = new Select(drop2);
		s1.selectByValue("Press");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);
		
		WebElement q = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions acti=new Actions(driver);
		acti.moveToElement(q).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();

	}

}
