package stepDefinition;

public class LoginStepDefinition {

/*WebDriver driver;	

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page(){
		System.setProperty("webdriver.chrome.driver","D:/SeleniumWorkspace/Talento_Automation/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
	    String title = driver.getTitle();
	    System.out.println("PageTitle: ---" +title);
	    Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	  
	}
	
	// Regular Expression for data driven
	//1. \”(.*)\” 
	//2. \”([^\”]*)\”

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) throws Throwable {
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
	    WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", loginBtn);

	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	   String title = driver.getTitle();
	   System.out.println("Home Page title::" + title);
	   Assert.assertEquals("CRMPRO", title);
	}
	
	@Then("^user moves to new contact page$")
	public void user_moves_to_new_contact_page() throws Throwable {
		driver.switchTo().frame(driver.findElement(By.name("mainpanel")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		WebElement newContactsMenu = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		newContactsMenu.click();
	}

	@Then("^user enters contact details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_contact_details_and_and(String firstname, String lastname, String position) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
	    driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(lastname);
	    driver.findElement(By.xpath("//input[@name='company_position']")).sendKeys(position);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
		WebElement verifyContact = driver.findElement(By.xpath("//td[@id='tab_vwebresources']/following::td[1]"));
		System.out.println("verifyContact :- " +verifyContact.getText());
	}


	@Then("^close the browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}*/
	
	/*@Given("^user is already on home Page$")
	public void user_is_already_on_home_Page() throws Throwable {
		  
		   System.out.println("user is already on home Page" );

	}

	@When("^user mouse over on contacts link$")
	public void user_mouse_over_on_contacts_link() throws Throwable {
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.name("mainpanel")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();

		Thread.sleep(1000);	    
	}

	@Then("^user clicks on New Contact link$")
	public void user_clicks_on_New_Contact_link() throws Throwable {
		WebElement newContactsMenu = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		newContactsMenu.click();
	}

	@Then("^user enters firstname and lastname$")
	public void user_enters_firstname_and_lastname() throws Throwable {	   
	    driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Manu");
	    driver.findElement(By.xpath("//input[@name='surname']")).sendKeys("Pathak");
	    
	}

	@Then("^user click on save button$")
	public void user_click_on_save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}

	@Then("^verify new contact created$")
	public void verify_new_contact_created() throws Throwable {
		WebElement verifyContact = driver.findElement(By.xpath("//td[@id='tab_vwebresources']/following::td[1]"));
		 Assert.assertEquals("Manu Pathak", verifyContact.getText());
				
	   	}*/
}
