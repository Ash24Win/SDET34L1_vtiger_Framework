 package com.vtiger.contactsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass
{
	@Test(groups="regression")
	public void createContactWithOrganizationTest() throws IOException, InterruptedException 
	{
		OrganizationPage organizationPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrganizationPage = new CreateOrganizationPage(driver);
		ContactsPage contactsPage = new ContactsPage(driver);
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		String data = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 1);
		homepage.organizationTab();
		organizationPage.createOrganizationBtn();
		createOrganizationPage.organizationTxt(data+GeneralJavaUtility.getRandomNumber(900));
		GeneralJavaUtility.customWait(homepage.contacts1Tab(), 2000, 1);
		homepage.contactsTab();
		contactsPage.createContactBtn();
		String data1 = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 2);
		createNewContactPage.lastNameTxt(data1+GeneralJavaUtility.getRandomNumber(900));
		createNewContactPage.OrganizationBtn();
		GeneralWebDriverUtility.switchToWindowBasedOnTitle(driver, "Accounts&action");
		createNewContactPage.searchOrganization(data1);
		createNewContactPage.selectItem();
		GeneralWebDriverUtility.switchToWindowBasedOnTitle(driver, "Contacts&action");
		contactsPage.saveBtn();
	}
}
