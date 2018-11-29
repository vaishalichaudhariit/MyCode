/**
 * 
 */
package com.crossover.e2e.tests;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crossover.e2e.base.TestBase;
import com.crossover.e2e.pages.GmailHomePage;
import com.crossover.e2e.pages.GmailLoginPage;
import com.crossover.e2e.util.TestUtil;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class SendEmailTest extends TestBase{

	
	GmailLoginPage loginpage;
	GmailHomePage homepage;
	
	public SendEmailTest() {
		super(); //Super class constructor will call
	}

	@BeforeClass
	public void setUp() throws InterruptedException{
		//initialization();
		loginpage = new GmailLoginPage();
		homepage = new GmailHomePage();
		homepage = loginpage.login();
	}
	
	@Test(priority = 1)
	public void gmailSendMailTest() throws InterruptedException, IOException, MessagingException{
		homepage.sendEmail();
	}
	/*
	@Test(priority = 2)
	public void gmailVerifyEmailOnSocialLabelTest() throws InterruptedException, IOException, MessagingException{
		boolean gotEmail = homepage.verifyEmailOnSocialLabel();
		Assert.assertTrue(gotEmail);
	}
	
	@Test(priority = 3)
	public void gmailVerifyAttachmentNameTest() throws InterruptedException, IOException, MessagingException{
		boolean attachmentName = homepage.verifyAttachmentName();
		Assert.assertFalse(attachmentName);		
	}
	
	@Test(priority = 4)
	public void gmailVerifyEmailIDTest() throws InterruptedException, IOException, MessagingException{
		String email = TestUtil.getEmailID();
		Assert.assertEquals(email, GmailHomePage.strEmail);
	}
	
	@Test(priority = 5)
	public void gmailVerifyEmailSubjectTest() throws InterruptedException, IOException, MessagingException{
		String subject = TestUtil.getEmailSubject();
		Assert.assertEquals(subject, GmailHomePage.strSubject);
	}
	
	@Test(priority = 6)
	public void gmailVerifyEmailBodyTest() throws InterruptedException, IOException, MessagingException{
		String body = TestUtil.getEmailBody();
		Assert.assertTrue(body.contains(GmailHomePage.strBody));
	}*/
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
