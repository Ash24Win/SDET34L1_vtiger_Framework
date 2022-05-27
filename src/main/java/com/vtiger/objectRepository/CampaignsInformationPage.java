package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private static  WebElement Fetch;
	

	//intialize
	public CampaignsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//lib

	public String Fetch() {
		return Fetch.getText();
	}

	
}