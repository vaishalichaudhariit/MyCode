package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsandAction {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("http://automationpractice.pl/index.php");
		Thread.sleep(1000); 
		
		WebElement features = driver.findElement(By.xpath("//a[@title='Women']"));
		
		//Actions is class with all methods
		Actions act = new Actions(driver);
		act.moveToElement(features).perform();
		
		//Perform will complete action, build will return action
		
		//Action is Interface to store actions
		
		Action action = act.moveToElement(features).build();
		action.perform();

	}

}
