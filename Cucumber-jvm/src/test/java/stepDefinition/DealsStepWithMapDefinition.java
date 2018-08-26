package stepDefinition;

import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealsStepWithMapDefinition {
	WebDriver driver;	

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
	

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) throws Throwable {
		for(Map<String,String> data : credentials.asMaps(String.class, String.class)){
	    driver.findElement(By.name("username")).sendKeys(data.get("username"));
	    driver.findElement(By.name("password")).sendKeys(data.get("password"));
	}
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
	
	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deal_page(){
		driver.switchTo().frame(driver.findElement(By.name("mainpanel")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		WebElement newDealMenu = driver.findElement(By.xpath("//a[contains(text(),'New Deal')]"));
		newDealMenu.click();
	}


	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable dealdata) throws Throwable{
		for(Map<String,String> data : dealdata.asMaps(String.class, String.class)){
		driver.findElement(By.name("title")).sendKeys(data.get("title"));
		driver.findElement(By.name("amount")).sendKeys(data.get("amount"));
		driver.findElement(By.name("probability")).sendKeys(data.get("probability"));
		driver.findElement(By.name("commission")).sendKeys(data.get("commission"));
		driver.findElement(By.xpath("//input[@value='Save' and @type='submit']")).click(); // Save button
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		WebElement newDealMenu = driver.findElement(By.xpath("//a[contains(text(),'New Deal')]"));
		newDealMenu.click();
		}
	}
	
	@Then("^close the browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}
}
