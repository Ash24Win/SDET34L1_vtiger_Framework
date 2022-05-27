package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralFileUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataIntoExcelContactTest2 extends BaseClass
{
@Test	
	public void writeDataIntoExcelContactTest2() throws IOException 
	{
		
		GeneralExcelUtility.setExcelFile("contacts", 0, 0, "Login Page is Displayed");
		GeneralExcelUtility.setExcelFile("contacts", 0, 1, "TC PASS");
		
		GeneralExcelUtility.saveExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		ContactsPage contactsPage = new ContactsPage(driver);
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		
		GeneralExcelUtility.openExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		GeneralExcelUtility.setExcelFile("contacts", 1, 0, "Homepage is Displayed");
		GeneralExcelUtility.setExcelFile("contacts", 1, 1, "TC PASS");
		GeneralExcelUtility.saveExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		
		homepage.contactsTab();
		GeneralExcelUtility.openExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		GeneralExcelUtility.setExcelFile("contacts", 2, 0, "Contacts page is Displayed");
		GeneralExcelUtility.setExcelFile("contacts", 2, 1, "TC PASS");
		GeneralExcelUtility.saveExcel(GeneralIConstantUtility.PATHOFEXCELFILE);

		contactsPage.createContactBtn();
		GeneralExcelUtility.openExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		GeneralExcelUtility.setExcelFile("contacts", 3, 0, "Create Contact page is Displayed");
		GeneralExcelUtility.setExcelFile("contacts", 3, 1, "TC PASS");
		GeneralExcelUtility.saveExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		
		createNewContactPage.lastNameTxt();
		homepage.signout(driver);
		GeneralExcelUtility.openExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		GeneralExcelUtility.setExcelFile("contacts", 4, 0, "LogOut");
		GeneralExcelUtility.setExcelFile("contacts", 4, 1, "TC PASS");
		GeneralExcelUtility.saveExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
	}
}
