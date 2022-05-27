package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUIWRTDatabase 
{

	public static void main(String[] args) throws SQLException
	{
	
		//Step1: Create Object for implemention class
		
		Driver driver1 = new Driver();
		
		//Step2: Register the driver with JDBC
		
		DriverManager.registerDriver(driver1);
		
		//Step3: Establish the database connection
		
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		//Step4: Create statement
		
		 Statement statement = connection.createStatement();
				
		//Step5: Execute Query
				
		  statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size) values('TY_PROJ_009','smithi','28/04/2022','TY_P09','On Going','3');");
		
		connection.close();

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		List<WebElement> we = driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
		  
for (WebElement web : we) 
{

	if(web.getText().equalsIgnoreCase("TY_P07"))
	{
		System.out.println("Project name is visible in GUI");
		System.out.println("TC Pass");
		break;
	}
}		
			
driver.quit();		
		
	}
	
}

