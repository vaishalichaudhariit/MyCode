/**
 * Page Layers
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

/**
 * @author Vaishali.Chaudhari
 * LoginPage is the child of TestBase class
 *
 */
public class LoginPage extends TestBase{

	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign-Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	/*
	 * Initialize Page Objects
	 * purpose: Initialize element in PageFactory using initElements method with driver and this (current class Obj)
	 */
	
	public LoginPage(){	
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		if (loginBtn.isEnabled())
		loginBtn.click();
		return new HomePage();
	}
	
}
