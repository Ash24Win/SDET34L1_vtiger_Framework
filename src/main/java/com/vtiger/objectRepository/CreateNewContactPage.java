package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTxt;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement OrganizationBtn;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchOrganization;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchSaveBtn;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement selectItem;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void lastNameTxt() {
		lastNameTxt.sendKeys("trump");
	}

	public void saveBtn() {
		saveBtn.click();
	}
	
	public void lastNameTxt(String data) {
		lastNameTxt.sendKeys(data);
	}
	
	public void OrganizationBtn() {
		OrganizationBtn.click();
	}
	
	public void searchOrganization(String data) {
		searchOrganization.sendKeys(data);
	}
	
	public void searchSaveBtn() {
		searchSaveBtn.click();
	}
	
	public void selectItem() {
		selectItem.click();
	}
}

