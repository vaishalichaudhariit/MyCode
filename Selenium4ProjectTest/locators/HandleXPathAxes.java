package locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleXPathAxes {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		Thread.sleep(1000); 
		
		String selfAxes = driver.findElement(By.xpath("//a[contains(text(),'Meghmani Finechem')]/self::a")).getText();
		System.out.println(selfAxes);
		
		
		String parentAxes = driver.findElement(By.xpath("//a[contains(text(),'Meghmani Finechem')]/parent::td")).getText();
		System.out.println(parentAxes);
		
		//String childAxes = driver.findElement(By.xpath("//a[contains(text(),'Meghmani Finechem')]/child::*")).getText();
		//System.out.println(childAxes); // No child available

		List<WebElement> childAxes = driver.findElements(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/child::td"));
		System.out.println(childAxes.size());
		
		WebElement ancestorAxes = driver.findElement(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr"));
		System.out.println(ancestorAxes.getTagName());		
		
		//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/descendant::*td - 5
		

		List<WebElement> desendantAxes = driver.findElements(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/descendant::*"));
		System.out.println(desendantAxes.size());//7
		
		List<WebElement> followingAxes = driver.findElements(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/following::tr"));
		System.out.println(followingAxes.size());//
		
		
		List<WebElement> followingSiblingAxes = driver.findElements(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/following-sibling::tr"));
		System.out.println(followingSiblingAxes.size());//
		
		List<WebElement> precedingAxes = driver.findElements(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/preceding::tr"));
		System.out.println(precedingAxes.size());//
		
		
		List<WebElement> precedingSiblingAxes = driver.findElements(By.xpath("//a[contains(text(),'Meghmani Finechem')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println(precedingSiblingAxes.size());//		
		
	}

}
