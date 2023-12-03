package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationAndSizeofElement {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000); 
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		//Location
		System.out.println("Location(x) - " + logo.getLocation().getX());
		System.out.println("Location(y) - " + logo.getLocation().getY());
		System.out.println("Location(x,y) - " + logo.getLocation());
		System.out.println("Location(x - " + logo.getRect().getX());
		System.out.println("Location(y) - " + logo.getRect().getY());
		System.out.println("Location(x,y) - " + logo.getRect());
		
		//Size
		System.out.println("Size - Height - " + logo.getSize().getHeight());
		System.out.println("Size - Width - " + logo.getSize().getWidth());
		System.out.println("Size - " + logo.getSize());
		
		System.out.println("Size - Height -" + logo.getRect().getHeight());
		System.out.println("Size - " + logo.getRect().getDimension());
	}

}
