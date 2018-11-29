/**
 * 
 */
package com.crossover.e2e.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author Vaishali.Chaudhari
 * @purpose This class is to  handle implicit and explicit wait conditions.
 */
public class WaitUtil {
	
	public  static JavascriptExecutor js;
	public static String pageLoadStatus = null;
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long WAIT_TIMEOUT = 2000;

//**************************************************************************************************************

	 /**
	 * <p>This method used for implicitWait condition : Specifies the amount of time the driver should wait when searching for an element if it is not immediately present. </p>
	 * @param driver:The current web driver instance.
	 * @param waitTimeOut:TimeOut value in seconds which decides how long to wait for an element
	 */
	public static void implicitWait(WebDriver driver, long waitTimeOut) {
		driver.manage().timeouts().implicitlyWait(waitTimeOut, TimeUnit.SECONDS);
	}
//**************************************************************************************************************

	/**
	 * <p>This method used for Explicit condition:
	 * <br> This method uses "presenceOfElementLocated", An expectation for checking that an element is present on the DOM of a page. </br> This does not necessarily mean that the element is visible </p>
	 * @param Locator:The Locator element for which this wait method is being called.
	 * @param driver:The current WebDriver instance.
	 * @param waitTimeOut:TimeOut value in seconds which decides how long to wait for an element
	 */
	public static Boolean isElementPresent(By Locator, WebDriver driver,
			long waitTimeOut) {
		
		try {
			WebDriverWait WT = new WebDriverWait(driver, waitTimeOut);
			WT.until(ExpectedConditions.presenceOfElementLocated(Locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//**************************************************************************************************************

	/**
	 * <p>This method check if an element is visible on the web page </p>
	 * @param Locator:The Locator element for which this wait method is being called.
	 * @param driver:The current WebDriver instance.
	 * @param waitTimeOut:TimeOut value in seconds which decides how long to wait for an element.
	 */
	public static Boolean isElementDisplayed(By Locator, WebDriver driver,long waitTimeOut)
	{
		try{
			long end = System.currentTimeMillis() + waitTimeOut;
			while (System.currentTimeMillis() < end)
			{
				if (driver.findElement(Locator).isDisplayed()) {
					break;
				}
			}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
//**************************************************************************************************************	
	/**
	 * <p>This method used for Explicit condition
	 * <br> This method uses "visibilityOfElementLocated" , An expectation for checking that an element is present on the DOM of a page and visible. Visibility means that the element is not only displayed but also has a height and width that is greater than 0.</br></p>
	 * @param Locator:The Locator element for which this wait method is being called.
	 * @param driver:The current WebDriver instance.
	 * @param waitTimeOut:TimeOut value in seconds which decides how long to wait for an element.
	 */
	public static Boolean isElementVisible(By Locator, WebDriver driver,
			long waitTimeOut) {
		try {
			WebDriverWait WT = new WebDriverWait(driver, waitTimeOut);
			WT.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//**************************************************************************************************************	
	/**
	 * <p>This method used for Explicit condition
	 * <br> This method uses "elementToBeClickable" , An expectation for checking an element is visible and enabled such that you can click it. </br></p>
	 * @param Locator:The Locator element for which this wait method is being called.
	 * @param driver:The current WebDriver instance.
	 * @param waitTimeOut:TimeOut value in seconds which decides how long to wait for an element.
	 */
	public static Boolean isElementClickable(WebElement Locator, WebDriver driver,
			long waitTimeOut) {
		try {
			WebDriverWait WT = new WebDriverWait(driver, waitTimeOut);
			WT.until(ExpectedConditions.elementToBeClickable(Locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//**************************************************************************************************************	
	/**
	 * <p>This method means that execution is paused until the page is loaded.
	 * @param driver:The current WebDriver instance.
	 */
	public static void waitForPageToLoad(WebDriver driver) {
			do {
		      js = (JavascriptExecutor) driver;
		      pageLoadStatus = (String)js.executeScript("return document.readyState");
		    } while ( !pageLoadStatus.equals("complete") );
		 
		  }
	

}
