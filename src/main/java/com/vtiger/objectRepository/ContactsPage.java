package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactBtn;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void createContactBtn() {
		createContactBtn.click();
	}

	
	public void saveBtn() {
		saveBtn.click();
	}
}
