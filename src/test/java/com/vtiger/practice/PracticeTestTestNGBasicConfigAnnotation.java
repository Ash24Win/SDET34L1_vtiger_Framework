package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class PracticeTestTestNGBasicConfigAnnotation {
	
	@BeforeSuite(groups = {"sanity","regression"})
		public void beforesuite1Test() {
		Reporter.log("beforesuite1",true);
	}

	@AfterSuite(groups = {"sanity","regression"})
		public void aftersuite1Test() {
		Reporter.log("aftersuite1",true);
	}
	
	@BeforeClass(groups = {"sanity","regression"})
		public void beforeClass1Test() {
		Reporter.log("beforeClass1",true);
	}
	
	@AfterClass(groups = {"sanity","regression"})
		public void afterClass1Test() {
		Reporter.log("afterClass1",true);
	}
	@BeforeTest(groups = {"sanity","regression"})
		public void beforeTest1Test() {
		Reporter.log("beforeTest1",true);
	}
	@AfterTest(groups = {"sanity","regression"})
		public void afterTest1Test() {
		Reporter.log("afterTest1",true);
	}
	@BeforeMethod(groups = {"sanity","regression"})
		public void beforeMethod1Test() {
		Reporter.log("beforeMethod1",true);
	}
	@BeforeMethod(groups = {"sanity","regression"})
		public void beforeMethod2Test() {
		Reporter.log("beforeMethod2",true);
	}
	@AfterMethod(groups = {"sanity","regression"})
		public void afterMethod1Test() {
		Reporter.log("afterMethod1",true);
	}
}
