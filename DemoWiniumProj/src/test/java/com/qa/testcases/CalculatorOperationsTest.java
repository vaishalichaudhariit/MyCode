package com.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.ExcelOperationsUtil;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CalculatorOperationsTest extends TestBase {

	ExcelOperationsUtil excelOps = new ExcelOperationsUtil();
	TestUtil testUtil = new TestUtil();

	public CalculatorOperationsTest() {
		super(); // Super class constructor will call
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		initialization();
	}

	@Test(priority = 1)
	public void calcTitleVerifyTest() throws IOException {
		String strTitle = winiumDriver.findElement(By.name("Scientific Calculator")).getAttribute("Name");
		System.out.println("Name of the Application:  " + strTitle);
		Assert.assertEquals(strTitle, "Scientific Calculator", "Application Name " + strTitle + " is wrong");
		testUtil.takeScreenshotAtEndOfTest();

	}

	@Test(priority = 2)
	public void calcOperationsTest() throws InterruptedException, IOException {

		winiumDriver.findElement(By.name("Scientific Calculator")).click();
		System.out.println("Scientific Calculator opened sucessfully");
		Thread.sleep(3000);

		int rowCount = excelOps.getRowCount("testdata");

		// int columnCount = excelOps.getColumnCount("testdata");

		for (int i = 2; i <= rowCount; i++) {
			System.out.println("Hello in for loop" + i);

			winiumDriver.findElement(By.name(excelOps.getCellData("testdata", "FirstNumber", i))).click();
			System.out.println(excelOps.getCellData("testdata", 1, i));
			winiumDriver.findElement(By.name(excelOps.getCellData("testdata", "Operation", i))).click();
			System.out.println(excelOps.getCellData("testdata", 2, i));
			winiumDriver.findElement(By.name(excelOps.getCellData("testdata", "SecondNumber", i))).click();
			System.out.println(excelOps.getCellData("testdata", 3, i));
			winiumDriver.findElement(By.name("=")).click();
			testUtil.takeScreenshotAtEndOfTest();

			Thread.sleep(2000);

			String output = winiumDriver.findElement(By.id("textBox1")).getAttribute("Name");
			System.out.println("Output of the calc operation " + excelOps.getCellData("testdata", "Operation", i)
					+ " is:" + output);
			System.out.println(excelOps.getCellData("testdata", "ExpectedResult", i));
			Assert.assertEquals(output, excelOps.getCellData("testdata", "ExpectedResult", i),
					excelOps.getCellData("testdata", "FirstNumber", i) + " "
							+ excelOps.getCellData("testdata", "Operation", i) + " "
							+ excelOps.getCellData("testdata", "SecondNumber", i) + "=" + output);
			excelOps.setCellData("testdata", "ActualResult", i, output);

			excelOps.setCellData("testdata", "DateTime", i, testUtil.getDateTime());
			winiumDriver.findElement(By.name("-")).click();

		}
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() {
		winiumDriver.close();
	}

}
