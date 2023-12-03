package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGCovidGraphTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in/search?q=covid+cases+in+india&source=hp&ei=-AbuY8K9GvWSseMP2I-iyAI&iflsig=AK50M_UAAAAAY-4VCL32_iojEl37NZ7NO1dNd74ej-uA&oq=covid&gs_lcp=Cgdnd3Mtd2l6EAMYADIICAAQgAQQsQMyCAgAEIAEELEDMgsIABCABBCxAxDJAzILCAAQgAQQsQMQgwEyCAgAEIAEELEDMgUIABCxAzIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQM6DggAEI8BEOoCEIwDEOUCOg4ILhCPARDqAhCMAxDlAjoICC4QsQMQgwE6EQguEIAEELEDEIMBEMcBENEDOgUILhCABDoFCAAQgAQ6CAguEIAEELEDUKQoWNw1YPZWaAFwAHgAgAFciAGiA5IBATWYAQCgAQGwAQo&sclient=gws-wiz");
		Thread.sleep(1000); 
		/*
		List<WebElement> graphList = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		Actions act = new Actions(driver);
		for(WebElement e : graphList) {
			act.moveToElement(e).perform();
			System.out.println(driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText());
		}
		 */
		List<WebElement> graphList = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		
	}

}
