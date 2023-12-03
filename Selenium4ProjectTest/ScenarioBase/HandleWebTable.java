package ScenarioBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebTable {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://qavbox.github.io/demo/webtable/");
		Thread.sleep(1000); 
		/*
		 * Table #1

		//How to get total number of rows from WebTable
		int rows = driver.findElements(By.xpath("//table[@id='table02']/tbody/tr")).size();
		System.out.println("Total number of Rows in table- " +rows);

		// How to get total number of column 
		int cols = driver.findElements(By.xpath("//table[@id='table02']/thead/tr/th")).size();
		System.out.println("Total number of Columns in table - " +cols);

		//Retrieve the specific row/column data
		String office = driver.findElement(By.xpath("//table[@id='table02']/tbody/tr[2]/td[3]")).getText();
		System.out.println("2nd row and 3rd column value is - " + office);


		System.out.println("Data from the table - ");
		//Retrieve all the data from the table
		for (int r = 1; r<= rows; r++) {

			for (int c = 1; c<= cols;c++) {

				System.out.println(driver.findElement(By.xpath("//table[@id='table02']/tbody/tr["+r+"]/td["+c+"]")).getText() + " ");
			}
			System.out.println();
		}

		System.out.println("Data from the table as per condition - ");
		//Retrieve data from the table as per condition
		for (int r = 1; r<= rows; r++) {
			String name = driver.findElement(By.xpath("//table[@id='table02']/tbody/tr["+r+"]/td[1]")).getText();
			if (name.equals("Cedric Kelly")) {
				String position = driver.findElement(By.xpath("//table[@id='table02']/tbody/tr["+r+"]/td[2]")).getText();
				String office1 = driver.findElement(By.xpath("//table[@id='table02']/tbody/tr["+r+"]/td[3]")).getText();
				System.out.println(name + " " + position + " " + office1 );
			}
		}
		 */

		//Table #2

		System.out.println("Web Table with checkbox and button ");

		//How to get total number of rows from WebTable
		int rows1 = driver.findElements(By.xpath("//table[@id='table01']/tbody/tr")).size();
		System.out.println("Total number of Rows in table- " +rows1);

		// How to get total number of column 
		int cols1 = driver.findElements(By.xpath("//table[@id='table01']/thead/tr/th")).size();
		System.out.println("Total number of Columns in table - " +cols1);

		int rowCol = driver.findElements(By.xpath("//table[@id='table01']/tbody/tr[1]/td")).size();
		System.out.println("Total number of Rows Columns in table - " +rowCol);

		for (int r1 = 1; r1<=rows1; r1++) {
			String manualTesting = driver.findElement(By.xpath("//table[@id='table01']/tbody/tr["+r1+"]/td[2]")).getText();
			System.out.println(manualTesting);
			if (manualTesting.equals("Performance")) {
				driver.findElement(By.xpath("//table[@id='table01']/tbody/tr["+r1+"]/td[1]")).click();
				driver.findElement(By.xpath("//table[@id='table01']/tbody/tr["+r1+"]/td[5]")).click();
				System.out.println("Selected row is deleted");	
			}
		}

	}
}
