package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productnameTxt;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement fetchProductTxt;
	
	public CreateProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void productnameTxt(String data) {
		productnameTxt.sendKeys(data);
		saveBtn.click();
	}

	public String fetchProductTxt() {
		return fetchProductTxt.getText();
	}
}
