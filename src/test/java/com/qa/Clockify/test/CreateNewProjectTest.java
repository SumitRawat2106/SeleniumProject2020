package com.qa.Clockify.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Clockify.base.BasePage;
import com.qa.Clockify.page.CreateNewProjectPage;
import com.qa.Clockify.page.HomePage;
import com.qa.Clockify.page.LoginPage;
import com.qa.Clockify.page.ProjectsPage;
import com.qa.Clockify.util.Credentials;
import com.qa.Clockify.util.ExcelUtil;
import com.qa.Clockify.util.SiteConstants;

public class CreateNewProjectTest {
	
	WebDriver driver ;
	BasePage bp ;
	Properties prop ; 
	LoginPage lp ;
	HomePage hp ;
	ProjectsPage pp ;
	CreateNewProjectPage cpp ;
	Credentials usercred;
	
	
	@BeforeMethod
	public void setUp()  {
		bp = new BasePage ();
		prop  = bp.init_properties();
		String browserName = prop.getProperty("browser");
		driver = bp.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
		usercred =  new Credentials(prop.getProperty("Email"), prop.getProperty("password"));
		hp = lp.doLogin(usercred);
		pp= hp.doOpenProject();
	    cpp =pp.clickCreateNewProjectLink();
		
	}
	
	@Test(priority = 1)
	public void verifyPageHeaderText() {
		String header = cpp.getNewProjectHeaderText();
		System.out.println("Header text is : " + header);
		Assert.assertEquals(header,SiteConstants.NEW_PROJECT_HEADER_TEXT);
	}
	
	
	@DataProvider
	public Object[][] getProjectsDataTest(){
		
		Object[][]data = ExcelUtil.getTestData(SiteConstants.SHEET_NAME);
		return data ;
	}
	
	@Test(priority = 2 , dataProvider = "getProjectsDataTest" , enabled = false)
	public void verifyCreateNewProject(String ProjectName , String ClientName)  {	
		cpp.createNewProject(ProjectName , ClientName);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	} 


}
