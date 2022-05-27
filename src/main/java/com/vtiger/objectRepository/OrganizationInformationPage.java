package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement FetchOrganizationTxt;
	
	
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String FetchOrganizationTxt() {
		return FetchOrganizationTxt.getText();
	}

}
