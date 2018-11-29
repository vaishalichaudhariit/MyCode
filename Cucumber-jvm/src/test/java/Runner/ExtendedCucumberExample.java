package Runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

	@RunWith(ExtendedCucumber.class)
	
	
	@ExtendedCucumberOptions(
	        jsonReport = "target/cucumber.json",
	        retryCount =3,
	        detailedReport = true,
	        detailedAggregatedReport = true,
	        overviewReport = true,
	        coverageReport = true,
	        jsonUsageReport = "target/cucumber-usage.json",
	        usageReport = true,
	        toPDF = true,
	        //,excludeCoverageTags = {""}
	        includeCoverageTags = {"@First"},
	        outputFolder = "target/LoginReport/ExtendedReport")
	
	
	@CucumberOptions(
			features ="D:/MyCode/Cucumber-jvm/src/test/java/Features/hooks.feature" // feature file path
			,glue={"stepDefinition"}, // step definition file path
			format={"pretty","html:test-ourput",
					"json:json-outpt/cucumber.json",
					"junit:junit_xml/cucumber.xml",
					"rerun:target/rerun.txt",
					"usage:target/cucumber-usage.json"}, //result format
			monochrome = true, //display the console output in a proper readable format
			strict = true, //if any step definition not define then test will fail
			dryRun = false //to check the mapping between feature file and step definition file
			// tags = {"~@SmokeTest", "~@End2End", "~@RegressionTest"} // OR mean , e.g. OR : tags = {"@SmokeTest, @End2End"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
											// AND mean , with "" AND : tags = {"@SmokeTest", "@End2End"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
											// Ignore test which will not execute with ~ , tags = {"~@SmokeTest", "~@End2End"}   
			)
	
public class ExtendedCucumberExample {

}
