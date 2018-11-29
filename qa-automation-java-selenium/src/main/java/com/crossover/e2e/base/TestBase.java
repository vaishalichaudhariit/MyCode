/**
 * Parent class
 */
package com.crossover.e2e.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crossover.e2e.reports.WebEventListener;
import com.crossover.e2e.util.WaitUtil;

/**
 * @author Vaishali.Chaudhari TestBase is the Parent class for all Page and Test
 *         classes
 */
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver e_driver; // class available with
													// Selenium
	public static WebEventListener eventListener;

	/**
	 * constructor of the TestBaseclass Read Property file catch -
	 * FileNotFoundException, IOException
	 */

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\SeleniumWorkspace\\qa-automation-java-selenium\\src\\main\\java\\com\\crossover\\e2e\\config\\test.properties");// FileNotFoundException
			prop.load(ip); // IOException
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters({ "browserName" })
	@BeforeTest
	public static void initialization(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/vaishali.chaudhari/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("iexplore")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\SeleniumWorkspace\\Talento_Automation\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		// Add Web Driver fire event
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts()
				.pageLoadTimeout(WaitUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		WaitUtil.implicitWait(driver, WaitUtil.WAIT_TIMEOUT);

		driver.get(prop.getProperty("url"));
	}
}
