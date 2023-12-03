package ScenarioBase;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserCookies {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("–disable-notifications");


		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
	
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Thread.sleep(1000); 
		//Cookies method - How to capture cookies from browser?
		
		Set<Cookie> cookies =driver.manage().getCookies();//return set of cookies
		System.out.println("Total cookies -" + cookies.size());
		
		//How to print cookies from browser?
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		Cookie cokObj = new Cookie("MyCookie","12345");
		//How to add cookie to browser
		driver.manage().addCookie(cokObj);
		cookies =driver.manage().getCookies();//return set of cookies
		System.out.println("Total cookies -" + cookies.size());
		
		//How to print cookies from browser?
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		//How  to delete cookie as per name
		driver.manage().deleteCookieNamed("__gpi");
		driver.manage().deleteCookie(cokObj);
		
		cookies =driver.manage().getCookies();//return set of cookies
		System.out.println("Total cookies -" + cookies.size());
		
		//How to print cookies from browser?
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		//How to delete all cookies
		driver.manage().deleteAllCookies();
		driver.close();

	}

}
