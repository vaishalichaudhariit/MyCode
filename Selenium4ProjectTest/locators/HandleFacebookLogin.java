package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFacebookLogin {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		Thread.sleep(1000); 
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(1000); 
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//form[@class='_9vtf']")));
		driver.findElement(By.xpath("//form[@id='reg']/child::div/descendant::input[@name='firstname']")).sendKeys("vaishali");
		
		//1) Find the sign-up button from the registration from present in the Facebook application (child)
		//div[@id='reg_form_box']/child::div[11]/button
		
		//2) Locate Firstname field from SignUp button in facebook (Parent)
		//button[@id='u_e_s_q2']/parent::*/parent::*/child::div[1]//descendant::input[@name='firstname']
		
		//3) Identify the Password from Mobile number field in facebook (Following)
		//input[@id='u_e_g_4z']/following::input[2]
		
		//4) Locate Mobile number from new password field in facebook (Preceding)
		//input[@id='password_step_input']/preceding::input[1]
		
		//5) Locate surname from female radio button in facebook(Ancestor)
		//input[@id='u_e_4_cI']/ancestor::div[2]/descendant::input[2]
		
		//6) Identify the search text box from the Google search button present in the Google search home page (Parent)
		//input[@class='gNO89b']/parent::*/parent::*/parent::*/descendant::input
		
		//7) Identify today's Deals link from the Amazon search box present in the amazon home page (Following)
		//input[@id='twotabsearchtextbox']/following::a[contains(text(),"Today's Deals")]
		
		//8) Identify Hello, sign in link from the Amazon search box present in the amazon home page (Following)
		//input[@id='twotabsearchtextbox']/following::span[contains(text(),"Hello, sign in")]
		
		//9)Identify Mobiles link which is part of Menubar -Amazon (Descendant)
		//div[@id='nav-xshop']/descendant::a[text()="Mobiles"]
	}

}
