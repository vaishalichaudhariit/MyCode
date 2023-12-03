package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.twoplugs.com/");
		Thread.sleep(1000); 

		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("Toronto");

		String text;
		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			text = searchBox.getAttribute("value");

			if(text.equals("Toronto, OH, USA")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
		}while(!text.isEmpty());

	}
}
