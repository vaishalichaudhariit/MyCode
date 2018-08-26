package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:/SeleniumWorkspace/CucumberPOM/src/test/java/com/qa/config/config.properties");
			prop.load(fis);

		}
		catch (IOException e)
		{
			e.getMessage();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:/SeleniumWorkspace/Talento_Automation/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "D:/SeleniumWorkspace/Talento_Automation/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
