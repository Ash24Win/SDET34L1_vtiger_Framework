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
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;

	import com.mysql.cj.jdbc.Driver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DatabaseConnectOrgzTest {
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
			switch (BS) {
			case "chrome":WebDriverManager.chromedriver().setup();
						  driver1=new ChromeDriver();
						  driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						  driver1.manage().window().maximize();
						  driver1.get(URL);
						  break;
			case "firefox":WebDriverManager.firefoxdriver().setup();
						   driver1=new FirefoxDriver();
						   driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						   driver1.manage().window().maximize();
						   driver1.get(URL);
						   break;

			default:System.out.println("pls spesify browser key");
					break;
			}

			driver1.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
			driver1.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PW);
			driver1.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver1.findElement(By.xpath("//a[.='Organizations']")).click();
			driver1.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver1.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("test3");
			driver1.findElement(By.xpath("//input[@value='  Save  ']")).click();
			String a1 = driver1.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			System.out.println(a1);
			if (a1.contains("test3")) {
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

	

