package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;

public class Multiply2Number {

			
		public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {


			DesktopOptions option = new DesktopOptions();
			option.setApplicationPath("D:\\POC\\Scientific Calculator\\VB\\ScientificCalculatorVisualBasic\\obj\\Debug\\ScientificCalculatorVisualBasic.exe");
			        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:8888"), option);

			Thread.sleep(5000);
	
			driver.findElement(By.name("Scientific Calculator")).click();
			System.out.println("Scientific Calculator opened sucessfully");
			Thread.sleep(3000);
			
			
			driver.findElement(By.name("5")).click();
			driver.findElement(By.name("*")).click();
			driver.findElement(By.name("4")).click();
			driver.findElement(By.name("=")).click();
			
			

			Thread.sleep(2000);

			String output = driver.findElement(By.id("textBox1")).getAttribute("Name");
			System.out.println("Output of the multiplication:  " + output);
			
			Assert.assertEquals(output, "20");
			Thread.sleep(1000);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT); //holds down Alt key
			robot.keyPress(KeyEvent.VK_F4); //Press F4
			robot.keyRelease(KeyEvent.VK_ALT); //release Alt key
			}

	

}
