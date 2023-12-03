package ScenarioBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleUploadFile {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.timesjobs.com/");
		Thread.sleep(1000); 
		
		
		driver.findElement(By.xpath("//div[@class='upload-res-input']")).click();
		Thread.sleep(1000); 
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection("C:\\Users\\Dell\\Downloads\\Test upload.docx");
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		     //native key strokes for CTRL, V and ENTER keys
           Robot robot = new Robot();
           robot.delay(2000);
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_ENTER);
           robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
