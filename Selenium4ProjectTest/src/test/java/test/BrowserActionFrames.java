package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserActionFrames {

	public static void main(String[] args) throws InterruptedException {
		// iframe tag for frame in dom
		
		
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        // Exercise
        driver.get("http://www.selenium.dev/selenium/docs/api/frame2.htm");
        driver.switchTo().frame("packageFrame");
        // cssSelector - .classname>iframe
        driver.findElement(By.linkText("Alert")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.close();
        
        
  
        
        
	}

}
