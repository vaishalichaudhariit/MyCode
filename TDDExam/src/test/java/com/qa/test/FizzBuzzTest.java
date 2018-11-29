package com.qa.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.qa.mainclass.FizzBuzz;

/*
 * TDD- Test Driven Development \ Test First approach (then Code latter)
 * Red - Write the test that Fails
 * Re-factor- Improve code quality by Refactoring
 * Green - Make the code Pass
 */
public class FizzBuzzTest {
	
	private FizzBuzz fizzBuzz;
	
	@Before
	public void setUp(){
		fizzBuzz = new FizzBuzz();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testNumber(){
		
		int number = 1;
		String numberRet = fizzBuzz.play(number);
		Assert.assertEquals("1", numberRet);
	}
	@Test
	public void testFizz(){
		int number = 3;
		String numberRet = fizzBuzz.play(number);
		Assert.assertEquals("Fizz", numberRet);
	}
	
	@Test
	public void testBuzz(){
		int number = 5;
		String numberRet = fizzBuzz.play(number);
		Assert.assertEquals("Buzz", numberRet);
	}
	
	@Test
	public void testBuzzDivisibleBy5(){
		int number = 10;
		String numberRet = fizzBuzz.play(number);
		Assert.assertEquals("Buzz", numberRet);
	}
	
	
	@Test
	public void testFizzDivisibleBy3(){
		int number = 6;
		String numberRet = fizzBuzz.play(number);
		Assert.assertEquals("Fizz", numberRet);
	}

}
