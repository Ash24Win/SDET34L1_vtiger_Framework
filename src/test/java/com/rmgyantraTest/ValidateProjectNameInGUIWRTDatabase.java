package com.rmgyantraTest;

import java.io.IOException;
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
import com.sdet34l1.genericUtility.GeneralDatabaseUtility;
import com.sdet34l1.genericUtility.GeneralFileUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUIWRTDatabase 
{

	public static void main(String[] args) throws SQLException, IOException
	{
	
		GeneralFileUtility.ToOpenPropertyfile(GeneralIConstantUtility.RMGYANTRAPROPERTYFILE);
		GeneralDatabaseUtility.openDBConnection(GeneralIConstantUtility.DATABASEURL+"projects", GeneralFileUtility.getDataFromPropertyFile("dBUserName"), GeneralFileUtility.getDataFromPropertyFile("dBPassword"));
		int ran = GeneralJavaUtility.getRandomNumber(100);
		String project = "modi_"+ran+"";
		String projectid = "TY_PROJ_"+ran+"";
		String projectName = "TY_P_"+ran+"";
		String query = ("insert into project(project_id,created_by,created_on,project_name,status,team_size) values('"+projectid+"','"+project+"','28/04/2022','"+projectName+"','On Going','3');");		
		GeneralDatabaseUtility.setDataInDataBase(query);
		GeneralDatabaseUtility.closeDBConnection();
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

			  if(web.getText().equalsIgnoreCase("TY_P13"))
			  {
				  System.out.println("Project name is visible in GUI");
				  System.out.println("TC Pass");
				  break;
			  }
		  }		
		  
		  driver.quit();		
	}
	
}

