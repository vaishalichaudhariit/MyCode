package ScenarioBase;

import java.awt.Checkbox;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		Thread.sleep(1000); 

		//driver.findElement(By.xpath("id=\"monday\"")).click();

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Count of checkboxes - "+ checkBoxes.size());

		/*
		//using for loop
		for(int i=0;i<checkBoxes.size();i++) {
			checkBoxes.get(i).click();
		}

		//using for each
		for (WebElement checkbox:checkBoxes) {
			checkbox.click();
		}

		//using lambda expression
		checkBoxes.forEach(checkbox -> checkbox.click());


		//Select multiple checkboxes; as per choice - Monday and Sunday
		for (WebElement checkbox:checkBoxes) {

			String checkboxName = checkbox.getAttribute("id");
			if(checkboxName.equals("monday") || checkboxName.equals("sunday")) {
				checkbox.click();
			}
		}


		//Select Last 2 check boxes
		//Total checkboxes are 7 - no of check boxes want to select = starting index
		//7-2=5

		int totalcheckboxes =checkBoxes.size();

		for (int i=totalcheckboxes-2;i<totalcheckboxes;i++) {
			checkBoxes.get(i).click();
		}

		 */

		//Select first 2 check boxes

		int totalcheckboxes =checkBoxes.size();

		for (int i=0;i<totalcheckboxes;i++) {

			if(i<2) {

				checkBoxes.get(i).click();
			}
		}
	}
}