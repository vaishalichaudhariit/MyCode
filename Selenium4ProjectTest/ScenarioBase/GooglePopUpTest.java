package ScenarioBase;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePopUpTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://gaana.com/");
		Thread.sleep(4000); 
		
		if (driver.findElement(By.xpath("//button[text()='Log In / Sign Up']")).isEnabled()) {
			System.out.println("XPATH Right");
			driver.findElement(By.xpath("//button[text()='Log In / Sign Up']")).click();
			Thread.sleep(2000); 
		}

		driver.findElement(By.xpath("//button[text()='Google']")).click();
		Thread.sleep(2000); 
		/*// It will return the parent window name as a String
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
			}*/

		Set<String> strWindowhdl =driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= strWindowhdl.iterator();
		String parent =I1.next();
		String child =I1.next();
		driver.switchTo().window(child);
		Thread.sleep(2000); 

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vaishalinpathak@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pathak@2010");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(6000); 
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Search Artists, Songs, Albums']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Jaya Kishori");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//small[text()='Trending Songs']")).click();
	}
}
