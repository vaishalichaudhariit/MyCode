package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EMICalculatorMapTest {

	public static void main(String[] args) throws InterruptedException {
		// SVG element - g, rect tags
		
		WebDriverManager.chromedriver().setup();
		/*
		//Run in headless mode
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver(co);
		*/
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://emicalculator.net/");
		
		Actions act = new Actions(driver);
		//act.scrollToElement(driver.findElement(By.xpath("(//*[@class='highcharts-root'])[2]")));
		driver.findElement(By.xpath("(//*[@class='highcharts-root'])[2]")).click();
		List<WebElement> barsList = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));
		
		System.out.println(barsList.size());
		
		String textXPath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		
		
		for (WebElement e : barsList) {
			act.moveToElement(e).perform();
			//Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath(textXPath)).getText());
		}
	}

}
