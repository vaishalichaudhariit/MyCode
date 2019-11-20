package com.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.ExcelOperationsUtil;
import com.qa.base.TestBase;
import com.qa.pages.CalcDifferentOperations;
import com.qa.util.TestUtil;

public class CalculatorOperationsTest extends TestBase {

	ExcelOperationsUtil excelOps = new ExcelOperationsUtil();
	TestUtil testUtil = new TestUtil();
	CalcDifferentOperations caldiffOp = new CalcDifferentOperations();
	
	public CalculatorOperationsTest() {
		super(); // Super class constructor will call
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		initialization();
	}

	@Test(priority = 1,enabled = true)
	public void calcTitleVerifyTest() throws IOException {
		String strTitle = winiumDriver.findElement(By.name("Scientific Calculator")).getAttribute("Name");
		logger = extent.createTest("To verify Calc Title");
		logger.info("Started Appliation " + strTitle);
		System.out.println("Name of the Application:  " + strTitle);
		Assert.assertEquals(strTitle, "Scientific Calculator", "Application Name " + strTitle + " is wrong");
		
		//testUtil.takeScreenshotAtEndOfTest();
		logger.pass("App Launched Sucessfully");

	}

	@Test(priority = 3,enabled = true)
	public void calcOperationsTest() throws InterruptedException, IOException {

		winiumDriver.findElement(By.name("Scientific Calculator")).click();
		System.out.println("Scientific Calculator opened sucessfully");
		Thread.sleep(1000);
		logger = extent.createTest("To verify Calc Operations");
		
		int rowCount = excelOps.getRowCount("testdata");

		// int columnCount = excelOps.getColumnCount("testdata");

		for (int i = 2; i <= rowCount; i++) {
			System.out.println("Iteration:- " + i);

			winiumDriver.findElement(By.name(excelOps.getCellData("testdata", "FirstNumber", i))).click();
			// System.out.println(excelOps.getCellData("testdata", 1, i));
			winiumDriver.findElement(By.name(excelOps.getCellData("testdata", "Operation", i))).click();
			// System.out.println(excelOps.getCellData("testdata", 2, i));
			winiumDriver.findElement(By.name(excelOps.getCellData("testdata", "SecondNumber", i))).click();
			// System.out.println(excelOps.getCellData("testdata", 3, i));
			winiumDriver.findElement(By.name("=")).click();
			
		//testUtil.takeScreenshotAtEndOfTest();

			Thread.sleep(1000);

			String output = winiumDriver.findElement(By.id("textBox1")).getAttribute("Name");

			System.out.println(excelOps.getCellData("testdata", "FirstNumber", i) + " "
					+ excelOps.getCellData("testdata", "Operation", i) + " "
					+ excelOps.getCellData("testdata", "SecondNumber", i) + "=" + output);

			 
			excelOps.setCellData("testdata", "ActualResult", i, output);

			excelOps.setCellData("testdata", "DateTime", i, testUtil.getDateTime());
			
			
			
			System.out.println("output-" + output);
			System.out.println("ExpectedResult-" + excelOps.getCellData("testdata", "ExpectedResult", i));
			
			
			if (output.equalsIgnoreCase(excelOps.getCellData("testdata", "ExpectedResult", i))) {				
				excelOps.setCellData("testdata", "Status", i, "Pass");
			}else
			{
				excelOps.setCellData("testdata", "Status", i, "Fail");
			}
			Assert.assertEquals(output, excelOps.getCellData("testdata", "ExpectedResult", i),
					excelOps.getCellData("testdata", "FirstNumber", i) + " "
							+ excelOps.getCellData("testdata", "Operation", i) + " "
							+ excelOps.getCellData("testdata", "SecondNumber", i) + "=" + output);
			logger.pass(excelOps.getCellData("testdata", "FirstNumber", i) + " "
					+ excelOps.getCellData("testdata", "Operation", i) + " "
					+ excelOps.getCellData("testdata", "SecondNumber", i) + "=" + output + " Operation is Sucessful");
			

			 
			winiumDriver.findElement(By.name("-")).click();

		}
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void calcDiffOperationsTest() throws InterruptedException, IOException {

		winiumDriver.findElement(By.name("Scientific Calculator")).click();
		System.out.println("Scientific Calculator opened sucessfully");
		Thread.sleep(1000);
		logger = extent.createTest("To verify Calc Different Operations");
		
		int rowCount = excelOps.getRowCount("execution");



		for (int i = 2; i <= rowCount; i++) {
			System.out.println("Iteration:- " + i);
			
			String testdataNo = excelOps.getCellData("execution", "TestData", i);
			String firstNumber = excelOps.getCellData("testdata", "FirstNumber", Integer.parseInt((testdataNo)));
			String secondNumber = excelOps.getCellData("testdata", "SecondNumber", Integer.parseInt((testdataNo)));
			
			if (excelOps.getCellData("execution", "TestCase", i).contains("Add")) {
					int addValue = caldiffOp.addNumbers(firstNumber, secondNumber);
					excelOps.setCellData("execution", "Result", i, String.valueOf(addValue));
					if (addValue == (Integer.parseInt(firstNumber)+Integer.parseInt(secondNumber))) {				
						excelOps.setCellData("execution", "Status", i, "Pass");
					}else
					{
						excelOps.setCellData("execution", "Status", i, "Fail");
					}
					logger.pass(firstNumber + " "
							+ " + " + secondNumber  + "=" + addValue + " Operation is Sucessful");
			}else if (excelOps.getCellData("execution", "TestCase", i).contains("Subtract")) {
				int subValue = caldiffOp.subtractNumbers(firstNumber, secondNumber);
				excelOps.setCellData("execution", "Result", i, String.valueOf(subValue));
				if (subValue == (Integer.parseInt(firstNumber)-Integer.parseInt(secondNumber))) {						
					excelOps.setCellData("execution", "Status", i, "Pass");
				}else
				{
					excelOps.setCellData("execution", "Status", i, "Fail");
				}
				logger.pass(firstNumber + " "
						+ " - " + secondNumber  + "=" + subValue + " Operation is Sucessful");
			}else if (excelOps.getCellData("execution", "TestCase", i).contains("Division")) {
				int divValue = caldiffOp.divisionNumbers(firstNumber, secondNumber);
				excelOps.setCellData("execution", "Result", i, String.valueOf(divValue));
				if (divValue == (Integer.parseInt(firstNumber)/Integer.parseInt(secondNumber))) {						
					excelOps.setCellData("execution", "Status", i, "Pass");
				}else
				{
					excelOps.setCellData("execution", "Status", i, "Fail");
				}
				logger.pass(firstNumber + " "
						+ " / " + secondNumber  + "=" + divValue + " Operation is Sucessful");
			}else if (excelOps.getCellData("execution", "TestCase", i).contains("Multiply")) {
				int mulValue = caldiffOp.multiplyNumbers(firstNumber, secondNumber);
				excelOps.setCellData("execution", "Result", i, String.valueOf(mulValue));
				if (mulValue == (Integer.parseInt(firstNumber)*Integer.parseInt(secondNumber))) {						
					excelOps.setCellData("execution", "Status", i, "Pass");
				}else
				{
					excelOps.setCellData("execution", "Status", i, "Fail");
				}
				logger.pass(firstNumber + " "
						+ " * " + secondNumber  + "=" + mulValue + " Operation is Sucessful");
			}
			
			excelOps.setCellData("execution", "DateTime", i, testUtil.getDateTime());
		 
			

		}
		Thread.sleep(1000);
	}



	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		//winiumDriver.close();
	
	}

}
