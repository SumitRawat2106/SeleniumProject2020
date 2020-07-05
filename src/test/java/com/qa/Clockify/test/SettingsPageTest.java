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
import com.qa.Clockify.page.SettingsPage;
import com.qa.Clockify.util.Credentials;
import com.qa.Clockify.util.SiteConstants;

public class SettingsPageTest {
	
	WebDriver driver ;
	BasePage bp ;
	Properties prop ; 
	LoginPage lp ;
	HomePage hp ;
	ProjectsPage pp ;
	Credentials usercred;
	SettingsPage sp ;
	
	
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
		sp = hp.doOpenSettingsPage();
	}
	
	@Test(priority = 1)
	public void verifySettingsPageTitle() {
		System.out.println("Title text is : " +sp.getpageTitle());
		Assert.assertEquals(sp.getpageTitle(),SiteConstants.SETTINGS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyWorkSpaceName() {
		Assert.assertTrue(sp.checkWorkSpaceName());
	}
	
	@Test(priority = 3)
	public void verifyUploadPhotobutton() {
		Assert.assertTrue(sp.checkUploadPhotobutton());
	}
	
	@Test(priority = 4 , enabled= false)
	public void verifyUploadPhoto() {
		sp.doUploadPhoto();
	}
	
	@AfterTest 
	public void tearDown() {
		driver.quit();
	} 
	

}
