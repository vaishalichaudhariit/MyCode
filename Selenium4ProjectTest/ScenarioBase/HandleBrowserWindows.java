package ScenarioBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000); 
		
		//getWindowhandle
		String windowID = driver.getWindowHandle();
		System.out.println("Window handle- "+windowID); //Window handle- A617AB7E646100BF2B071BF2E1B07579

		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Thread.sleep(1000); 
		
		//getWindowHandles - return id's of multiple browser windows
		//Set - duplicate not allowed
		Set<String> windowIds = driver.getWindowHandles();
		
		// #1 with Iterator
		Iterator<String> it = windowIds.iterator();
		String parentID = it.next();
		String childID = it.next();
		
		System.out.println(" Parent Window ID -" + parentID);
		System.out.println(" Child Window ID -" + childID);
		
		//#2 with List/ArrayList - Duplicate allowed
		List<String> windowIDsList = new ArrayList<String>(windowIds);//converting Set-->List
		
		
		System.out.println(" Parent Window ID -" + windowIDsList.get(0));
		System.out.println(" Child Window ID -" + windowIDsList.get(1));
		
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		
		for(String winid:windowIDsList) {
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println("Title  of the Page - "+title);
		}
		//driver.close();//close single browser window driver pining
		//driver.quit();/ close all the browser windows
		
		for(String winid:windowIDsList) {
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println("Title  of the Page - "+title);
			if(title.equals("OrangeHRM")) {
				driver.close();
			}
		}
	}
	//OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM
	//OrangeHRM
	

}
