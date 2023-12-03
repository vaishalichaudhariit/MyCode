package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipeDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		Thread.sleep(1000); 
		
		//driver.switchTo().frame("u_0_2_VV");
		driver.findElement(By.xpath("//a[text()=\"Create new account\"]")).click();
		Thread.sleep(1000);
		
		WebElement day = driver.findElement(By.id("day"));
		selectOptionFromDropDown(day,"22");
		WebElement month = driver.findElement(By.id("month"));
		selectOptionFromDropDown(month,"Oct");
		WebElement year = driver.findElement(By.id("year"));
		selectOptionFromDropDown(year,"1981");
		
		driver.findElement(By.xpath("//span[@class=\"_5k_2 _5dba\"][1]/input")).click();
		
		
	}
	public static void selectOptionFromDropDown(WebElement ele, String value)
	{
		Select dropDown = new Select(ele);
		List<WebElement> allOptions = dropDown.getOptions();

		for (WebElement option:allOptions)
		{
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
