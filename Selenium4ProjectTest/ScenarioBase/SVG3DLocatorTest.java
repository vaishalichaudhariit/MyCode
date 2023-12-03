package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG3DLocatorTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		Thread.sleep(1000); 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.switchTo().frame("svg_result");
		while(true) {
			String xpathElements = "//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]"; 
			List<WebElement> eleList = driver.findElements(By.xpath(xpathElements));
			for (WebElement ele : eleList) {
				String text = null;
				text = ele.getAttribute("d");
				System.out.println(text);
			}

		}

	}


}
