package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.GeneralWebDriverUtility;

// create class as webpage name and make it public
public class HomePage {
//declare all the elements and specify the access specifier
	@FindBy(linkText="More")
	private WebElement moreDropDown;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrorIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productsTab;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactsTab;
	
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement organizationTab;
	
	@FindBy(xpath="//a[.='Documents']")
	private WebElement documentsTab;
	
	//initalize the driver address to all the elements through constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public void clickCampaign(WebDriver driver) {
		GeneralWebDriverUtility.mouseHoverOnTheElement(driver, moreDropDown);
		campaignsTab.click();
	}
	
	public void signout(WebDriver driver) {
		GeneralWebDriverUtility.mouseHoverOnTheElement(driver, adminstrorIcon);
		signOutLink.click();
	}
	
	public void productsTab() {
		productsTab.click();
	}
	
	public void contactsTab() {
		contactsTab.click();
	}
	
	public void organizationTab() {
		organizationTab.click();
	}
	
	public void documentsTab() {
		documentsTab.click();
	}
	public WebElement contacts1Tab() {
		return contactsTab;
	}
	
	public WebElement signOutLink() {
		return signOutLink;
	}
	
}
