package curs1;

import org.testng.annotations.*;

public class TestNgPriority {
	
	@Test(priority=0)
	public void one() {
		System.out.println("first");
	}
	
	@Test(priority=1)
	public void two() {
		System.out.println("second");
	}
	
	@Test(priority=2)
	public void three() {
		System.out.println("third");
	}
	
	@Test()
	public void four() {
		System.out.println("fourth");
	}
	
	@Test()
	public void five() {
		System.out.println("fifth");
	}
	

}
