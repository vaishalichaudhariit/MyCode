package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamSauceTest {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// https://www.saucedemo.com/inventory.html

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/inventory.html");
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));
		//div[normalize-space()='$49.99']
		//div[normalize-space()='$49.99']/following-sibling::button

		//=====Method #1 with stream and lambda expressions
		
		/*
		  double maxPrice = priceList .stream()
		  .mapToDouble(e->Double.parseDouble(e.getText().trim().replace("$", "")))
		  .max() .getAsDouble(); System.out.println("maxPrice-> " + maxPrice); String
		  btnMaxAddtoCart = "//div[normalize-space()='$"+
		  maxPrice+"']/following-sibling::button[text()='Add to cart']";
		  driver.findElement(By.xpath(btnMaxAddtoCart)).click();
		  System.out.println("========================================================"
		  ); double minPrice = priceList .stream()
		  .mapToDouble(e->Double.parseDouble(e.getText().trim().replace("$", "")))
		  .min() .getAsDouble(); System.out.println("minPrice-> " + minPrice); String
		  btnMinAddtoCart = "//div[normalize-space()='$"+
		  minPrice+"']/following-sibling::button[text()='Add to cart']";
		  driver.findElement(By.xpath(btnMinAddtoCart)).click();
		 */


		//=====Method #2 with for each
		/*
		double largest = 0;
		for(WebElement e: priceList) {
			double price = Double.parseDouble(e.getText().replace("$", "")); //49.99
			if (largest < price) {
				largest = price;
			}
		}
		System.out.println("Largestprice -" + largest);
		String btnMaxAddtoCart = "//div[normalize-space()='$"+ largest+"']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(btnMaxAddtoCart)).click();
		 */
		
		//=====Method #3 with javascript - inject JS code inside the browser through javascriptExecutor
		
		String script ="var max = 0;\r\n" + 
				"    document.getElementsByClassName('inventory_item_price')\r\n" + 
				"            .forEach(e => {newVal = parseFloat(e.innerText.split('$')[1]);\r\n" + 
				"if(max <newVal){\r\n" + 
				"    max = newVal;\r\n" + 
				"}\r\n" + 
				"                          });\r\n" + 
				"console.log(max);\r\n" + 
				"var xpathVal = \"//div[normalize-space()='$\"+ max+\"']/following-sibling::button[text()='Add to cart']\";\r\n" + 
				"var eleMaxvalue = document.evaluate(xpathVal, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;\r\n" + 
				"\r\n" + 
				"eleMaxvalue.click();";
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript(script);
	}

}
