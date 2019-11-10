package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

/**
 * @author Vaishali.Chaudhari
 * @date 10 November 2019
 * @purpose Parent class - Read Property file and launch Application
 */
public class TestBase {
	public static WiniumDriver winiumDriver;
	public static Properties prop;
	
		
	/**
	 * @category constructor of the TestBaseclass 
	 * @purpose Read Property file
	 * @exception catch block - FileNotFoundException, IOException
	 */
	
	public TestBase(){
		
		String configFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties";
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);//FileNotFoundException
			prop.load(ip); //IOException
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @category static method of TestBaseclass 
	 * @purpose launch Application
	 * @throws MalformedURLException, InterruptedException
	 */
	
	public static void initialization() throws MalformedURLException, InterruptedException{
		String AppPath = prop.getProperty("application_path");
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath(AppPath);
		winiumDriver = new WiniumDriver(new URL("http://localhost:8888"), option);

		Thread.sleep(5000);
	}

}
