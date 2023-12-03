package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestedDropDownGoogle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		Thread.sleep(1000); 

		driver.findElement(By.name("q")).sendKeys("Java tutorial");
		Thread.sleep(1000); 
		List<WebElement> listOptions= driver.findElements(By.xpath("//li[contains(@class,'sbct')]//div[@role='option']//div[1]//span"));

		System.out.println(listOptions.size());

		for (WebElement item:listOptions ) {
			//if(item.getText().contains("beginners")
			if(item.getText().equals("java tutorial for beginners"))
			{
				item.click();
				break;
			}
		}

	}

}


