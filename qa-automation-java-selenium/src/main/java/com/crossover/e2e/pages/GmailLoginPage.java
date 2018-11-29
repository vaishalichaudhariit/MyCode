package com.crossover.e2e.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crossover.e2e.base.TestBase;

/**
 * @author Vaishali.Chaudhari
 * TestBase is the Parent class of the GmailLoginPage class
 *
 */

public class GmailLoginPage extends TestBase{
	
	@FindBy(id="identifierId")
	WebElement userIdElement;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement btnNext;
	
	/*
	 * Initialize Page Objects
	 * purpose: Initialize element in PageFactory using initElements method with driver and this (current class Obj)
	 */
	
	public GmailLoginPage(){	
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public GmailHomePage login() throws InterruptedException{
		
		userIdElement.sendKeys(prop.getProperty("username"));
		if (btnNext.isEnabled())
			btnNext.click();
		Thread.sleep(3000);
		password.sendKeys(prop.getProperty("password"));
		if (btnNext.isEnabled())
			btnNext.click();
		Thread.sleep(3000);
		
		return new GmailHomePage();
	}


}
