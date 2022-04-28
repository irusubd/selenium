package curs1;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;

public class TestNgDependency {
	
	@Test
	public void method1() {
		//assertTrue(false);
		System.out.println("method 1");
	}
	
	@Test(dependsOnMethods = "method1")
	public void method2() {
		System.out.println("method 2");
	}
	
	@Test(dependsOnMethods = "method1")
	public void method3() {
		System.out.println("method 3");
	}

}
