package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserAction {


	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        // Exercise
        driver.get("https://www.google.com/");
    	String originalwindow = driver.getWindowHandle();
	
		driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/");
		System.out.println("Current URL - " + driver.getCurrentUrl());
		System.out.println("Title of the page - " + driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep (2000);
		
		driver.navigate().forward();
		Thread.sleep (2000);
		
		driver.navigate().refresh();
		Thread.sleep (2000);
		
	
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().window(originalwindow);
		driver.close();
		//driver.quit();
	}

}
