package curs5;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeWork extends BaseTest {

	@Test
	public void leaveReview() {

		SoftAssert sa = new SoftAssert();
		
		List<WebElement> booksList = driver.findElements(By.xpath("//div[@aria-hidden='false']/descendant::h3[contains(@class, 'sc_title_regular')]"));
		Random rand = new Random();
		WebElement bookSelected = booksList.get(rand.nextInt(booksList.size()));
		bookSelected.click();
		
		driver.findElement(By.xpath("//li[@class='reviews_tab']")).click();
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='wp-comment-cookies-consent']"));
		sa.assertFalse(checkbox.isSelected());
		
		driver.findElements(By.xpath("//p[@class='stars']/descendant::a")).get(3).click();
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Excellent book!");
		driver.findElement(By.xpath("//input[@id='author']")).sendKeys("irusu");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gmail@irusu.com");
		checkbox.click();
		sa.assertTrue(checkbox.isSelected());
		
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		sa.assertEquals(driver.findElement(By.xpath("//em[@class='woocommerce-review__awaiting-approval']")).getText(), "Your review is awaiting approval");
		
		sa.assertAll();
		
	}

}