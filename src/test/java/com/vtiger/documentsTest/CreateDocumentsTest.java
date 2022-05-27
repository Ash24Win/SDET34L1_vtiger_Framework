package com.vtiger.documentsTest;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralJavaUtility;
import com.sdet34l1.genericUtility.GeneralWebDriverUtility;
import com.vtiger.objectRepository.CreateDocumentPage;
import com.vtiger.objectRepository.DocumentsPage;

public class CreateDocumentsTest extends BaseClass
{
	@Test(groups = "sanity")
	public void createDocumentsTest() throws IOException, InterruptedException 
	{
		DocumentsPage documentsPage = new DocumentsPage(driver);
		CreateDocumentPage createDocumentPage = new CreateDocumentPage(driver);
		String data = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 1);
		homepage.documentsTab();
		documentsPage.createDocumentbtn();
		createDocumentPage.documentNameTxt(data+GeneralJavaUtility.getRandomNumber(900));
		createDocumentPage.documentCreation(GeneralExcelUtility.getDataFromExcel("Sheet1", 7, 1), driver, GeneralExcelUtility.getDataFromExcel("Sheet1", 5, 1));
	}
}
