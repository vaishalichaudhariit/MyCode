package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		/*
		// Exercise
		driver.get("https://www.google.com/");

		//Locate Single element
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Automation",Keys.ENTER);

		//Locate Multiple elements

		driver.navigate().to("https://trytestingthis.netlify.app/");
		List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
		for ( WebElement option : options)
		{
			System.out.println(option.getText());
		}

		driver.findElement(By.cssSelector("#fname")).sendKeys("Vaishali");;
		//CSS for class use . and for id use #
		//ID, CSS Selectors and then XPATH

		//Relative Locators
		//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		driver.navigate().to("https://www.facebook.com/");
		//driver.navigate().refresh();
		WebElement loginBtn = driver.findElement(By.name("login"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn)).sendKeys("Vaishali");
		 */

		driver.get("https://www.google.com/");

		driver.switchTo().frame("callout");

		Wait<WebDriver> fluntwait = new  FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(org.openqa.selenium.NoSuchElementException.class);

		WebElement btn = fluntwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='No thanks']")));
		btn.click();

		driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		driver.manage().window().maximize();

		WebElement searchBtn = driver.findElement(By.name("btnK"));
		driver.findElement(By.name("q")).sendKeys("Vaishali");

		searchBtn.click();

		Thread.sleep(3000);
		driver.close();

	}

}
