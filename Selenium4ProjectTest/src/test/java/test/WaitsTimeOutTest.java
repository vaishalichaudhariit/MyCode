package test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsTimeOutTest {
	
	
    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().driverVersion("109.0").setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
    	
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        //driver.navigate().to("https://www.bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Verify
        assertTrue((title).contains("Selenium WebDriver"));
        System.out.println("Title of the page is " + title);
    }
	



}
