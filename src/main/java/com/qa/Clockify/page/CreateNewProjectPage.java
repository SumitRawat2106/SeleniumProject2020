package com.qa.Clockify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Clockify.util.ElementUtil;

public class CreateNewProjectPage {
	
	
	WebDriver driver ;
	ElementUtil elementUtil ;

    // 	1. Locators  - By 

	By CreateNewProjectHeader = By.id("exampleModalLabel");
	By EnterProjectName = By.xpath("//input[@placeholder='Enter project name']");
	By ClientNamebutton = By.id("dropdownMenuButton");
	By EnterClientName = By.xpath("//input[@placeholder='Add/Filter client']");
	By clientLink = By.xpath("//div[@class='cl-h6 cl-mb-0 ng-star-inserted']//a");
	By createbutton = By.xpath("//button[text()='Create']");
	
	
	public CreateNewProjectPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}
	
	public String getNewProjectHeaderText() {	
		return elementUtil.dogetText(CreateNewProjectHeader);
		
	}
	
	public void createNewProject(String ProjectName , String ClientName){
		
		elementUtil.doSendKeys(EnterProjectName, ProjectName);
		elementUtil.doClick(ClientNamebutton);
		elementUtil.doSendKeys(EnterClientName, ClientName);
		elementUtil.doClick(clientLink);
		elementUtil.waitForElementVisible(createbutton);
		elementUtil.doClick(createbutton);
		elementUtil.waitForElementVisible(createbutton);
		
		
	}


}
