package ScenarioBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(1000); 
		
		
		//Type #1 with driver = new ChromeDriver(options);
		//Full page screen shot
		/*
		 * TakesScreenshot ts = (TakesScreenshot)driver; File src =
		 * ts.getScreenshotAs(OutputType.FILE); File trg = new
		 * File(".\\screenshots\\hompage.png");
		 * 
		 * FileUtils.copyFile(src, trg);
		 */
		
		/* Type #2
		 * ChromeDriver driver = new ChromeDriver(options); 
		 * TakesScreenshot photo1 = driver;
		 */
		
		//Screenshot of section/portion of the page
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		FileUtils.copyFile(section.getScreenshotAs(OutputType.FILE),new File(".\\screenshots\\section.png"));
	
		
		//Screenshot of particular element
		WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(".\\screenshots\\logo.png"));
		
	}

}
