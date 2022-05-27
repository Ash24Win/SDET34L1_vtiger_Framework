package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.GeneralJavaUtility;

public class ProductsPage {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;
	
	@FindBy(xpath="//input[@class='detailedViewTextBox']")
	private WebElement createNewProductbtn;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void createProduct() {
		createProduct.click();
	}
	
	public void saveBtn() {
		saveBtn.click();
	}
	
	public void createNewProductbtn(String data) {
		createNewProductbtn.sendKeys(data);
		saveBtn.click();
	}

}
