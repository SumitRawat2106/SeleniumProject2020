package com.qa.Clockify.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.page.CreateNewProjectPage;
import com.qa.Clockify.page.HomePage;
import com.qa.Clockify.page.LoginPage;
import com.qa.Clockify.page.ProjectsPage;
import com.qa.Clockify.util.Credentials;
import com.qa.Clockify.util.SiteConstants;

public class ProjectsPageTest {
	
	WebDriver driver ;
	BasePage bp ;
	Properties prop ; 
	LoginPage lp ;
	HomePage hp ;
	ProjectsPage pp ;
	CreateNewProjectPage cpp ;
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
		pp= hp.doOpenProject();
		
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		System.out.println("Title text is : " + pp.getProjectPageTitle());
		Assert.assertEquals(pp.getProjectPageTitle(),SiteConstants.PROJECT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyPageHeader() {
		System.out.println("Header text is : " + pp.getPageHeader());
		Assert.assertEquals(pp.getPageHeader(),SiteConstants.PROJECT_PAGE_HEADER);
	}
	
	@Test(priority = 3)
	public void verifyCreateNewProjectLink() {
		cpp =pp.clickCreateNewProjectLink();
		Assert.assertEquals(cpp.getNewProjectHeaderText(),SiteConstants.NEW_PROJECT_HEADER_TEXT);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	} 


}
