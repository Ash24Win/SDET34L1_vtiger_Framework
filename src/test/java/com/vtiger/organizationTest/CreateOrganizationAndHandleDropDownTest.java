package com.vtiger.organizationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationAndHandleDropDownTest extends BaseClass
{
	@Test(groups="regression")
	public void createOrganizationAndHandleDropDownTest() throws IOException, InterruptedException 
	{
		OrganizationPage organizationPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrganizationPage = new CreateOrganizationPage(driver);
		String data = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 1);
		homepage.organizationTab();
		organizationPage.createOrganizationBtn();
		createOrganizationPage.organizationTxt(data+GeneralJavaUtility.getRandomNumber(300));	
		GeneralWebDriverUtility.handlingDropdownByValue(createOrganizationPage.industryDropDown1(), "Banking");
		GeneralWebDriverUtility.handlingDropdownByValue(createOrganizationPage.typeDropDown1(),"Competitor");
		GeneralJavaUtility.customWait(homepage.signOutLink(), 2000, 1);
		createOrganizationPage.saveBtn();
	}
}
