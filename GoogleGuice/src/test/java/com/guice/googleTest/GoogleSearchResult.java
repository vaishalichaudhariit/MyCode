/**
 * 
 */
package com.guice.googleTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class GoogleSearchResult {

	@FindBy(className = "rc")
    private List<WebElement> results;

    @Inject
    public GoogleSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getCount() {
        return results.size();
    }

    public void displayResult() {
        results.stream()
            .map(WebElement::getText)
            .forEach(System.out::println);
    }
}
