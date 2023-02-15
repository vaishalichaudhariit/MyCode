package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionsTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		/*
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		
		WebElement boxA = driver.findElement(By.xpath("//li[text()='A']"));
		WebElement boxD = driver.findElement(By.xpath("//li[text()='D']"));
		WebElement boxL = driver.findElement(By.xpath("//li[text()='L']"));
		
		Actions actions = new Actions(driver);
		actions.scrollToElement(boxL);
		
		actions.contextClick(boxD);
		
		actions.doubleClick(boxL);
		
		actions.moveToElement(boxA);
		actions.clickAndHold();
		actions.moveToElement(boxD);
		actions.release().perform();
		*/
		
		//Drag and drop
		driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		
		WebElement ele1 = driver.findElement(By.id("draggable"));
		WebElement ele2 = driver.findElement(By.id("droppable"));
		WebElement ele3 = driver.findElement(By.xpath("(//a[text() = 'Selenium'])[2]"));
		
		Actions actions = new Actions(driver);
		
		actions.scrollToElement(ele3);
		
		actions.dragAndDrop(ele1, ele2);
		actions.build().perform();
		Thread.sleep(2000);
		
		driver.quit();
	}

}
