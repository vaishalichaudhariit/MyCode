package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EBaySearchExample {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.ebay.com/");
		Thread.sleep(1000); 

		searchProduct("Mobile","Home & Garden");
		getNthResult(10);
		getAllProducts();
	}

	public static void searchProduct(String product, String category) throws InterruptedException {

		driver.findElement(By.id("gh-ac")).sendKeys(product);

		WebElement categoryList = driver.findElement(By.id("gh-cat"));

		Select sel = new Select(categoryList);
		sel.selectByVisibleText(category);

		driver.findElement(By.id("gh-btn")).click();
		Thread.sleep(1000); 

		String resultStr = driver.findElement(By.xpath("//h1[contains(text(),' results for')] ")).getText();
		System.out.println(resultStr);
		System.out.println("==================================");
	}

	public static void getNthResult(int productNumber) {
		String xpathExpression = String.format("//div[@id='srp-river-results']/ul/li[%d]",productNumber);
		String nthProduct = driver.findElement(By.xpath(xpathExpression)).getText();
		System.out.println(nthProduct);
		System.out.println("==================================");
	}
	public static void getAllProducts() {
		List<WebElement> productsList = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li"));
		
		int productLocationX, productLocationY;
		//Actions act = new Actions(driver);
		for(WebElement product: productsList) {
			System.out.println(product.getText());
			
			productLocationX = product.getLocation().x;
			productLocationY= product.getLocation().y;
			
			scrollBy(productLocationX, productLocationY);
			
		//	act.moveToElement(product).perform();
			System.out.println("==================================");
			//github token - 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
		}
	}
	public static void scrollBy(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		js.executeScript(jsCommand);
		
	}
}
