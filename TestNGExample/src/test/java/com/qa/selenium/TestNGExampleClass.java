package com.qa.selenium;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGExampleClass {

	@BeforeMethod
	public void setUp() {
		System.out.println("I am in SetUp method");
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		System.out.println("I am in Test 1  method");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		System.out.println("I am in Test 2 method");
	}

	@Test(priority = 3)
	public void loginTest() throws IOException {
		System.out.println("I am in Test 3 method");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("I am in tearDown method");
	}

}
