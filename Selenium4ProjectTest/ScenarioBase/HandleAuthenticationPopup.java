package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAuthenticationPopup {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(1000); 
		
		//http://user:password@URL
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		
		WebElement resultStr = driver.findElement(By.xpath("//div[@id='content']/div/p"));
		System.out.println("Result -" + resultStr.getText());
		

	}

}
