package com.qa.Clockify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.util.ElementUtil;
import com.qa.Clockify.util.SiteConstants;


public class SettingsPage extends BasePage {
	
	WebDriver driver ;
	ElementUtil elementUtil ;
    // 	1. Locators  - By 
	By WorkspaceName = By.xpath("//input[@placeholder= 'Workspace name']");
	By UploadPhotobutton  = By.xpath("//label[@class= 'cl-btn pointer cl-mb-0 cl-btn-primary']");
	
	
	

	public SettingsPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}
	
	//2. Page Actions
	
	public String getpageTitle() {	
		elementUtil.waitForTitlePresent(SiteConstants.SETTINGS_PAGE_TITLE);
		return elementUtil.dogetPageTitle();
	}
	
	
	public boolean checkWorkSpaceName() {	
		return elementUtil.doisDisplayed(WorkspaceName);
	}
	
	
	public boolean checkUploadPhotobutton() {	
		return elementUtil.doisDisplayed(UploadPhotobutton);
		
	}
	
	public void doUploadPhoto() {	
		elementUtil.doSendKeys(UploadPhotobutton, "C:\\Users\\Thinksysuser\\Desktop\\SmileyImage.jpg");
		
	}
	
	

}
