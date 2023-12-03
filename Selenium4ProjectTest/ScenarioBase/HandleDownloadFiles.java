package ScenarioBase;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDownloadFiles {


	static WebDriver driver;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {


		//custom location to download file
		String location = System.getProperty("user.dir")+"\\Downloads\\";

		HashMap preferences = new  HashMap();
		preferences.put("plugins.always_open_pdf_externally",true);//for PDF download, without opening file in view mode
		preferences.put("download.default_directory",location);

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");
		options.setExperimentalOption("prefs", preferences);


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		Thread.sleep(1000); 

		driver.findElement(By.xpath("//*[@id='table-files']/tbody/tr[1]/td[5]/a")).click();

		/*
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("pdfjs.disabled",true);//for PDF
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");//Mime type
		profile.setPreference("browser.download.folderList", 2); //0 - desktop, 1- download, 2 - 
		profile.setPreference("browser.download.dir", location);

		Associated MIME types:
		application/doc
		application/ms-doc
		application/msword
		application/vnd.openxmlformats-officedocument.wordprocessingml.document
		
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setProfile(profile);
		WebDriver driver = new FirefoxDriver(options1);
		 */
	}

}
