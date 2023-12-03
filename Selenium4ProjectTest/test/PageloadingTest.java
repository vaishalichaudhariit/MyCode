package test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageloadingTest {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//Default page load strategy is Normal
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		driver.close();

		//document.addEventListener('DOMContentLoaded', fn); - EAGER - Initial page to load not wait for image or any other to load
		//None - Initial page to load
		//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);

	}

}
