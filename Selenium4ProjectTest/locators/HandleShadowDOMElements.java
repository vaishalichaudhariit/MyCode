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

public class HandleShadowDOMElements {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().window().maximize();

		driver.get("https://books-pwakit.appspot.com/");
		Thread.sleep(3000); 
		
		//Method #1
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement shadowDomtest =  (WebElement) js.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
		
		String jsVar = "arguments[0].setAttribute('value','Vaishali Test')";
		Thread.sleep(1000); 
		((JavascriptExecutor)driver).executeScript(jsVar, shadowDomtest);
		shadowDomtest.sendKeys("Vaishali");
		


		/* Method #2 with Selenium 3
		 * WebElement root = driver.findElement(By.tagName("book-app")); //Shadow Host //Root Element
		 * JavascriptExecutor js = (JavascriptExecutor)driver; WebElement shadowDom1 =
		 * (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
		 * java.lang.ClassCastException:
		 */
		
		// Method #3 - Selenium 4
		/*
		 * WebElement root = driver.findElement(By.tagName("book-app")); //Shadow Host
		 * //Root Element SearchContext shadowDom1 = root.getShadowRoot();
		 * 
		 * WebElement appHeader = shadowDom1.findElement(By.cssSelector("app-header"));
		 * WebElement appToolBar =
		 * appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		 * WebElement bookInputDecorator =
		 * appToolBar.findElement(By.cssSelector("book-input-decorator"));
		 * 
		 * bookInputDecorator.findElement(By.cssSelector("input#input")).sendKeys(
		 * "Testing");
		 */



	}

}
