package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



		// Exercise
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		Thread.sleep(1000);
       /*
		//js alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		if(driver.getPageSource().contains("You sucessfully clicked an alert"))
			System.out.println("You sucessfully clicked an alert");
		System.out.println("========================");
		
		//js confirm
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		if(driver.getPageSource().contains("You clicked: Cancel"))
			System.out.println("You clicked: Cancel");
		System.out.println("=========================");*/

		//js prompt
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		Thread.sleep(1000);
		alert3.sendKeys("Vaishali");
		Thread.sleep(2000);
		alert3.accept();
		if(driver.getPageSource().contains("You entered: Vaishali"))
			System.out.println("You entered: Vaishali");
		System.out.println("=========================");
		
		
		driver.close();
		//driver.quit();
	}

}
