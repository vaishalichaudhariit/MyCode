package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HooksStepDefinition {
	
	//Global Hooks
	@Before(order=0)
	public void setUP(){
		System.out.println("Launch Firefox");
		System.out.println("Enter URL for Free CRM APP");
	}
	
	@After(order=0)
	public void tearDown(){
		System.out.println("Close Firefox browser");

	}
	@Before(order=1)
	public void setUP1(){
		System.out.println("Launch Firefox");
		System.out.println("Enter URL for Free CRM APP");
	}
	
	@After(order=1)
	public void tearDown1(){
		System.out.println("Close Firefox browser");

	}

	//Local Hooks - Only for first scenario - Tag Hooks
	@Before("@First")
	public void beforeFirst(){
		System.out.println("before only first scenario");
	}
	
	//Local Hooks - Only for first scenario
	@After("@First")
	public void afterFirst(){
		System.out.println("after only first scenario");
	}
		
	
	//Local Hooks - Only for second scenario
	@Before("@Second")
	public void beforeSecond(){
		System.out.println("before only second scenario");
	}
	
	//Local Hooks - Only for first scenario
	@After("@Second")
	public void afterSecond(){
		System.out.println("after only second scenario");
	}
	
	//Local Hooks - Only for second scenario
	@Before("@Third")
	public void beforeThird(){
		System.out.println("before only Third scenario");
	}
	
	//Local Hooks - Only for Third scenario
	@After("@Third")
	public void afterThird(){
		System.out.println("after only Third scenario");
	}
	
	@Given("^user is on deal page$")
	public void user_is_on_deal_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("user is on deal page");
	}

	@When("^user fills the deals form$")
	public void user_fills_the_deals_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user fills the deals form");
	}

	@Then("^deal is created$")
	public void deal_is_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("deal is created");
	   
	}
	
	@Given("^user is on contact page$")
	public void user_is_on_contact_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   System.out.println("user is on contact page");
	}

	@When("^user fills the contact form$")
	public void user_fills_the_contact_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   System.out.println("user fills the contact form");
	}

	@Then("^contact is created$")
	public void contact_is_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("contact is created");
	}

	@Given("^user is on mail page$")
	public void user_is_on_mail_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is on mail page");
	}

	@When("^user fills the mail form$")
	public void user_fills_the_mail_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user fills the mail form");
	}

	@Then("^mail is created$")
	public void mail_is_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("mail is created");
	}
}
