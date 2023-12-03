package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenURLsIn2Tab {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Thread.sleep(1000); 
		
		WebElement body = driver.findElement(By.xpath("//body[1]"));
		body.sendKeys(Keys.chord(Keys.CONTROL,"t"));
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		Thread.sleep(1000); 

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(1000); 

	}

}
