package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Vaishali.Chaudhari
 * @date 10 November 2019
 * @purpose Parent class - Read Property file and launch Application
 */
public class TestBase {
	public static WiniumDriver winiumDriver;
	public static RemoteWebDriver winRemoteDriver;
	public static Properties prop;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
//	TestUtil testUtil = new TestUtil();

	/**
	 * @category constructor of the TestBaseclass
	 * @purpose Read Property file
	 * @exception catch block - FileNotFoundException, IOException
	 */

	public TestBase() {

		String configFilePath = "C:\\Users\\Admin\\git\\MyCode\\Winium\\DemoWiniumProj\\src\\main\\java\\com\\qa\\config\\config.properties";

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);// FileNotFoundException
			prop.load(ip); // IOException
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\Admin\\git\\MyCode\\Winium\\DemoWiniumProj\\Reports\\ScientificCalculator_ExtentReport"
						+ ".html");
		// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// extent.setSystemInfo("Host Name", "Admin-PC");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Vaishali Chaudhari");
		htmlReporter.config().setDocumentTitle("Scientific Calculator .Net Desktop App");
		// Name of the report
		htmlReporter.config().setReportName("Verify Calculator Opeations");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(winiumDriver, result.getName());
			Thread.sleep(3000);
			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		winiumDriver.quit();
		extent.flush();
	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenShot(WiniumDriver winiumDriver, String screenshotName) throws IOException {
		// String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) winiumDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src //
		// folder
		String destination = "C:\\Users\\Admin\\git\\MyCode\\Winium\\DemoWiniumProj" + "/Screenshots/" + screenshotName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}

	/**
	 * @category static method of TestBaseclass
	 * @purpose launch Application
	 * @throws MalformedURLException, InterruptedException
	 */

	public static void initialization() throws MalformedURLException, InterruptedException {
		String AppPath = prop.getProperty("application_path");
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath(AppPath);
		winiumDriver = new WiniumDriver(new URL("http://localhost:8888"), option);

		Thread.sleep(5000);
	}

	/**
	 * @category static method of TestBaseclass
	 * @purpose launch Application on remote system
	 * @throws MalformedURLException, InterruptedException
	 */

	public static void initializationRemote() throws MalformedURLException, InterruptedException {
		String AppPath = prop.getProperty("application_path");
		DesiredCapabilities desireCaps = new DesiredCapabilities();
		desireCaps.setCapability("app", AppPath);
		winRemoteDriver = new RemoteWebDriver(new URL("http://172.25.97.3:8888"), desireCaps);

		Thread.sleep(5000);
	}
}
