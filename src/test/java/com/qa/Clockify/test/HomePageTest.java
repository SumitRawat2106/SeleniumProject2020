package com.qa.Clockify.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.page.HomePage;
import com.qa.Clockify.page.LoginPage;
import com.qa.Clockify.page.ProjectsPage;
import com.qa.Clockify.util.Credentials;
import com.qa.Clockify.util.SiteConstants;

public class HomePageTest {
	
	WebDriver driver ;
	BasePage bp ;
	Properties prop ; 
	LoginPage lp ;
	HomePage hp ;
	ProjectsPage pp ;
	Credentials usercred;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		bp = new BasePage ();
		prop  = bp.init_properties();
		String browserName = prop.getProperty("browser");
		driver = bp.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
		usercred =  new Credentials(prop.getProperty("Email"), prop.getProperty("password"));
		hp = lp.doLogin(usercred);
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		
		String title  = hp.getPageTitle();
		System.out.println("Home Page Title is : " +title );
		Assert.assertEquals(SiteConstants.HOME_PAGE_TITLE, title);
	}
	
	
	@Test(priority = 2)
	public void verifyLoggedInaccountNameTest() {
		
		String accountName  = hp.getLoggedInaccountName();
		System.out.println("User LoggedIn Account Name is : " + accountName );
		Assert.assertEquals(prop.getProperty("accountName"), accountName);
		
	}
	
	@Test(priority = 3)
	public void verifyProjectTest() {
		pp= hp.doOpenProject();
		System.out.println(pp.getProjectPageTitle());
		Assert.assertEquals(pp.getProjectPageTitle(), SiteConstants.PROJECT_PAGE_TITLE);
	}

	@AfterTest 
	public void tearDown() {
		driver.quit();
	} 

}
