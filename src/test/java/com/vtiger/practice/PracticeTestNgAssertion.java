package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNgAssertion {
	
	
	@Test
	public void practiceTest() {
		Reporter.log("TestNGPracticeTest-->  A",true);
		Reporter.log("TestNGPracticeTest-->  B",true);
		Assert.assertEquals(true, false);
		Reporter.log("TestNGPracticeTest-->  C",true);
		Reporter.log("TestNGPracticeTest-->  D",true);
		Reporter.log("TestNGPracticeTest-->  E",true);
		
	}

	
	@Test
	public void practice2Test() {
		Reporter.log("TestNGPracticeTest-->  A",true);
		Reporter.log("TestNGPracticeTest-->  B",true);
		Reporter.log("TestNGPracticeTest-->  C",true);
		Reporter.log("TestNGPracticeTest-->  D",true);
		Reporter.log("TestNGPracticeTest-->  E",true);
	}
}
