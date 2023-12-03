package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMouseOperation {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		/*
		 *ContextClick
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(1000); 

		WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		Thread.sleep(1000); 

		driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//li//span[text()='Edit']")).click();

		driver.switchTo().alert().accept();


		//DoubleClick
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		Thread.sleep(1000); 
		driver.switchTo().frame("iframeResult");

		driver.findElement(By.id("field1")).clear();
		driver.findElement(By.id("field1")).sendKeys("Welcome Vaishali");

		WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']"));

		Actions act = new Actions(driver);
		act.doubleClick(button).perform();

		//Drag and Drop
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(1000); 

		WebElement source = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='box106']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();

		//Drag and drop image
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Thread.sleep(1000);

		WebElement frameStr = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frameStr);

		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));



		WebElement img1 = driver.findElement(By.xpath("//li[1]//img"));
		WebElement img2 = driver.findElement(By.xpath("//li[2]//img"));
		WebElement img3 = driver.findElement(By.xpath("//li[3]//img"));
		WebElement img4 = driver.findElement(By.xpath("//li[4]//img"));

		Actions act = new Actions(driver);
		act.dragAndDrop(img1, target).perform();
		Thread.sleep(1000);
		act.dragAndDrop(img2, target).perform();
		Thread.sleep(1000);
		act.dragAndDrop(img3, target).perform();
		Thread.sleep(1000);
		act.dragAndDrop(img4, target).perform();
		Thread.sleep(1000);
		 */
		
		//Mouse hour
		
		driver.get("https://demo.opencart.com/");
		Thread.sleep(1000);
		
		WebElement desktopMenu = driver.findElement(By.xpath("//a[text()='Desktops']"));
		WebElement macMenu = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(desktopMenu).moveToElement(macMenu).click().perform();


		
	}

}
