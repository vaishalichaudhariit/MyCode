package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Add2Numbers {

			
		public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {


			DesktopOptions option = new DesktopOptions();
			option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
			        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:8888"), option);

			        Thread.sleep(5000);
			       
			        driver.findElement(By.name("Five")).click();
			driver.findElement(By.name("Plus")).click();
			driver.findElement(By.name("Four")).click();
			driver.findElement(By.name("Equals")).click();

			Thread.sleep(5000);

			String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
			System.out.println("Output of the addition:  " + output);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT); //holds down Alt key
			robot.keyPress(KeyEvent.VK_F4); //Press F4
			robot.keyRelease(KeyEvent.VK_ALT); //release Alt key
			}

	

}
