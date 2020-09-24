package com.qa.Clockify.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Clockify.base.BasePage;

public class ElementUtil extends BasePage {
	
	WebDriver driver ;
	WebDriverWait wait ;
	JavaScriptUtil js ;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait =  new WebDriverWait(driver, SiteConstants.DEFAULT_TIME_CONSTANT);
		js = new JavaScriptUtil(driver);
	}
	
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true ;
	}
	
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true ;
	}
	
	public boolean waitForElementVisible(By locator) {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true ;
	}
	
	public void waitforsystempopup() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		

	public void Implicitwait() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	}
	
	/**
	 * This method is used to get Page title
	 * @return title
	 */
	
	public String dogetPageTitle() {
		 String title = null;
    	 try {
    		 title = driver.getTitle();
    	 }
    	 catch(Exception e) {
   			System.out.println("Some exception occured while getting page title ...");
   		}
    	 return title;	
	}
	
	/**
	 * This method is used to create webElement on basis of by locator 
	 * @param locator
	 * @return Element
	 */
	public WebElement getElement(By locator) {
		WebElement Element = null ;
		try {
			Element = driver.findElement(locator);
			if (highlightElement) {
				js.flash(Element);
			}
			}
		
		catch(Exception e) {
			System.out.println("Some exception occured while creating webelement...");
		}
		
		
		return Element ;
	}
	
	/**
	 * This method is used to click webElement on basis of by locator 
	 * @param locator
	 *
	 */
	 
	public void doClick(By locator) {
		try {
			getElement(locator).click();	
		}
		catch(Exception e) {
			System.out.println("Some exception occured while clicking webelement...");
		}
		
	}
	
	/**
	 * This method is used to enter value in webElement on basis of by locator 
	 * @param locator & value 
	 *
	 */
	 
	
     public void doSendKeys(By locator, String value) {
    	 try {	
    		 WebElement Element = getElement(locator);
    		 Element.clear();
    		 Element.sendKeys(value);
    	 }
 		catch(Exception e) {
 			System.out.println("Some exception occured while entering into webelement...");
 		}
	
	}
     

 	/**
 	 * This method is used to check webElement is displayed or not on basis of by locator 
 	 * @param locator
 	 * @return result
 	 */
 	 
     
     public boolean doisDisplayed(By locator) {
    	 boolean result  = false;
    	 try {	
    		 result = getElement(locator).isDisplayed();
    	 }
  		catch(Exception e) {
  			System.out.println("Some exception occured while checking webelement is displayed or not...");
  		}
    	 return result;
}
     
     /**
  	 * This method is used to get text of webElement on basis of by locator 
  	 * @param locator  
  	 * @return text 
  	 */
     
     public String dogetText(By locator) {
    	 String text = null;
    	 try {
    	 text = getElement(locator).getText();
    	 }
    	 catch(Exception e) {
   			System.out.println("Some exception occured while get text of webelement ...");
   		}
    	 return text ;
     }
     

     /**
  	 * This method is used to get attribute of webElement on basis of by locator 
  	 * @param locator  
  	 * @return text 
  	 */
     
     public String dogetAttribute(By locator) {
    	 String text = null;
    	 try {
    	 text = getElement(locator).getAttribute("value");
    	 }
    	 catch(Exception e) {
   			System.out.println("Some exception occured while get text of webelement ...");
   		}
    	 return text ;
     }
     
     public void uploadPhotousingAutoIT() {
    	 try {
			Runtime.getRuntime().exec(SiteConstants.FILEUPLOAD_AUTOIT_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
     }
     
     
}
