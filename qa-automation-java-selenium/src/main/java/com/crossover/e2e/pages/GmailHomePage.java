/**
 * 
 */
package com.crossover.e2e.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.crossover.e2e.base.TestBase;
import com.crossover.e2e.util.TestUtil;
import com.crossover.e2e.util.WaitUtil;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class GmailHomePage extends TestBase{
	
	@FindBy(xpath="//*[@role='button' and (.)='Compose']")
	WebElement btnComposeElement;
	
	@FindBy(name="to")
	WebElement txtTo;
	
	@FindBy(name="subjectbox")
	WebElement txtSubject;
	
	@FindBy(xpath="//*[@role='textbox' and @aria-label='Message Body']")
	WebElement txtMessageBody;
	
	@FindBy(xpath="//*[@role='button' and @aria-label='More options']")
	WebElement btnMoreOption;
	
	@FindBy(xpath="//div[@class='J-N-Jz' and contains(text(),'Label')]")
	WebElement menuLabel;
	
	@FindBy(xpath="//div[contains(text(),'Label as')]/following::input[1]")
	WebElement txtLabel;
	
	@FindBy(xpath="//div[contains(text(),'Label as')]/following::span[1]")
	WebElement checkBoxSocial;
	
	@FindBy(xpath="//*[@role='button' and @aria-label='Attach files']")
	WebElement btnAttachFile;
	
	@FindBy(xpath="//*[contains(text(),'Attachment')]")
	WebElement AttachFile;
		
	@FindBy(xpath="//*[@role='button' and text()='Send']")
	WebElement btnSend;
	
	@FindBy(xpath="//*[@role='tab' and @aria-label='Social']")
	WebElement tabSocial;
	
	public static String strSubject = "Crossover Assignment Subject " +TestUtil.date();
	public static String strBody = "Crossover Assignment Body " +TestUtil.date();
	public static String strEmail =String.format("%s@gmail.com",prop.getProperty("username"));
	
	/*
	 * Initialize Page Objects
	 * purpose: Initialize element in PageFactory using initElements method with driver and this (current class Obj)
	 */
	
	public GmailHomePage(){	
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public void sendEmail() throws InterruptedException, IOException{
		WaitUtil.isElementClickable(btnComposeElement, driver, WaitUtil.WAIT_TIMEOUT);
		btnComposeElement.click();
		Thread.sleep(3000);
		txtTo.clear();
		txtTo.sendKeys(strEmail);
		txtSubject.sendKeys(strSubject);
		txtMessageBody.sendKeys(strBody);
		/*btnAttachFile.click();
		Thread.sleep(2000);
		// Upload file using AutoIT script .
		Runtime.getRuntime().exec("D:\\AUTO_IT\\FileUpload.exe");
		Thread.sleep(6000);
		WaitUtil.isElementClickable(btnMoreOption, driver, WaitUtil.WAIT_TIMEOUT);*/
		btnMoreOption.click();
		menuLabel.click();
		txtLabel.sendKeys("Social");
		checkBoxSocial.click();
		Thread.sleep(2000);
		btnSend.click();
		Thread.sleep(4000);
	}
	
	public boolean verifyEmailOnSocialLabel() throws IOException{
		boolean flag = false;
		tabSocial.click();	
		TestUtil.takeScreenshotAtEndOfTest();
		// now talking un-read email form inbox into a list
		List<WebElement> unreademail = driver.findElements(By
				.xpath("//*[@class='zF']"));

		// Mailer name for which i want to check do i have an email in my inbox
		String MyMailer = String.format("%s@gmail.com",	prop.getProperty("username"));

		// real logic starts here
		for (int i = 0; i < unreademail.size(); i++) {
			if (unreademail.get(i).isDisplayed() == true) {
				// now verify if you have got mail form a specific mailer 
				//As I am sending mail from same email id, gmail showing email from "me"
				if (unreademail.get(i).getText().equals("me")) {
					System.out.println("Yes we have got mail form " + MyMailer);
					unreademail.get(i).click();
					flag = true;
					System.out.println(driver.getTitle());
					break;
					
				}
			}
		}
		return flag;
	}
	
	public boolean verifyAttachmentName() throws IOException, InterruptedException{
		//*[contains(text(),'Attachment Vaishali Chaudhari - CV.docx added')]
		Thread.sleep(4000);
		boolean attachmentName = AttachFile.isDisplayed();
		System.out.println("attachmentName: " + attachmentName);
		return attachmentName;
	}

	

	


}
