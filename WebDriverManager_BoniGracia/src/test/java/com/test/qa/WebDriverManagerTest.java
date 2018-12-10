package com.test.qa;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		/*WebDriverManager.chromedriver().version("2.28").setup();
		driver = new ChromeDriver();*/
		
		/*WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.operadriver().setup();
		WebDriverManager.phantomjs().setup();
		WebDriverManager.edgedriver().setup();
		WebDriverManager.iedriver().setup();*/
		
		/*WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();*/
		
		/*WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		
		If Browser is not installed on system. So it's throw exception as below
		FAILED CONFIGURATION: @BeforeMethod setUp
		org.openqa.selenium.WebDriverException: unknown error: cannot find Opera binary*/
	}
	
	@Test(priority=1)
	private void googleTitleTest(){
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
