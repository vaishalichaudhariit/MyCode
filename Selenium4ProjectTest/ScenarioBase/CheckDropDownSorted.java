package ScenarioBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {

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
		
		WebElement drpElement = driver.findElement(By.name("category_id"));
		Select drpselect = new Select(drpElement);
		
		List<WebElement> items = drpselect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for(WebElement item:items)
		{
			originalList.add(item.getText());
			tempList.add(item.getText());
		}
		
		
		System.out.println("Original List -" + originalList);
		System.out.println("Temp List - " + tempList);
		
		Collections.sort(tempList);
		
		System.out.println("Original List -" + originalList);
		System.out.println("Temp List After sorting -" + tempList);
		
		if (originalList.equals(tempList)) {
			System.out.println("Drop down values are sorted");
		}
		else {
			System.out.println("Drop down values are not sorted");
		}
		
	}

}
