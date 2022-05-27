package com.vtiger.campaignsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.vtiger.objectRepository.CampaignsInformationPage;
import com.vtiger.objectRepository.CampaignsPage;
import com.vtiger.objectRepository.CreateCampaignsPage;

public class CreateCampaignsTest extends BaseClass
{
	@Test(groups = "sanity")
	public void createCampaignsTest() throws IOException 
	{ 	
		CampaignsPage campaignsPage = new CampaignsPage(driver);
		CreateCampaignsPage createCampaignsPage = new CreateCampaignsPage(driver);
		CampaignsInformationPage campaignsInformationPage = new CampaignsInformationPage(driver);
		homepage.clickCampaign(driver);
		campaignsPage.createCampaignBtn();
		createCampaignsPage.campaignName(driver);
		String a=campaignsInformationPage.Fetch();
		GeneralJavaUtility.printStatement(a);
		GeneralJavaUtility.assertionByIfElseStatement(a, "modi", "pass", "fail");
	}	
	}

