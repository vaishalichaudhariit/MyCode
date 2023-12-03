import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulation_Day1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Current World Population

		String xpath_current_pop = "//div[@class='maincounter-number']/span[@class='rts-counter']";
		String xpath_today_pop = "//div[text()='Today']//parent::div//span[@class='rts-counter']";
		String xpath_thisyear_pop = "//div[text()='Today']//parent::div//span[@class='rts-counter']";
		String xpath_today_thisyear_pop ="//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(2000);

		/*
		while (true){
			List<WebElement> popList = driver.findElements(By.xpath("//span[@rel='current_population']"));
			for (WebElement e : popList) {
				System.out.println(e.getText());
			}
			popList = driver.findElements(By.xpath("//span[@rel='current_population']"));
		}*/

		int count = 1;
		while (count<=20){
			System.out.println(count + " sec");
			if(count == 21) break;

			System.out.println("------Current population count --------------");

			printPopulationData(xpath_current_pop);
			//printPopulationData(xpath_today_pop);
			//printPopulationData(xpath_thisyear_pop);
			System.out.println("------Today and This Year population count --------------");
			printPopulationData(xpath_today_thisyear_pop);
			System.out.println("============================================");
		}
		count++;

	}


	public static void printPopulationData(String locator) {

		/*List<WebElement> popList = driver.findElements(By.xpath(locator));

			for (WebElement e : popList) {
				System.out.println(e.getText());
				}
		 */

		driver
		.findElements(By.xpath(locator))
		.stream()
		.forEach(e->System.out.println(e.getText()));

	}
}