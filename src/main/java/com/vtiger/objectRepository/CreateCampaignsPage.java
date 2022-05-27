package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
	//declaration
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampaignName;

	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement addProductsBtn;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement productSearchTxt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement productSearchBtn;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement selectOne;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement finalSaveBtn;
	
	
	//initiliaze
	public CreateCampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	


//library
	public void campaignName(WebDriver driver) {
		CampaignName.sendKeys("modi");
		savebtn.click();
	}
	
	public void campaignName(String data) {
		CampaignName.sendKeys(data);
	}
	
	public void addProductsBtn() {
		addProductsBtn.click();
	}
	
	public void productSearchTxt(String data) {
		productSearchTxt.sendKeys(data);
	}
	
	public void productSearchBtn() {
		productSearchBtn.click();
	}
	
	public void selectOne() {
		selectOne.click();
	}
	
	public void finalSaveBtn() {
		finalSaveBtn.click();
	}
	}


