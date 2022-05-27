package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithPropertyFileAndFetchDataFromExcelAndCreateCampaignsTest 
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

		Row row = sheet.getRow(8);

		//get the control on cell

		Cell cell = row.getCell(1);

		//fetch the data from the cell

		String data = cell.getStringCellValue();

		Random ran = new Random();
		int random = ran.nextInt(1000);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(data+random);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		//get the control on row

		Row row1 = sheet.getRow(8);

		//get the control on cell

		Cell cell1 = row1.getCell(2);

		//fetch the data from the cell

		String data1 = cell1.getStringCellValue();

		Thread.sleep(2000);
		WebElement abc = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(abc).perform();
		driver.findElement(By.linkText("More")).click();

		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data1+random);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

		Set<String> all_wh = driver.getWindowHandles();
		for(String wh:all_wh)
		{
			driver.switchTo().window(wh);
			if(driver.getTitle().contains("Products&action"))
			{
				break;
			}

		}

		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(data+random);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='1']")).click();

		Set<String> wh1 = driver.getWindowHandles();
		for(String w:wh1)
		{
			driver.switchTo().window(w);
			if(driver.getTitle().contains("Campaigns&action"))
			{
				break;
			}
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();	
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}


}
