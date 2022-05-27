package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	@FindBy(xpath="//input[@class='detailedViewTextBox']")
	private WebElement organizationTxt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typeDropDown;
	
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void organizationTxt(String data) {
		organizationTxt.sendKeys(data);
		saveBtn.click();
	}
	
	public void saveBtn() {
		saveBtn.click();
	}
	
	public void industryDropDown() {
		industryDropDown.click();
		
	}
	
	public void typeDropDown() {
		typeDropDown.click();
		
	}
	public WebElement industryDropDown1() {
		return industryDropDown;
	}
	
	public WebElement typeDropDown1() {
		return typeDropDown;
	}
}


