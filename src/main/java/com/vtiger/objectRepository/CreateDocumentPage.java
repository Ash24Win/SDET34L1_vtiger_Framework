package com.vtiger.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.GeneralWebDriverUtility;

public class CreateDocumentPage {
	
	@FindBy(xpath="//input[@class='detailedViewTextBox']")
	private WebElement documentNameTxt;
	
	@FindBy(xpath="//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement iframe;
	
	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement border;
	
	@FindBy(xpath="//a[@id='cke_5']")
	private WebElement boldTxt;
	
	@FindBy(xpath="//a[@id='cke_6']")
	private WebElement italicTxt;
	
	@FindBy(xpath="//input[@id='filename_I__']")
	private WebElement uploadFile;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public CreateDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void documentNameTxt(String data) {
		documentNameTxt.sendKeys(data);
	}
	
	public WebElement iframe() {
		return iframe();
	}
	
	public WebElement border() {
		return border();
	}
	
	public void boldTxt() {
		boldTxt.click();
	}
	
	public void italicTxt() {
		italicTxt.click();
	}
	
	public void uploadFile(String path) {
		uploadFile.sendKeys(path);
	}
	
	public void saveBtn() {
		saveBtn.click();
	}
	
	public void documentCreation(String path, WebDriver driver, String desc) {
		WebElement frame = iframe;
		GeneralWebDriverUtility.switchToFrame(driver, frame);
		WebElement e = border;
		border.sendKeys(desc);
		border.sendKeys(Keys.CONTROL+"a");
		GeneralWebDriverUtility.switchToDefaultContent(driver);
		boldTxt.click();
		italicTxt.click();
		uploadFile.sendKeys(path);
		saveBtn.click();
	}
}

