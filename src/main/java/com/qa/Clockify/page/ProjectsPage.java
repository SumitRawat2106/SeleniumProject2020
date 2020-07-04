package com.qa.Clockify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.util.ElementUtil;

public class ProjectsPage extends BasePage {
	
	WebDriver driver ;
	ElementUtil elementUtil ;

    // 	1. Locators  - By 
	By CreateNewProjectLink = By.xpath("//a[@class= 'cl-btn cl-btn-outline-primary']");
	By headertext = By.xpath("//h1[text()='Projects']");
	
	public ProjectsPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}
	
	//2. Page Actions
	public String getProjectPageTitle() {
		return elementUtil.dogetPageTitle();
		
	}
	
	public String getPageHeader() {
		return elementUtil.dogetText(headertext);
		
	}
	
	
	
	public CreateNewProjectPage clickCreateNewProjectLink() {
		elementUtil.waitForElementVisible(CreateNewProjectLink);
		elementUtil.doClick(CreateNewProjectLink);
		return new CreateNewProjectPage(driver);
		
	}


}
