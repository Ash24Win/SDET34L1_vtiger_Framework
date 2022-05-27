package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTestt extends PracticeTestTestNGBasicConfigAnnotation{

	@Test(groups ="sanity")
	public void practice1Test() {
		Reporter.log("TestNGPractice1Test-->  Test1",true);
	}
	
	@Test(groups = "regression")
	public void practice2Test() {
		Reporter.log("TestNGPractice2Test-->  Test2",true);
	}
	
	@Test(groups ="sanity")
	public void practice3Test() {
		Reporter.log("TestNGPractice3Test-->  Test3",true);
	}
	
	@Test(groups = "regression")
	public void practice4Test() {
		Reporter.log("TestNGPractice4Test-->  Test4",true);
	}
	
	@Test(groups = {"sanity","regression"})
	public void practice5Test() {
		Reporter.log("TestNGPractice5Test-->  Test5",true);
	}
	
}
