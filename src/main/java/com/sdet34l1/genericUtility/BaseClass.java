package com.sdet34l1.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to perform common actions
 * @author omc
 *
 */
public class BaseClass {
	public WebDriver driver;
	public String username;
	public String password;
	public String browser;
	public HomePage homepage;
	public LoginPage loginpage;
	public int randomNumber;
	
	/**
	 * This method is used to perform open excel, property file , connect to database
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforesuiteTest() throws IOException {
		GeneralFileUtility.ToOpenPropertyfile(GeneralIConstantUtility.PATHOFPROPERTYFILE);

		GeneralExcelUtility.openExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
	}
/**
 * This method is used to perform normal execution configurations(launch browser,navigate to app,browser settings
 * implicit wait,instance of POM class , instance of explicit wait,read common data.
 * @throws IOException
 */
	@BeforeClass(groups="baseclass")
	public void beforeclassTest() throws IOException {
		
		String url = GeneralFileUtility.getDataFromPropertyFile("url");
		//username = GeneralFileUtility.getDataFromPropertyFile("userName");
		username=System.getProperty("USERNAME");
		System.out.println(username);
		//password = GeneralFileUtility.getDataFromPropertyFile("password");
		password=System.getProperty("PASSWORD");
		System.out.println(password);
		//String browser = GeneralFileUtility.getDataFromPropertyFile("browser");
		browser=System.getProperty("BROWSER");
		System.out.println(browser);
		String timeout = GeneralFileUtility.getDataFromPropertyFile("timeout");
		randomNumber = GeneralJavaUtility.getRandomNumber(100);
		Long longTimeout = GeneralJavaUtility.stringToLong(timeout);
		
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
			GeneralWebDriverUtility.goToApp(url, driver);
			GeneralWebDriverUtility.browserSetting(driver,longTimeout);
	}
	
	/**
	 * This method is used to perform login actions
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethod() {
		 loginpage = new LoginPage(driver);
		 homepage = new HomePage(driver);
		loginpage.loginAction(username, password);
	}
	
	/**
	 * This method is used to perform logout actions
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethod() {
		homepage.signout(driver);
	}
	
	/**
	 * This method is used to close browser
	 */
	@AfterClass(groups="baseclass")
	public void afterClass() {
		GeneralWebDriverUtility.quitBrowser(driver);
	}
	
	/**
	 * This method is used to close excel , database connections
	 * @throws IOException
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuite() throws IOException {
		GeneralExcelUtility.closeExcel();
	}
}
