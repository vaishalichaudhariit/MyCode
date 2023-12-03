package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSlider {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Thread.sleep(1000); 
		
		WebElement min_slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		
		System.out.println("Location of the min slider: "+min_slider.getLocation());
		System.out.println("Height & Width of the element: " + min_slider.getSize());
		
		Actions act = new Actions(driver);	
		act.dragAndDropBy(min_slider, 100, 0).perform();
		
		System.out.println("Location of the min slider: "+min_slider.getLocation());
		System.out.println("Height & Width of the element: " + min_slider.getSize());
		
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of the min slider: "+max_slider.getLocation());
		System.out.println("Height & Width of the element: " + max_slider.getSize());
		
		
		act.dragAndDropBy(max_slider, -100, 0).perform();
		
		System.out.println("Location of the min slider: "+max_slider.getLocation());
		System.out.println("Height & Width of the element: " + max_slider.getSize());
		
	}

}
