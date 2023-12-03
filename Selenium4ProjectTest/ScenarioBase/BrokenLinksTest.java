package ScenarioBase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {
	static WebDriver driver;
	//static RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		//driver.get("https://www.amazon.com/");
		driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(1000); 
		
		//driver.findElement(By.linkText("Best Sellers")).click();
		//driver.findElement(By.partialLinkText("Sellers")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("No. of links are "+ links.size());
		
		List<String> urllist =new ArrayList<String>();
		
		for (WebElement e : links)
		{
			String url = e.getAttribute("href");
			System.out.println(e.getText());
			System.out.println(url);
			urllist.add(url);
			//checkBrokenLink(url);
		}
		
		//Parallel - total time taken: 18433 = 18.4 sec
		//sequence - total time taken: 159236 = 159 secs
		
		long startTime = System.currentTimeMillis();
		urllist.parallelStream().forEach(e->checkBrokenLink(e));
		// Sequential execution - urllist.stream().forEach(e->checkBrokenLink(e));
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total time taken: " + (endTime -startTime));
		driver.quit();

	}
	
	public static void checkBrokenLink(String linkURL) {
		
		try {
			
			URL url = new URL(linkURL  );
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if (httpUrlConnection.getResponseCode()>=400) {
				System.out.println(linkURL + "-------------->"+ httpUrlConnection.getResponseMessage() + "is a broken link");
				
			}
			else {
				System.out.println(linkURL + "-------------->"+ httpUrlConnection.getResponseMessage() );
				}
			}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
