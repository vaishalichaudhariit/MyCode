package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransform implements IAnnotationTransformer{
	
	// Using IAnnotationTransformer Interface - MyTrasform will check how many test cases are failed 
	//and retrieve that count and go to the RetryAnalyzer class to verify what is retryLimit 
	//and execute each method as per the retryLimit. If all the attempt are failed then last execution mark as fail
	//e.g. Xpath issue, browser issue,  network issue, timeout issue etc.
	

		public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
		{
			annotation.setRetryAnalyzer(RetryAnalyzerClass.class);
			
			
			
		}
}
