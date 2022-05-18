package curs3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class HomeWork extends BaseTest{
	
	@Test
	public void checkCategories() throws InterruptedException {
		
		SoftAssert sa = new SoftAssert();
		WebElement forestBook = null;
		
		List<WebElement> categories = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		
		for(WebElement cat : categories) {
			cat.click();
			forestBook = driver.findElement(By.partialLinkText("forest"));
			sa.assertTrue(forestBook.isDisplayed());
		}
		
		forestBook.click();
		
		sa.assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");
		
		sa.assertAll();
		
	}
	
}
