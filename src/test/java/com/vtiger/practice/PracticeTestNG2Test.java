package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.GeneralExcelUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;

public class PracticeTestNG2Test {
	
	@Test
	public void practiceTestNG2Test() {
		Reporter.log("testcase1",true);
	}

	@Test(dataProvider = "logindata")
	public void practiceTestNG2Test(String username,String password) {
		Reporter.log(username+"------>"+password,true);
	}
	
	@DataProvider
	public Object[][] logindata() throws EncryptedDocumentException, IOException{
		GeneralExcelUtility.openExcel(GeneralIConstantUtility.PATHOFEXCELFILE);
		return GeneralExcelUtility.getMultipleDataFromExcel(GeneralIConstantUtility.PATHOFEXCELFILE, "Sheet2");
		
	}
	
	
}
