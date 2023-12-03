package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleiFrame {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		//working with iframe, frame and form
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		Thread.sleep(1000); 
		
		driver.switchTo().frame("iframeResult");//switch to outer iframe
		driver.switchTo().frame(0); //switch to inner iframe
		
		System.out.println("Text present inside the inner frame: "+ driver.findElement(By.xpath("//h1")).getText());
		
		driver.switchTo().parentFrame(); //got to parent frame or outer frame
		
		System.out.println("Text present inside the Outer frame: " + driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to specify the size of the iframe:')]")).getText());
	}

}
