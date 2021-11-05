package com.trms.pages;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrmsLoginPage {
	
	public WebDriver driver;
	
	//Fields that represent Elements in the HTML 
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement login;

	
	public TrmsLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
