package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTest1 extends PracticeTestTestNGBasicConfigAnnotation{

	@Test
	public void practice1Test() {
		Reporter.log("TestNGPractice1Test-->  Test1",true);
	}
	
	@Test
	public void practice2Test() {
		Reporter.log("TestNGPractice2Test-->  Test2",true);
	}
	
	@Test
	public void practice3Test() {
		Reporter.log("TestNGPractice3Test-->  Test3",true);
	}
	
}
