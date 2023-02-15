package test;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProxyTest {

	public static void main(String[] args) {
		// https://www.charlesproxy.com/ 
		//Proxy class
		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		//proxy.setHttpProxy("localhost:8080");
		proxy.setSslProxy("localhost:8080");
		
		//Options class is replacement of DesiredCapabaility
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("proxy", proxy);	

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		driver.close();

	}

}
