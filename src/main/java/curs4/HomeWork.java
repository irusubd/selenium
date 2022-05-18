package curs4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeWork extends BaseTest {

	@Test(priority=0)
	public void addToCart() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		WebElement searchButton = driver.findElement(By.cssSelector("button[title='Open search']"));
		searchButton.click();

		driver.findElement(By.cssSelector("input[class='search_field']")).sendKeys("The story about me");
		searchButton.click();

		WebElement aboutMeBook = null;
		
		while (true) {
			
			try {
				aboutMeBook = driver.findElement(By.cssSelector("a[href*='about-me']"));
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				driver.findElement(By.cssSelector("span[class='viewmore_text_1']")).click();
			}
		}
		
		Thread.sleep(2000);
		aboutMeBook.click();
		
		driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();
		
		sa.assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-message']")).getText().contains("added to your cart"));	
		
		driver.findElement(By.cssSelector("div[class='woocommerce-message'] a[href*='cart']")).click();
		
		sa.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");
		
		sa.assertAll();

	}
	
	@Test(priority=1)
	public void placeOrder() throws InterruptedException {
		
		SoftAssert sa = new SoftAssert();
		
		WebElement qty = driver.findElement(By.cssSelector("input[title='Qty']"));
		qty.clear();
		qty.sendKeys("2");
		
		driver.findElement(By.cssSelector("button[name='update_cart']")).click();
		
		sa.assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-message']")).getText().contains("updated"));	
		
		driver.findElement(By.cssSelector("a[class*='checkout-button']")).click();
		
		sa.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
		
		sa.assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields'] h3")).getText().contentEquals("Billing details"));
		sa.assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields'] h3")).getText().contentEquals("Additional information"));
		
		sa.assertAll();
		
	}

}


