package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowManage {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		// Exercise
		driver.get("https://www.google.com/");

		/* //Size
		 * 
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        System.out.println("Width of the web page - " + width);
        System.out.println("Height of the web page - " + height);


        driver.manage().window().maximize();

        Dimension size = driver.manage().window().getSize();

        System.out.println("New Width after maximize - " + size.getWidth()); 
        System.out.println("New Height after maximize - " + size.getHeight()); 

        driver.manage().window().setSize(new Dimension(800,600));

        System.out.println("New Width after set Size - " + size.getWidth()); 
        System.out.println("New Height after set Size - " + size.getHeight()); 

        //Position
        System.out.println(driver.manage().window().getPosition().getX());
        System.out.println(driver.manage().window().getPosition().getY());


        driver.manage().window().setPosition(new Point(500,100));

        Point position = driver.manage().window().getPosition();
        System.out.println(position.getX());
        System.out.println(position.getY());

        //Window Size customize 
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().fullscreen(); */
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./image3.png"));
		
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File srcFile1 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("./image2.png"));

		driver.close();


	}

}
