package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleKeyboardActions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		/*
		driver.get("https://the-internet.herokuapp.com/key_presses");
		Thread.sleep(1000); 

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000); 
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000); 
		act.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(1000); 
		act.sendKeys(Keys.SPACE).perform();
		Thread.sleep(1000); 
		 */

		//Multiple Key combination

		driver.get("http://textcompare.com/");
		Thread.sleep(3000); 

		WebElement firstTextBox = driver.findElement(By.xpath("//textarea[@name='frm_compare_1']"));
		WebElement secondTextBox = driver.findElement(By.xpath("//textarea[@name='frm_compare_2']"));

		firstTextBox.clear();
		secondTextBox.clear();
		firstTextBox.sendKeys("Welcome Vaishali");

		Actions act = new Actions(driver);
		//CTRL + A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();

		Thread.sleep(3000); 
		
		//CTRL + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		Thread.sleep(3000); 

		//Tab -  shift to text box 2
		act.sendKeys(Keys.TAB);
		act.perform();

		Thread.sleep(3000); 
		//CTRL + V
		//act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		secondTextBox.sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(3000); 
		
		if (firstTextBox.getAttribute("value").equals(secondTextBox.getAttribute("value"))){
			System.out.println("Text copied");	
		}
		else {
			System.out.println("Text not copied");		
		}
	}

}
