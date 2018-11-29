package MyTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Analyzer.RetryAnalyzerClass;


public class MyTests {

	@Test(retryAnalyzer = RetryAnalyzerClass.class)
	public void Test1()
	{
		Assert.assertEquals(false,true);
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertTrue(false);
	}
	
	@Test(retryAnalyzer = RetryAnalyzerClass.class)
	public void Test2()
	{
		Assert.assertEquals(false,true);
	}
	
	@Test(retryAnalyzer = RetryAnalyzerClass.class)
	public void Test3()
	{
		Assert.assertEquals(true,true);
	}
}
