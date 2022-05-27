package com.vtiger.productsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralDatabaseUtility;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralFileUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;
import com.vtiger.objectRepository.CreateProductsPage;
import com.vtiger.objectRepository.ProductsPage;

public class CreateProductsTest extends BaseClass
{
	@Test(groups = "sanity")

	public void createProductsTest() throws IOException 
	{
		String data = "iphone7s";
		ProductsPage productsPage = new ProductsPage(driver);
		CreateProductsPage createProductsPage = new CreateProductsPage(driver);
		homepage.productsTab();
		productsPage.createProduct();
		createProductsPage.productnameTxt(data+GeneralJavaUtility.getRandomNumber(500));
		String a = createProductsPage.fetchProductTxt();
		GeneralJavaUtility.assertionByIfElseStatement(a, data, "pass", "fail");	
	}
}
