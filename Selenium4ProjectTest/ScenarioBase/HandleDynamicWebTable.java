package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicWebTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com/admin/index.php");
		Thread.sleep(1000); 

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(1000); 

		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		Thread.sleep(1000); 

		//Find TotalNumber of pages in table
		String strPages = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(strPages);//Showing 1 to 10 of 103 (11 Pages)

		int totalPages = Integer.valueOf(strPages.substring(strPages.indexOf("(")+1,strPages.indexOf("Pages")-1));
		System.out.println(totalPages);

		//Find how many rows exists in each pages
		for (int p=1;p<totalPages;p++) {

			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("Active Page:- " + active_page.getText());
			//active_page.click();

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
			System.out.println("Number of rows: -" + rows);

			//Read all the rows from each page

			for(int r = 1; r<=rows ; r++) {

				String orderID = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]")).getText();
				String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[5]")).getText();
				if (status.equals("Pending")) {
					System.out.println(orderID + "  " +  customerName + "  " + status);
				}
			}


			String pageNo =Integer.toString(p+1);
			System.out.println(pageNo);
			String xpath = "//ul[@class='pagination']//li//a[text()='" + pageNo + "']";
			Thread.sleep(1000); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
			//driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(1000); 
		}

	}

}
