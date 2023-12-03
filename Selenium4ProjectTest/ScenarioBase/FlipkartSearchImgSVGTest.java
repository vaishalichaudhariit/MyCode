package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSearchImgSVGTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000); 
		
		driver.findElement(By.xpath("//div[@class='_2QfC02']/button")).click();
		driver.findElement(By.name("q")).sendKeys("mobile" + Keys.TAB);
		
		//Normal xpath working,Not working path SVG - WebElement btnSearch = driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='g']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@class='L0Z3Pu']")));
		
		
	}

}
