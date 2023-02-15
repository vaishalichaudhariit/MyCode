package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		//Combination of keys in sendKeys
		WebElement searchBox = driver.findElement(By.name("q"));
		//searchBox.sendKeys("Vaishali"+ Keys.ENTER);

		//keyDown()
		/*Actions actionProvider = new Actions(driver);
		Action keyDown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		keyDown.perform();*/

		//keyUp()
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(searchBox, "selenium")
		.keyUp(Keys.SHIFT).sendKeys(" vaishali").perform();
		Thread.sleep(2000);
		searchBox.clear();

		driver.close();

	}

}
