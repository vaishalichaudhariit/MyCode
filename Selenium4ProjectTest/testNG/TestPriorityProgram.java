package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPriorityProgram {
	
	@BeforeTest
	public void testBefore() {
		System.out.println("I am in Before test");
	}
	
	@Test
	public void c_method(){
	System.out.println("I'm in method C");
	}
	@Test
	public void b_method(){
	System.out.println("I'm in method B");
	}
	@Test
	public void a_method(){
	System.out.println("I'm in method A");
	}
	@Test
	public void e_method(){
	System.out.println("I'm in method E");
	}
	@Test
	public void d_method(){
	System.out.println("I'm in method D");
	}
	
	@AfterTest
	public void testAfter() {
		System.out.println("I am in After test");
	}
}
