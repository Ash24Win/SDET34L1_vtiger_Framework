package com.vtiger.contactsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactPage;

public class CreateContactTest extends BaseClass
{

	@Test(groups = "sanity")
	public void createContactTest() throws IOException 
	{
		ContactsPage contactsPage = new ContactsPage(driver);
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
		homepage.contactsTab();
		contactsPage.createContactBtn();
		createNewContactPage.lastNameTxt();
		createNewContactPage.saveBtn();
		GeneralJavaUtility.assertionByIfElseStatement(contactInformationPage.fetchContactTxt(), "trump", "pass", "fail");
	}
}
