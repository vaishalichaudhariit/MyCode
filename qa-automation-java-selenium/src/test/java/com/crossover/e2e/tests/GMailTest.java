package com.crossover.e2e.tests;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GMailTest {
	private WebDriver driver;
	private Properties properties = new Properties();

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		properties
				.load(new FileReader(
						new File(
								"D:\\SeleniumWorkspace\\qa-automation-java-selenium\\src\\main\\java\\com\\crossover\\e2e\\config\\test.properties")));
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void testSendEmail() throws Exception {
		driver.get("https://mail.google.com/");
		WebElement userElement = driver.findElement(By.id("identifierId"));
		userElement.sendKeys(properties.getProperty("username"));

		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		Thread.sleep(3000);

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(properties.getProperty("password"));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		Thread.sleep(1000);

		WebElement composeElement = driver.findElement(By
				.xpath("//*[@role='button' and (.)='Compose']"));
		WebDriverWait WT = new WebDriverWait(driver, 2000);
		WT.until(ExpectedConditions.elementToBeClickable(composeElement));
		composeElement.click();
		driver.findElement(By.name("to")).clear();
		driver.findElement(By.name("to")).sendKeys(
				String.format("%s@gmail.com",
						properties.getProperty("username")));
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmmss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		driver.findElement(By.name("subjectbox")).sendKeys(
				"Crossover Assignment " + currentDate);
		driver.findElement(
				By.xpath("//*[@role='textbox' and @aria-label='Message Body']"))
				.sendKeys("Crossover Assignment " + currentDate);

		driver.findElement(
				By.xpath("//*[@role='button' and @aria-label='More options']"))
				.click();
		driver.findElement(
				By.xpath("//div[@class='J-N-Jz' and contains(text(),'Label')]"))
				.click();
		driver.findElement(
				By.xpath("//div[contains(text(),'Label as')]/following::input[1]"))
				.sendKeys("Social");
		driver.findElement(
				By.xpath("//div[contains(text(),'Label as')]/following::span[1]"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//*[@role='button' and @aria-label='Attach files']"))
				.click();
		Thread.sleep(4000);
		// Upload file using AutoIT script .
		Runtime.getRuntime().exec("D:\\AUTO_IT\\FileUpload.exe");

		Thread.sleep(6000);

		driver.findElement(By.xpath("//*[@role='button' and text()='Send']"))
				.click();
		Thread.sleep(4000);

		driver.findElement(
				By.xpath("//*[@role='tab' and @aria-label='Social']")).click();

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"
				+ System.currentTimeMillis() + ".png"));

		// now talking un-read email form inbox into a list
		List<WebElement> unreademail = driver.findElements(By
				.xpath("//*[@class='zF']"));

		// Mailer name for which i want to check do i have an email in my inbox
		String MyMailer = String.format("%s@gmail.com",
				properties.getProperty("username"));

		// real logic starts here
		for (int i = 0; i < unreademail.size(); i++) {
			if (unreademail.get(i).isDisplayed() == true) {
				// now verify if you have got mail form a specific mailer (Note
				// Un-read mails)
				// for read mails xpath loactor will change but logic will
				// remain same
				System.out.println(unreademail.get(i).getText());
				if (unreademail.get(i).getText().equals("me")) {
					System.out.println("Yes we have got mail form " + MyMailer);
					unreademail.get(i).click();
					System.out.println(driver.getTitle());
					break;
				}
			}
		}

	}
}
