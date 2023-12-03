package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDownLsit {

	public static void main(String[] args) throws InterruptedException {
		// Angular, Bootstrap, React
		
		//https://www.flipkart.com/
		//Remove blur properties from Event Listeners from DOM
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("macbook pro");
		Thread.sleep(1000);
		
		List<WebElement> suggList = driver.findElements(By.xpath("//div[contains(@class,'lrtEPN ')]"));
		
		for (WebElement e : suggList) {
			System.out.println(e.getText());
		}
	}

}
