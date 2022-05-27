package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest 
{

	public static void main(String[] args) throws SQLException 
	{
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_P08");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("marie");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(ele);
		s.selectByVisibleText("On Goging");
		WebElement d = driver.findElement(By.xpath("//input[@name='teamSize']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('teamSize').value='5'");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Step1: Create Object for implemention class
		
				Driver driver1 = new Driver();
				
				//Step2: Register the driver with JDBC
				
				DriverManager.registerDriver(driver1);
				
				//Step3: Establish the database connection
				
				 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				
				//Step4: Create statement
				
				 Statement statement = connection.createStatement();
						
				//Step5: Execute Query
						
				ResultSet result = statement.executeQuery("select * from project;");
				
				//Step6: Validate (based on testcase)
				
				while(result.next())
				{
					System.out.println(result.getString(2));
				}
				
				//Step7: Close the connection
				
				connection.close();
		
	}
}
