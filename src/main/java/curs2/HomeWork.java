package curs2;


import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeWork extends BaseTest{
	
	@Test
	public void checkLogin() throws InterruptedException {
		
		WebElement loginLink = driver.findElement(By.cssSelector("a[href='#popup_login']"));
		WebElement loginEmail = driver.findElement(By.id("log"));
		WebElement loginPass = driver.findElement(By.id("password"));
		
		SoftAssert sa = new SoftAssert();
		sa.assertFalse(loginEmail.isDisplayed());
		sa.assertFalse(loginPass.isDisplayed());
		
		assertTrue(loginLink.isDisplayed());
		
		loginLink.click();
		
		Thread.sleep(1000); //explicit wait in cursul 3 ?

		sa.assertTrue(loginEmail.isDisplayed());
		sa.assertTrue(loginPass.isDisplayed());
		sa.assertAll();
		
	}
	
}
