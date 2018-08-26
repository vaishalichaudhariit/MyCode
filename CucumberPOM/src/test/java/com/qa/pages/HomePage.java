package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath= "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath= "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath= "//a[contains(text(), 'New Contacts')]")
	WebElement newContactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement taslsLink;
	
	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return userNameLabel.isDisplayed();
		}
		
		/*public ContactsPage clickOnContactsLink(){
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink(){
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink(){
			tasksLink.click();
			return new TasksPage();
		}*/
		
		public void clickOnNewContactsLink(){
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactsLink.click();
		}
		
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	

}
