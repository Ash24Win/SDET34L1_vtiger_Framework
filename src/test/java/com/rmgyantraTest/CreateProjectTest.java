package com.rmgyantraTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericUtility.GeneralDatabaseUtility;
import com.sdet34l1.genericUtility.GeneralFileUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest 
{

	public static void main(String[] args) throws SQLException, IOException 
	{
		GeneralFileUtility.ToOpenPropertyfile(GeneralIConstantUtility.RMGYANTRAPROPERTYFILE);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_P16");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("rambo2");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		GeneralWebDriverUtility.handlingDropdownByVisibleText(ele, "On Goging");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		GeneralWebDriverUtility.quitBrowser(driver);
		GeneralDatabaseUtility.openDBConnection(GeneralIConstantUtility.DATABASEURL+"DBName", GeneralFileUtility.getDataFromPropertyFile("dBUserName"), GeneralFileUtility.getDataFromPropertyFile("dBPassword"));
		GeneralDatabaseUtility.getDataFromDataBase("select * from project;", "project_name");
		GeneralDatabaseUtility.validateDataInDatabase("select * from project;", "project_name", "TY_P16");
		GeneralDatabaseUtility.closeDBConnection();
	}
}
