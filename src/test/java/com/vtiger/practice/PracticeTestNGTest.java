package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNGTest {

	@Test
	public void PracticeTestNGTest() {
		Reporter.log("TC Pass");
	}
	
	public static void main(String[] args) {
		System.out.println("Tc pass");
	}
	
	@Test
	public void PracticeTestNGTest1() {
		Reporter.log("TC 1 Pass ");
	}
	
	@Test
	
	public void PracticeTestNGTest2() {
		Reporter.log("TC 2 Pass",true);
	}
	
	@Test
	public void PracticeTestNGTest3() {
		Reporter.log("TC 3 pass", false);
	}
}
