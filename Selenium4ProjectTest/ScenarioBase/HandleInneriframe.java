package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleInneriframe {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		WebElement outerFrame = driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
		driver.switchTo().frame(outerFrame);
		
		WebElement innerFrame = driver.findElement(By.xpath("//div[@class='iframe-container']//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(innerFrame);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome Vaishali");
		Thread.sleep(1000); 
	}

}
