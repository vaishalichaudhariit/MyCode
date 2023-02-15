package test;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementStrategies {

	public static void main(String[] args) throws InterruptedException {
		// findElement, findElements
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		/*driver.get("https://www.google.com/");

		driver.switchTo().frame("callout");

		Wait<WebDriver> fluntwait = new  FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(org.openqa.selenium.NoSuchElementException.class);

		WebElement btn = fluntwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='No thanks']")));
		btn.click();

		driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Vaishali");*/

		//#1 with Enter key
		//searchBox.sendKeys("Vaishali" + Keys.ENTER);

		//#2 Explicit wait condition for search results
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		//w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
		//searchBox.submit();
		//#3 Click on Search button
		//driver.findElement(By.name("btnK")).click();

		//wait for suggestions
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("li")));

		//WebElement list=driver.findElement(By.className("sbct sbre"));
		//List<WebElement> rows=driver.findElements(By.tagName("li"));

		//for(WebElement elem:rows) {
		//	System.out.println("Hello");
		//System.out.println(elem.getText());
		//	}

		//find elements
		/*driver.get("https://trytestingthis.netlify.app/");
		List<WebElement> elements = driver.findElements(By.tagName("select"));
		for (WebElement element : elements) {
			System.out.println(element.getText());
		}*/

		//find element within element
		/*driver.get("https://www.google.com/");

		WebElement searchForm = driver.findElement(By.tagName("form"));
		WebElement searchBox = searchForm.findElement(By.name("q"));
		searchBox.sendKeys("Vaishali" + Keys.ENTER);*/

		//How to get activeElement, Tag Name, Text, CSSValue
		/*driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Vaishali");

		System.out.println(searchBox.getTagName());
		System.out.println(searchBox.getText());
		System.out.println(searchBox.getCssValue("font"));
		System.out.println(searchBox.getCssValue("color"));
		
		String title =driver.switchTo().activeElement().getAttribute("title");
		System.out.println("Title:- " +title);*/
		
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox = driver.findElement(By.xpath(("(//input[@type='checkbox'])[1]")));
		System.out.println("" + checkbox.isEnabled());
		System.out.println("" + checkbox.isDisplayed());
		System.out.println("" + checkbox.isSelected());
		driver.close();
	}

}
