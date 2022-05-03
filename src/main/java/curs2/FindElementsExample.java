package curs2;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindElementsExample extends BaseTest {

	@Test
	void findElementsByExample1() throws InterruptedException {
		List<WebElement> bookPictures = driver.findElements(By.cssSelector("figure[class*='sc_image']"));

		for (WebElement picture : bookPictures) {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", picture);
			Thread.sleep(2000);

		}
	}

	@Test(priority = 1)
	public void findElementsExample() {

		List<WebElement> bookList = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
		System.out.println(bookList.size());
		bookList.get(2).click();

		String expectedUrl = "https://keybooks.ro/shop/life-in-the-garden/";
		assertEquals(expectedUrl, driver.getCurrentUrl());

		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Life in the garden – Booklovers");

		WebElement bookTitle = driver.findElement(By.cssSelector("h1[class*='product_title entry-title'"));

		assertEquals(bookTitle.getText(), "Life in the garden");

	}

}
