/**
 * 
 */
package com.guice.googleTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class Google {

	 private final WebDriver driver;

	    @Inject
	    @Named("application.url")
	    private String URL;

	    @Inject
	    private GoogleSearchWidget searchBox;

	    @Inject
	    private GoogleSearchResult searchResult;

	    @Inject
	    private Actions actions;

	    @Inject
	    private JavascriptExecutor jsExecutor;

	    @Inject
	    public Google(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void goTo() {
	        this.driver.get(this.URL);
	        this.driver.manage().window().maximize();
	    }

	    public GoogleSearchWidget getSearchWidget() {
	        return searchBox;
	    }

	    public GoogleSearchResult getResults() {
	        return searchResult;
	    }

	    public Object execute(String script) {
	        return jsExecutor.executeScript(script);
	    }
}
