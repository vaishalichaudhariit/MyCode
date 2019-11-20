package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class CalcDifferentOperations extends TestBase {

	TestUtil testUtil = new TestUtil();

	public int addNumbers(String firstNo, String secondNo) throws InterruptedException, IOException {
		winiumDriver.findElement(By.name(firstNo)).click();
		winiumDriver.findElement(By.name("+")).click();
		winiumDriver.findElement(By.name(secondNo)).click();
		winiumDriver.findElement(By.name("=")).click();

		Thread.sleep(1000);
		//testUtil.takeScreenshotAtEndOfTest();

		Thread.sleep(2000);

		String addition = winiumDriver.findElement(By.id("textBox1")).getAttribute("Name");
		System.out.println(firstNo + " " + " + " + " " + secondNo + "=" + addition);
		
		winiumDriver.findElement(By.name("-")).click();
		
		
		return Integer.parseInt(addition);
	}

	public int subtractNumbers(String firstNo, String secondNo) throws InterruptedException, IOException {
		winiumDriver.findElement(By.name(firstNo)).click();
		winiumDriver.findElement(By.name("-")).click();
		winiumDriver.findElement(By.name(secondNo)).click();
		winiumDriver.findElement(By.name("=")).click();

		Thread.sleep(2000);
		//testUtil.takeScreenshotAtEndOfTest();

		Thread.sleep(2000);

		String subtraction = winiumDriver.findElement(By.id("textBox1")).getAttribute("Name");
		System.out.println(firstNo + " " + " - " + " " + secondNo + "=" + subtraction);
		
		winiumDriver.findElement(By.name("-")).click();
		
		
		return Integer.parseInt(subtraction);
	}

	public int divisionNumbers(String firstNo, String secondNo) throws InterruptedException, IOException {
		winiumDriver.findElement(By.name(firstNo)).click();
		winiumDriver.findElement(By.name("÷")).click();
		winiumDriver.findElement(By.name(secondNo)).click();
		winiumDriver.findElement(By.name("=")).click();

		Thread.sleep(2000);
		//testUtil.takeScreenshotAtEndOfTest();

		Thread.sleep(2000);

		String division = winiumDriver.findElement(By.id("textBox1")).getAttribute("Name");
		System.out.println(firstNo + " " + " / " + " " + secondNo + "=" + division);
		
		winiumDriver.findElement(By.name("-")).click();
				
		return Integer.parseInt(division);
	}

	public int multiplyNumbers(String firstNo, String secondNo) throws InterruptedException, IOException {
		winiumDriver.findElement(By.name(firstNo)).click();
		winiumDriver.findElement(By.name("*")).click();
		winiumDriver.findElement(By.name(secondNo)).click();
		winiumDriver.findElement(By.name("=")).click();

		Thread.sleep(2000);
		//testUtil.takeScreenshotAtEndOfTest();

		Thread.sleep(2000);

		String multiply = winiumDriver.findElement(By.id("textBox1")).getAttribute("Name");
		System.out.println(firstNo + " " + " * " + " " + secondNo + "=" + multiply);
		
		winiumDriver.findElement(By.name("-")).click();
		
		return Integer.parseInt(multiply);
	}
}
