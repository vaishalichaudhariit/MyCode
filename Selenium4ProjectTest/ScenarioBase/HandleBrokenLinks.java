package ScenarioBase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	static WebDriver driver;
	//static RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		int brokernLinks=0;
		//driver.get("https://www.amazon.com/");
		driver.navigate().to("http://www.deadlinkcity.com/");
		Thread.sleep(1000); 


		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("No. of links are "+ links.size());



		for (WebElement e : links)
		{
			String url = e.getAttribute("href");
			System.out.println(e.getText());
			System.out.println(url);
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is empty");
				continue;
			}

			URL link = new URL(url);
			try {
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.connect();
				if (httpConn.getResponseCode()>=400) {
					System.out.println("Response Code is - " + httpConn.getResponseCode() + " " + url + " is Broken link");
					brokernLinks++;
				}
				else
				{
					System.out.println("Response Code is - " + httpConn.getResponseCode()+ " " + url + " is not Broken link");
				}

			}catch(Exception e1) {

			}
			System.out.println("Total broken links are "+brokernLinks);
		}
	}
}

