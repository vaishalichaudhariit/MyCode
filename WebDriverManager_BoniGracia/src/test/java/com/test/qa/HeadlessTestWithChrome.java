package com.test.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTestWithChrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://automationtesting.in");
		System.out.println("Site Title is: " + driver.getTitle());
		driver.findElement(By.cssSelector("#s")).sendKeys("testng");
		driver.findElement(By.cssSelector("#s")).sendKeys(Keys.ENTER);
		System.out.println("Site Title is: " + driver.getTitle());
		driver.quit();

	}

}
