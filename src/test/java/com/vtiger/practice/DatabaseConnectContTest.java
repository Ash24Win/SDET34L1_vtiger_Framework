package com.vtiger.practice;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;

	import com.mysql.cj.jdbc.Driver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DatabaseConnectContTest {
		static Connection connection=null;
		static	String URL=null,UN=null,PW=null,BS=null;
		static WebDriver driver1;
		public static void main(String[] args) throws SQLException {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet34", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from vtiger;");
			while (result.next()) {
				URL = result.getString("url");
				UN = result.getString("username");
				PW = result.getString("password");
				BS = result.getString("browser");
			}
			if (BS.equalsIgnoreCase("chrome")) {
				WebDriverManager.firefoxdriver().setup();
				driver1=new FirefoxDriver();
				driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver1.manage().window().maximize();
				driver1.get(URL);
			} else if(BS.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver1=new FirefoxDriver();
				driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver1.manage().window().maximize();
				driver1.get(URL);
			}

			driver1.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
			driver1.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PW);
			driver1.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver1.findElement(By.xpath("//a[.='Contacts']")).click();
			driver1.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver1.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ruby");
			driver1.findElement(By.xpath("//input[@value='  Save  ']")).click();
			String a = driver1.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
			if (a.contains("ruby")) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}
			WebElement ele = driver1.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver1);
			act.moveToElement(ele).perform();
			driver1.findElement(By.linkText("Sign Out")).click();
			driver1.quit();
		}

	}



	

