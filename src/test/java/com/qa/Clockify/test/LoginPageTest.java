package com.qa.Clockify.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.page.HomePage;
import com.qa.Clockify.page.LoginPage;
import com.qa.Clockify.util.Credentials;
import com.qa.Clockify.util.SiteConstants;

public class LoginPageTest {
	WebDriver driver ;
	BasePage bp ;
	Properties prop ; 
	LoginPage lp ;
	HomePage hp ;
	Credentials usercred;

	@BeforeTest
	@Parameters(value={"browser"})
	public void setUp(@Optional("") String browser) {
		String browserName = null;
		bp = new BasePage ();
		prop  = bp.init_properties();
		
		
		if(browser.equals("")){
			 browserName = prop.getProperty("browser");
		}else{
			browserName = browser;
		}
		
		driver = bp.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
		usercred =  new Credentials(prop.getProperty("Email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title  = lp.getPageTitle();
		System.out.println("Login Page Title is : " +title );
		Assert.assertEquals(SiteConstants.LOGIN_PAGE_TITLE, title);
		
	}
	
	@Test(priority = 2)
	public void verifySignUpLinkTest() {
	    Assert.assertTrue(lp.CheckSignUpLink()); 
	}
	
	@Test(priority = 3)
	public void verifyForgotpasswordLinkTest() {
	    Assert.assertTrue(lp.CheckForgotpasswordLink()); 
		}
	
	
	@Test(priority = 4)
	public void verifyLearnMoreLinkTest() {
	    Assert.assertTrue(lp.CheckLearnMoreLink()); 
	}
	
	@DataProvider 
	public Object[] [] getInvalidData() {
		Object data[] [] = {{"test1@testxp.com", "test12"} ,{"test1@testxp.com", ""} ,  {"", "test123"}  , {"", ""}};
		return data;
		
	}
	
    @Test(priority = 5 , dataProvider = "getInvalidData" , enabled = false)
    public void Login_InvalidTestCases(String userEmail , String userPassword) {
    	usercred.setUserEmail(userEmail);
    	usercred.setUserPassword(userPassword);
    	hp = lp.doLogin(usercred);
        System.out.println(lp.CheckErrormessage());
        Assert.assertEquals(lp.CheckErrormessage(), "Account with that email doesn't exist.");
           	
    }
	
	@Test(priority = 6)
	public void verifyLoginTest()  {
	   hp = lp.doLogin(usercred);
	   Assert.assertEquals(hp.getPageTitle(), SiteConstants.HOME_PAGE_TITLE);
   
	}
	

	
	
	
	@AfterTest 
	public void tearDown() {
		driver.quit();
	}

}
