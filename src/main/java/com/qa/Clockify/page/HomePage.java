package com.qa.Clockify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.util.ElementUtil;
import com.qa.Clockify.util.SiteConstants;

public class HomePage extends BasePage {
	
	WebDriver driver ;
	ElementUtil elementUtil ;
	
	By accountName = By.xpath("//div[@class='cl-cut-text']");
	By ProjectLink = By.xpath("//a[@class= 'cl-nav-link cl-yellow']");
	
   public HomePage(WebDriver driver) {
		
		this.driver = driver;
	    elementUtil = new ElementUtil(driver);

	}
   
   public String getPageTitle() {
	   elementUtil.waitForTitlePresent(SiteConstants.HOME_PAGE_TITLE);
		return elementUtil.dogetPageTitle();
	}
   
    public String getLoggedInaccountName() {
    	
    	return elementUtil.dogetText(accountName);
		
	}
    
    public ProjectsPage doOpenProject() {
    elementUtil.doClick(ProjectLink);
    return new ProjectsPage (driver); 
	
}
	
	

}
