package testNG;
import java.time.Duration;

import org.openqa.selenium.By;			
import org.openqa.selenium.WebDriver;			
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Priority_In_testNG {
	 WebDriver driver;			

	    // Method 1: Open Browser say Firefox			
	    @Test (priority=1)		
	    public void openBrowser() {				
	        driver = new FirefoxDriver();				
	    }		

	    // Method 2: Launch Google.com			
	    @Test (priority=2)		
	    public void launchGoogle() {				
	        driver.get("http://www.google.co.in");						
	    }		

	    // Method 3: Perform a search using "Facebook"			
	    @Test (priority=3)		
	    public void peformSeachAndClick1stLink() {				
	        driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("Facebook");								
	    }		

	    // Method 4: Verify Google search page title.			
	    @Test (priority=4)		
	    public void FaceBookPageTitleVerification() throws Exception {
	    	   // Explicit wait condition for search results
	        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	       
	    	driver.findElement(By.xpath(".//*[@title='Search']")).submit();
	        //driver.findElement(By.xpath(".//*[@value='Search']")).click();						
	        Thread.sleep(3000);		
	        Assert.assertEquals(driver.getTitle().contains("Facebook - Google Search"), true);				
	    }		
	    @Test
		public void c_method(){
		System.out.println("I'm in method C");
		}
		@Test
		public void b_method(){
		System.out.println("I'm in method B");
		}
		@Test
		public void a_method(){
		System.out.println("I'm in method A");
		}
		@Test
		public void e_method(){
		System.out.println("I'm in method E");
		}
		@AfterTest
		public void testAfter() {
			driver.close();
			System.out.println("I am in After test");
		}
}
