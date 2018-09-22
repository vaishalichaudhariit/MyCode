/**
 * 
 */
package com.guice.googleTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.guice.googleTest.DriverModule;


/**
 * @author Vaishali.Chaudhari
 *
 */
@Guice(modules = {
	    DriverModule.class
	})
	public class GuiceTest {

	    @Inject
	    Google google;

	    @BeforeMethod
		public void setUp(){
	    	 google.goTo();
		}
	    
	    @Test(dataProvider = "google-test")
	    public void f(String txt, String color) throws InterruptedException {

	    	//change the color of the google page
	        google.execute("document.body.style.backgroundColor='" + color + "';");

	       //do search and show results
	        google.getSearchWidget().searchFor(txt);
	        google.getResults().displayResult();
	    }

	    @DataProvider(name = "google-test")
	    public static Object[][] getData() {
	        return new Object[][] {
	            {
	                "guru",
	                "blue"
	            }, {
	                "guice",
	                "green"
	            }
	        };
	    }

	}
