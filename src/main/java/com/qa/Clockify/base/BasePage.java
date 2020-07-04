package com.qa.Clockify.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	// WebDriver driver ;
	Properties prop ;
	public static boolean highlightElement ;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	public WebDriver init_driver(String browserName) {
		highlightElement = prop.getProperty("highlight").equals("yes") ? true : false ;
		System.out.println("Browser Name : " + browserName );
		optionsManager = new OptionsManager(prop);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		 //  driver = new ChromeDriver(optionsManager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
	
		}
		else if (browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		
		else {
			System.out.println("Please enter correct browser name");
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//	driver.get(url);
			
			return getDriver();
			
		}

	
	public Properties init_properties() {
		
		 prop = new Properties();
		 String path = null ;
		 String env = null ;
		 try {
			 env = System.getProperty("env");
			 
			 if (env.equals("qa")) {
				 path = "C:\\Users\\Thinksysuser\\eclipse-workspace\\SeleniumProject2020\\src\\main\\java\\com\\qa\\Clockify\\config\\qa.config.properties";
			 }
			 else if (env.equals("staging")) {
				 path = "C:\\Users\\Thinksysuser\\eclipse-workspace\\SeleniumProject2020\\src\\main\\java\\com\\qa\\Clockify\\config\\staging.config.properties";
			 }
		 }
		 catch(Exception e) {
			 path = "C:\\Users\\Thinksysuser\\eclipse-workspace\\SeleniumProject2020\\src\\main\\java\\com\\qa\\Clockify\\config\\config.properties";
		 }
		 
		 try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} 
		 
		 catch (FileNotFoundException e) {
			System.out.println("Some Issue with config properties.. Please correct your config..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return prop ;
	
	}
	
	 
	 /**
	  * Take screenshot
	  */
	 
	 public String getScreenshot() {
		 
		 File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		 String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		
		 File destination = new File(path);
		 try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
		System.out.println("Screenshot captured Failed....");
		}
		 return path ;
		 
		 
	 }
		

}
