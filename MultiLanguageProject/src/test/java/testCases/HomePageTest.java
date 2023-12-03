package testCases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReader.ConfigPropReader;
import Factory.DriverFactory;
import Pages.HomePage;

public class HomePageTest {
	DriverFactory df;
	ConfigPropReader cp;
	Properties prop;
	WebDriver driver;
	HomePage homePage;


	@BeforeTest
	public void setup() throws IOException {
		cp = new ConfigPropReader();
		prop = cp.initLangProp();
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		homePage = new HomePage(driver);

	}
	
	@Test
	public void headerTest() {
		Assert.assertTrue(homePage.isHeaderExist(prop.getProperty("header")));
	}
	
	@Test
	public void contactTest() {
		Assert.assertTrue(homePage.isContactExist(prop.getProperty("contact")));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
