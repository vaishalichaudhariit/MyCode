package com.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features ="D:/SeleniumWorkspace/CucumberPOM/src/test/java/com/qa/features/freecrm.feature" // feature file path
		,glue={"com/qa/stepDefinitions"}, // step definition file path
		format={"pretty","html:test-ourput", "json:json-outpt/cucumber.jason", "junit:junit_xml/cucumber.xml"}, //result format
		monochrome = true, //display the console output in a proper readable format
		strict = true, //if any step definition not define then test will fail
		dryRun = false //to check the mapping between feature file and step definition file
		// tags = {"~@SmokeTest", "~@End2End", "~@RegressionTest"} // OR mean , e.g. OR : tags = {"@SmokeTest, @End2End"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
										// AND mean , with "" AND : tags = {"@SmokeTest", "@End2End"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
										// Ignore test which will not execute with ~ , tags = {"~@SmokeTest", "~@End2End"}   
		)
public class TestRunner {

}
