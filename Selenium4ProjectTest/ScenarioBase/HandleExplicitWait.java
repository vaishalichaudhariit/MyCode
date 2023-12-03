package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleExplicitWait {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		Thread.sleep(1000); 
		//wait - ImplicitWait(timeouts) & ExplicitWait (FluentWait & WebDriverWait)
		//WebDriverWait is class, extend FluentWait class which implement Wait interface

		//WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		By eleLocator = By.xpath("//h3[text()='Selenium - Wikipedia']");
		
		waitForElementPresent(driver, eleLocator, 10).click();
		
		//WebElement element = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium - Wikipedia']")));
		//element.click();

		/*
		alert is present
		element exists
		element is visible
		title contains
		element is clickable
		title is
		element staleness
		element is selected
		visible text
		*/
	}

	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
