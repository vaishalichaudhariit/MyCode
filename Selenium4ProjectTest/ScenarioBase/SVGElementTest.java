package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(1000); 
		
		String state = "Florida";
		//California
		//Florida
		// New York
		//Maryland
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		Thread.sleep(1000); 
		
		String str1 = "//*[name()='svg']//*[local-name()='g' and @id='regions']//*[local-name()='path' and @name='Alabama']";
		//driver.findElement(By.xpath(str1)).click();
		String str2= "//*[name()='svg']//*[local-name()='g' and @id='regions']//*[local-name()='path'  and @class='child']";
		List<WebElement> regionsList = driver.findElements(By.xpath(str2));
		
		System.out.println(regionsList.size());
		
		regionsList.stream().forEach(e->System.out.println("Regions-"+ e.getText()));
	}

}
