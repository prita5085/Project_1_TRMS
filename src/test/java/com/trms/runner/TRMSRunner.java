package com.trms.runner;

import org.junit.AfterClass;    
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.trms.pages.TrmsLoginPage;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

 
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"com.trms.steps"})
public class TRMSRunner {
	
	public static WebDriver driver; 
	public static TrmsLoginPage trmsLoginPage; 
	
	@BeforeClass
	public static void setUp() {
		String path = "C:/Selenium/chromedriver.exe"; 
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		trmsLoginPage = new TrmsLoginPage(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}
