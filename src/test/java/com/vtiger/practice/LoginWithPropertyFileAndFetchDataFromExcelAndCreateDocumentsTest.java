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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithPropertyFileAndFetchDataFromExcelAndCreateDocumentsTest 
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

		Row row = sheet.getRow(11);

		//get the control on cell

		Cell cell = row.getCell(1);

		//fetch the data from the cell

		String data = cell.getStringCellValue();

		Random ran = new Random();
		int random = ran.nextInt(1000);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.xpath("//a[.='Documents']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(data+random);


		//get the control on row

		Row row1 = sheet.getRow(11);

		//get the control on cell

		Cell cell1 = row.getCell(2);

		//fetch the data from the cell

		String data1 = cell1.getStringCellValue();

		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']"));
		driver.switchTo().frame(frame);
		WebElement e = driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		e.sendKeys(data1);
		e.sendKeys(Keys.CONTROL+"A");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@id='cke_5']")).click();
		driver.findElement(By.xpath("//a[@id='cke_6']")).click();
		driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys("C:\\Users\\omc\\OneDrive\\Desktop\\Data Driven testing 1.docx");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
