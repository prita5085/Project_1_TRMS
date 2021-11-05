package com.trms.steps;

import org.openqa.selenium.WebDriver;
import com.trms.pages.TrmsLoginPage;
import com.trms.runner.TRMSRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class TrmsStepImpl {
	//Will have methods to be executed that corresponds to the Scenario steps
	
	public static TrmsLoginPage trmsLoginPage = TRMSRunner.trmsLoginPage;
	public static WebDriver driver = TRMSRunner.driver;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		driver.get("http://127.0.0.1:5500/login-page.html");
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password()  {
	    trmsLoginPage.username.sendKeys("mary");
	    trmsLoginPage.password.sendKeys("mary123");
	    try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    
	}

	@And("^User click on login button$")
	public void user_click_on_login_button() {
		trmsLoginPage.login.click();
		try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@SuppressWarnings("deprecation")
	@Then("^User should be on the employee dashboard$")
	public void user_should_be_on_the_employee_dashboard()  {
	   String titleExpected = "Employee Dashboard";
	   String titleActual = driver.getTitle();
	   System.out.println(titleActual);
	   Assert.assertEquals(titleExpected, driver.getTitle());
	   try {
           Thread.sleep(4000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
	}

	@After
    public void slowDown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	
}
