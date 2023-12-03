package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleiFrame {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		Thread.sleep(1000); 
		
		//iframe #1
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent();
		
		//iframe #2
		driver.switchTo().frame("packageFrame");
		Thread.sleep(1000); 
		//span[normalize-space()='Alert']
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		driver.switchTo().defaultContent();
		
		//iframe #3
		driver.switchTo().frame("classFrame");
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Overview']")).click();
		driver.switchTo().defaultContent();
	}

}
