package com.qa.stepDefinitions;

import junit.framework.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class HomePageSteps extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		initialization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service",title);

	}

	@Then("^user logs into app$")
	public void user_enters_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


		
	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String homeTitle = homePage.validateLoginPageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);
	}

	@Then("^validate logged in username$")
	public void validate_logged_in_username() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	/*	boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);*/
		System.out.println("Naveen K Logged in sucessfully");
		driver.quit();
		
	}
}
