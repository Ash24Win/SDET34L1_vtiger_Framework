package com.vtiger.organizationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass
{
@Test(groups = "sanity")
	public void createOrganizationTest() throws IOException 
	{
		
		OrganizationPage organizationPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrganizationPage = new CreateOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
		homepage.organizationTab();
		organizationPage.createOrganizationBtn();
		String data = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 1);
		createOrganizationPage.organizationTxt(data+randomNumber);
		GeneralJavaUtility.assertionByIfElseStatement(organizationInformationPage.FetchOrganizationTxt(), data, "pass", "fail");
	}
}
