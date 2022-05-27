package com.vtiger.campaignsTest;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;
import com.vtiger.objectRepository.CampaignsPage;
import com.vtiger.objectRepository.CreateCampaignsPage;
import com.vtiger.objectRepository.ProductsPage;

public class CreateCampaignsWithProductsTest extends BaseClass
{

	@Test(groups="regression")
	public void createCampaignsWithProductsTest() throws IOException, InterruptedException 
	{	ProductsPage productspage = new ProductsPage(driver);
		CampaignsPage campaignsPage = new CampaignsPage(driver);
		CreateCampaignsPage createCampaignsPage = new CreateCampaignsPage(driver);
		String data = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 1);
		homepage.productsTab();
		productspage.createProduct();
		productspage.createNewProductbtn(data+GeneralJavaUtility.getRandomNumber(500));
		String data1 = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 2);
		homepage.clickCampaign(driver);
		campaignsPage.createCampaignBtn();
		createCampaignsPage.campaignName(data1+GeneralJavaUtility.getRandomNumber(500));
		createCampaignsPage.addProductsBtn();		
		GeneralWebDriverUtility.switchToWindowBasedOnTitle(driver, "Products&action");
		createCampaignsPage.productSearchTxt(data);
		createCampaignsPage.productSearchBtn();
		createCampaignsPage.selectOne();
		GeneralWebDriverUtility.switchToWindowBasedOnTitle(driver, "Campaigns&action");
		createCampaignsPage.finalSaveBtn();
	}
}
