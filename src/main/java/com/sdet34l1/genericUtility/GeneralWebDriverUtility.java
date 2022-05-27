package com.sdet34l1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains common methods to handle selenium actions
 * @author omc
 *
 */

public class GeneralWebDriverUtility {
	public GeneralWebDriverUtility(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method is used to go to app
	 * @param url
	 * @param driver
	 */
	public static void goToApp(String url,WebDriver driver) {
		driver.get(url);
	}
	/**
	 * This method is used to maximize the browser and implicitly wait
	 * @param driver
	 */
	public static void browserSetting(WebDriver driver,long longTimeOut) {
		maximizeBrowser(driver);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicitly wait till page is loaded
	 * @param driver
	 */
	public static void waitTillLoad(WebDriver driver,long longTimeOut) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to mouse hover on the element
	 * @param driver
	 * @param ele
	 */
	public static void mouseHoverOnTheElement(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method is used to quit the browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method used to handle dropdowns
	 * @param drop1
	 * @param Value
	 */
	public static void handlingDropdownByValue(WebElement element,String Value) {
		Select s = new Select(element);
		s.selectByValue(Value);
	}
	/**
	 * This method is used to switch to frame
	 * @param driver
	 * @param value
	 */
	public static void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to frame element as string
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver, String element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to frame based on index
	 * @param driver
	 * @param value
	 */
	public static void switchToFrameBasedOnIndex( WebElement index,WebDriver driver) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame base on name or id
	 * @param index
	 * @param driver
	 */
	public static void switchToFrameBasedOnNameOrID(WebDriver driver,WebElement nameOrId ) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch to defaultContent
	 * @param driver
	 */
	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to handle dropdown by visible text
	 * @param drop1
	 * @param VisibleText
	 */
	public static void handlingDropdownByVisibleText(WebElement element,String VisibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	/**
	 * This method is used to handle dropdown by index
	 * @param drop
	 * @param Index
	 */
	public static void handlingDropdownByIndex(WebElement element,int Index) {
		Select s = new Select(element);
		s.selectByIndex(Index);
	}
	/**
	 * This method is used to wait the control till the particular element is clickable
	 * @param driver
	 * @param element
	 */
	public static void waitUntilElementClikable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to switch to window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText) {
		Set<String> sessionIDs = driver.getWindowHandles();
		for (String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to perform double click 
	 * @param element
	 * @param driver
	 */
	public static void doubleClick(WebElement element, WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * This metod is used to enter data through java script executor
	 * @param driver
	 * @param element
	 * @param data
	 */
	public static void enterDataThroughJs(WebDriver driver, WebElement element,String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	/**
	 * This method is used to navigate application through java script executor
	 * @param driver
	 */
	public static void navigateAppThroughJs(WebDriver driver,String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * This method is used to scroll to specific height 
	 * @param driver
	 * @param height
	 */
	public static void scrollToSepecificHeight(WebDriver driver,String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+height+")");
	}
	/**
	 * This method is used to scroll till bottom of webpage
	 * @param driver
	 */
	public static void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll till the specific element
	 * @param driver
	 * @param element
	 */
	public static void scrollTillElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @throws IOException 
	 */
	public static void takeScreenShot(String fileName, WebDriver driver) throws IOException { 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+".png");
		System.out.println(dst.getAbsolutePath());
		Files.copy(src, dst);
		
	}
	/**
	 * This method is used to take screenshot and return path
	 * @param fileName
	 * @param baseClass
	 * @return
	 * @throws IOException
	 */
	public static String takeScreenShotAndReturnPath(String fileName, WebDriver driver) throws IOException { 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
		
	}
	/**
	 * This method is used to accept the alert
	 * @param driver
	 */
	public static void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	/**
	 * This method is used to dismiss the alert
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	/**
	 * This method is used to send data into alert
	 * @param driver
	 * @param data
	 */
	public static void alertSendData(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
		
	}
	/**
	 * This method is used to get text from alert
	 * @param driver
	 * @return
	 */
	public static String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
		
	}
	/**
	 * This method is used to perform rightclick actions  
	 * @param driver
	 */
	public static void rightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
		
	}
	/**
	 * This method is used to perform rightclick actions on specific element
	 * @param driver
	 * @param element
	 */
	public static void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method is to handle alert
	 * @param driver
	 */
	public static void handleAlert(WebDriver driver) {
	Alert a = driver.switchTo().alert();
	String message = a.getText();
	GeneralJavaUtility.printStatement(message);
	a.accept();
	
	}
	
	
	
}


