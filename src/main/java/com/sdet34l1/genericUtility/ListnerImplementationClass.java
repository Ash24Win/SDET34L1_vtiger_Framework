package com.sdet34l1.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void  onStart(ITestContext context) {
		System.out.println("OnStart");
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentreport/extentReport.html");
		spark.config().setDocumentTitle("");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Reporter Name", "Ashwin S");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Unit testing tool", "TestNG");
		report.setSystemInfo("Build Managment Tool", "Maven");
		report.setSystemInfo("Automation tool", "Selenium");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		test= report.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			new GeneralWebDriverUtility(BaseClass.class.cast(result.getMethod().getInstance()).driver);
			test.addScreenCaptureFromPath(GeneralWebDriverUtility.takeScreenShotAndReturnPath(result.getMethod().getMethodName(),(WebDriver) BaseClass.class.cast(result.getMethod().getInstance())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish");
		report.flush();
	}
	
}
