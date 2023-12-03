package ScenarioBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJavascriptExecutor {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, WebDriverException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(1000); 

		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

		//Syntax - js.executeScript(Script, args);

		//flash - highlight

		//drawing border and take screenshot
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].style.border='3px solid red'", logo);
		 * 
		 * 
		 * TakesScreenshot ts = (TakesScreenshot)driver;
		 * FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new
		 * File(".\\screenshots\\logo.png")); Thread.sleep(1000); //getting title of the
		 * page
		 * System.out.println(js.executeScript("return document.title;").toString());
		 * Thread.sleep(1000);
		 * 
		 * //click action js.executeScript("arguments[0].click();", logo);
		 * Thread.sleep(1000);
		 * 
		 * //generate an alert js.executeScript("alert('Hello Vaishali!')");
		 * Thread.sleep(1000); driver.switchTo().alert().accept(); Thread.sleep(1000);
		 * 
		 * //refresh page js.executeScript("history.go(0)"); Thread.sleep(1000);
		 * 
		 * //scrolling down
		 * js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 * Thread.sleep(1000);
		 * 
		 * //scroll up page
		 * js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		 * Thread.sleep(1000);
		 * 
		 * 
		 * js.executeScript("window.scrollBy(0,-350)", "");
		 * 
		 * 
		 * // Scrolling down the page till the element is found
		 * //js.executeScript("arguments[0].scrollIntoView();", logo);
		 * 
		 * 
		 * //zooming page js.executeScript("document.body.style.zoom='50%' ");
		 */

		//Background color - flash element
		String bgcolor = logo.getCssValue("backgroundColor");
		for(int i=0;i<50;i++) {
			changeColor("#000000",logo,driver); //1
			changeColor(bgcolor,logo,driver); //2
		}

	}

	public static void changeColor(String color, WebElement logo, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor =' " + color +" '", logo);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {

		}
	}

}
