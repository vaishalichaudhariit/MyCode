/**
 * Parent class
 */
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver; //class available with Selenium
	public static WebEventListener eventListener;
	
	/**
	 * constructor of the TestBaseclass 
	 * Read Property file
	 * catch - FileNotFoundException, IOException
	 */
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/MyCode/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");//FileNotFoundException
			prop.load(ip); //IOException
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Add Web Driver fire event
		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
