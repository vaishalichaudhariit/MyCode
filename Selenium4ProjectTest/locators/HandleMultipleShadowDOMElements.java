package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleShadowDOMElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().window().maximize();

		driver.get("https://shop.polymer-project.org/");
		Thread.sleep(1000); 
		
		//		
		JavascriptExecutor js =	(JavascriptExecutor) driver;
		WebElement shopBtn=(WebElement) js.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", shopBtn);
		
		WebElement root = driver.findElement(By.tagName("shop-app")); //Shadow Host //Root Element

		// Selenium 4
		SearchContext shadowDom1 = root.getShadowRoot();

		WebElement ironPages = shadowDom1.findElement(By.cssSelector("iron-pages"));
		
		
		WebElement shopHome = ironPages.findElement(By.cssSelector("shop-home"));
		
		SearchContext shadowDom2 = shopHome.getShadowRoot();
		
		shadowDom2.findElement(By.cssSelector("div:nth-child(2) > shop-button > a")).click();

		

	}
}
