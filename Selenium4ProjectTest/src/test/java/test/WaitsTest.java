package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Implicit wait - default is o, polling frequency is 500ms
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		//driver.findElement(By.name("q")).sendKeys("vaishali", Keys.ENTER);
		
		//Explicit wait - WebDriverWait, ExpectedConditions are class
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//WebElement myLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Vaishali (ancient city) - Wikipedia")));
		//myLink.click();
		
		//Warning: Implicit wait and Explicit waits can cause unpredictable wait times e.g. implicit wait = 10 sec, explicit wait = 15 sec - could cause a timeout after 25 seconds
		
		//Fluent Wait - additional to explicit wait can set Polling frequency instead of default 500ms, Ignore Exception - in case element is not found, can ignore any exception like NoSuchElement etc.
		
		
		//Wait - Interface, FluentWait -class
		/*Wait<WebDriver> fluntwait = new  FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(1))
			.ignoring(org.openqa.selenium.NoSuchElementException.class);
		
		WebElement myLink1 = fluntwait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Vaishali (ancient city) - Wikipedia")));
		myLink1.click();*/
		
		
		Thread.sleep(3000);
		//driver.close();

	}

}
