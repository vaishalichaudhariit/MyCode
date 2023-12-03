package ScenarioBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		Thread.sleep(1000); 

		driver.findElement(By.id("justAnInputBox")).click();

		//selectChoiceValues(driver,"choice 2");

		//selectChoiceValues(driver,"choice 2","choice 2 3", "choice 6","choice 6 2 1", "choice 6 2");

		selectChoiceValues(driver,"all");


	}

	public static void selectChoiceValues( WebDriver driver, String... value) {

		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		System.out.println(choiceList.size());
		
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement choice: choiceList) {

				String text = choice.getText();
				for(String val :value ) {
					if(text.equals(val)) {
						choice.click();
						break;
					}
				}
			}
		}
		else
		{
			try
			{
				for(WebElement choice: choiceList) {
					choice.click();

				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

		}


	}

}
