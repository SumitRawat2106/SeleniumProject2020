package com.qa.Clockify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.util.Credentials;
import com.qa.Clockify.util.ElementUtil;
import com.qa.Clockify.util.SiteConstants;

public class LoginPage extends BasePage {
	
	WebDriver driver ;
	ElementUtil elementUtil ;
    // 	1. Locators  - By 
	By Email = By.id("email") ;
	By Password = By.id("password") ;
	By LoginBtn = By.xpath("//button[@type='submit']");
	By SignUp =  By.linkText("Sign Up");
	By ForgetPassword = By.linkText("Forgot password?");
	By LearnMore = By.linkText("Learn More");
	By errormessagetext = By.xpath("//span[@class= 'ng-tns-c239-2']");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}
	
	//2. Page Actions
	
	public String getPageTitle() {	
		elementUtil.waitForTitlePresent(SiteConstants.LOGIN_PAGE_TITLE);
		return elementUtil.dogetPageTitle();
		
	}
	
    public boolean CheckSignUpLink() {
		
		return elementUtil.doisDisplayed(SignUp);
		
	}
    
    
    public boolean CheckForgotpasswordLink() {
    	return elementUtil.doisDisplayed(ForgetPassword);
    	
    }
	
    
     public boolean CheckLearnMoreLink() {
    	return elementUtil.doisDisplayed(LearnMore);
    	
    }
     
     public HomePage doLogin(Credentials usercred) {
 		
    	 elementUtil.doSendKeys(Email, usercred.getUserEmail());
    	 elementUtil.doSendKeys(Password, usercred.getUserPassword());
    	 elementUtil.doClick(LoginBtn);
  	   
  	   return new HomePage(driver);
  	}
      
     public String CheckErrormessage() {
    	 elementUtil.waitForElementVisible(errormessagetext);
    	 return elementUtil.dogetText(errormessagetext);
     }
	
	
	

}
