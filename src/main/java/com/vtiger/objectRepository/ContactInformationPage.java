package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	@FindBy(xpath="//td[@id='mouseArea_Last Name']")
	private WebElement fetchContactTxt;
	
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	public String fetchContactTxt() {
		return fetchContactTxt.getText();
	}
}
