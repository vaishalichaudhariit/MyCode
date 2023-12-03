package locators;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleChromeDownloadShadowDOM {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("chrome://downloads/");
		Thread.sleep(1000); 
		
		JavascriptExecutor js =	(JavascriptExecutor) driver;
		WebElement searchBox =(WebElement) js.executeScript("return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")\r\n" + 
				"");
		searchBox.sendKeys("vaishali");
		
		//Learn A to Z about XPath, cssSelector, WebElements, Shadow DOM, iframes, SVG, SelectorsHub & TestCase Studio.
		/*
		 * XPath concepts and Writing XPath from basic to advance.
		 * 
		 * Writing all kinds of XPath like XPath relative to other element, Relative
		 * XPath to Parent, index based xpath, XPath with attribute & text and absolute
		 * xpath.
		 * 
		 * Detailed explanation about important functions of XPath like text(), . dot,
		 * normalize-space(), not(), !=
		 * 
		 * Difference between //* and //tagname
		 * 
		 * Importance concepts about web like pseudo elements, comment, what is possible
		 * and what is not possible for web elements
		 * 
		 * XPath 1.0 and XPath 2.0
		 * 
		 * Shadow DOM, iframe, SVG, different technique to write xpath.
		 * 
		 * How to automate and handle more complex scenarios like shadow dom inside
		 * iframe, iframe inside shadow dom, multiple shadow dom inside iframe etc
		 * 
		 * How to automate closed shadow dom.
		 * 
		 * Handling all kinds of web elements like dynamic, invisible dropdown and
		 * submenu etc.
		 * 
		 * How to handle spin loader
		 * 
		 * cssSelector, JS Path, jQuery
		 * 
		 * Full training on SelectorsHub,
		 * 
		 * How to write automation script smartly,
		 * 
		 * Full training on TestCase Studio.
		 * 
		 * How to complete manual testing without wasting much time and smartly.
		 * 
		 * Bug reproducing techniques and a lot more.
		 * 
		 * Interview preparation and questions on XPath & Selectors.
		 * 
		 * After each class, practice questions and exercise will be shared. We will
		 * also discuss the exercise questions.
		 * 
		 * Writing Axes Based XPath, XPath for Web Tables etc will be taught.
		 * 
		 * contains(), text(), starts-with(), ends-with(), normalize-space()
		 */
	}

}
