/**
 * 
 */
package com.crossover.e2e.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.SearchTerm;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crossover.e2e.base.TestBase;

/**
 * @author Vaishali.Chaudhari purpose: define static variables and methods
 */
public class TestUtil extends TestBase {
	
	public static Message message;

	public static String date(){
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmmss");
	Date date = new Date();
	String currentDate = formatter.format(date);
	return currentDate;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"
				+ System.currentTimeMillis() + ".png"));

	}

	public static Message getEmailMessage() throws FileNotFoundException,
			IOException, MessagingException {
		
		
		String MyMailer = String.format("%s@gmail.com",
				prop.getProperty("username"));
		// server setting
		prop.put("mail.imap.host", "imap.gmail.com");
		prop.put("mail.imap.port", 993);
		// SSL setting
		prop.setProperty("mail.imap.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.imap.socketFactory.fallback", "false");
		prop.setProperty("mail.imap.socketFactory.port",
				String.valueOf(993));
		Session session = Session.getDefaultInstance(prop);

		Store store = session.getStore("imap");
		// Connect to your email account
		store.connect(MyMailer, prop.getProperty("password"));
		// Get reference to your INBOX
		Folder folder = store.getFolder("INBOX");
		// Open the folder in READ MODE only
		folder.open(Folder.READ_ONLY);

		// creates a search criterion
		@SuppressWarnings("serial")
		SearchTerm searchCondition = new SearchTerm() {
			@Override
			public boolean match(Message message) {
				try {
					if (message.getSubject().contains("Crossover Assignment")) {
						return true;
					}
				} catch (MessagingException ex) {
					ex.printStackTrace();
				}
				return false;
			}
		};

		// performs search through the folder
		Message[] foundMessages = folder.search(searchCondition);

		for (int j = 0; j < foundMessages.length; j++) {
			 message = foundMessages[j];
         
		}
		return message;

	}

	public static String getEmailSubject() throws FileNotFoundException, IOException, MessagingException{
		Message msg = getEmailMessage();
		String subject = msg.getSubject();
		System.out.println("Found message subject #: " + subject);
		return subject;
	}
	
	public static String getEmailID() throws FileNotFoundException, IOException, MessagingException{
		Message msg = getEmailMessage();
	    Address[] froms = msg.getFrom();
	    String email = froms == null ? null : ((InternetAddress)froms[0]).getAddress();
	    System.out.println("Found message email from #: " + email);
		return email;
	}
	public static String getEmailBody() throws FileNotFoundException, IOException, MessagingException{
		Message msg = getEmailMessage();
		String body = getEmailBodyPart(msg);
		System.out.println("Found message body #: " + body);
		return body;
		
	}
	
	public static String getEmailBodyPart(Part p) throws MessagingException,
			IOException {
		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			// boolean textIsHtml = p.isMimeType("text/html");
			return s;
		}
		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart) p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getEmailBodyPart(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getEmailBodyPart(bp);
					if (s != null)
						return s;
				} else {
					return getEmailBodyPart(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getEmailBodyPart(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}
		return null;
	}
}
