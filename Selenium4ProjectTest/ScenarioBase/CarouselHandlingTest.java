package ScenarioBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CarouselHandlingTest {
	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.noon.com/");
		Thread.sleep(1000);

		// Carousel Handling
		String xpath_recommandforyou = "//div[@class='componentArea-5']//div[contains(@class,'swiper-slide')]";
		String xpath_Arrow = "//div[@class='componentArea-5']//div[contains(@class,'swiper-button-next custom-navigation swiper-nav')]";
		//This will get the number of items in the carousel

		List<WebElement> items = driver.findElements(By.xpath(xpath_recommandforyou));


		//String element = "//div[@class='sc-iqcoie gVyoeI']/h2[text()='Recommended for you']";

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found		
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElements(By.xpath(element)));
		//js.executeScript("window.scrollBy(0,900)");

		
		String name;
		ArrayList <String>list = new ArrayList<String>();
		Thread.sleep(3000);
		//driver.findElements(By.xpath(xpath_recommandforyou));
		System.out.println("=====================================================");
		for (int i = 0; i < items.size(); i++) {
			int index = i + 1;

			//This will get the name of each item in carousel
			name = driver.findElement(By.xpath(xpath_recommandforyou + "[" + index + "]")).getText();


			if(!name.equals("") || !name.trim().equals(""))
			{
				list.add(name);

			}
			else
				if (driver.findElement(By.xpath(xpath_Arrow)).isDisplayed())
					driver.findElement(By.xpath(xpath_Arrow)).click();          

		}
		Collections.sort(list);
		System.out.println("\n Print name -" + list);

	}

}
