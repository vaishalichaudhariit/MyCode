/**
 * 
 */
package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.JSONReader;
import com.crm.qa.util.TestUtil;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	//String sheetName = "contacts";
	

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	/*@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),
				"contacts label is missing on the page");
	}

	@Test(priority = 4)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Aaaron Peter");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Aaaron Peter");
		contactsPage.selectContactsByName("Aaaron Andrew");

	}
*/
	@DataProvider(name="contacts")
	public Object[][] getCRMTestData() throws IOException, ParseException
	{
		//return JSONReader.getJSONdata("D:/MyCode/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.json", "contacts",4);
		return JSONReader.getdata(prop.getProperty("JSON_path")+"FreeCRMTestData.json", "contacts",2 , 4);
	}
	
	
	/* Take data from Excel sheet 
	 * @DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}*/

	/*@Test(priority = 2, dataProvider = "contacts")
	public void validateCreateNewContact(String title, String firstName,
			String lastName, String company) {
		homePage.clickOnNewContactLink();
		// contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);

	}*/
	
	@Test(priority = 1)
	public void validateCreateNewContact() throws JsonParseException, JsonMappingException, IOException {
		homePage.clickOnNewContactLink();
	
		 ObjectMapper mapper = new ObjectMapper();

         // read JSON from a file
         Map<String, Object> jsonMap = mapper.readValue(new File(
        		 "D:\\FreeCRMTestData.json"),
                 new TypeReference<Map<String, Object>>(){});
         
         System.out.println("*** JSON File Contents ***");
         System.out.println("title : "+jsonMap.get("title"));
         System.out.println("firstName : "+jsonMap.get("firstName"));
         System.out.println("lastName : "+jsonMap.get("lastName"));
         System.out.println("company : "+jsonMap.get("company"));

	}
	 

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
