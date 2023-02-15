package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://trytestingthis.netlify.app/");
		
		//WebElement dropDown = driver.findElement(By.id("option"));
		WebElement dropDown = driver.findElement(By.id("owc"));
		Select select = new Select(dropDown);
		
		select.selectByIndex(1);
		Thread.sleep(1000);
		select.selectByValue("option 2");
		Thread.sleep(1000);
		select.selectByVisibleText("Option 3");
		Thread.sleep(1000);
		select.deselectByVisibleText("Option 3");
		Thread.sleep(1000);
		/*Store all values in List
		List<WebElement> allAvailableOptions = select.getOptions();
		//List<WebElement> allOptions = driver.findElements(By.id("option"));
		
		for(WebElement option: allAvailableOptions) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("option 2"))
				option.click();
			Thread.sleep(2000);
		}
		*/
		driver.close();
	}

}
