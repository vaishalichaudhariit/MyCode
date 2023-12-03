package ScenarioBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertsPopups {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(1000); 


		//Alert window with Ok button
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		WebElement resultStr = driver.findElement(By.xpath("//p[@id='result']"));
		System.out.println("Alert Result -" + resultStr.getText());

		//Alert window with Ok and cancel button
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		System.out.println("Confirm Result -" + resultStr.getText());
		
		//Alert window with input box, capture
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("The message displayed on alert: "+ alertWindow.getText());
		Thread.sleep(1000);
		alertWindow.sendKeys("Welcome Vaishali");
		Thread.sleep(3000);
		alertWindow.accept();
		System.out.println("Prompt Result -" + resultStr.getText());
		
	}

}
