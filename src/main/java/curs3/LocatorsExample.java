package curs3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import utils.BaseTest;

public class LocatorsExample extends BaseTest {
	
	@Test(priority=0)
	public void tagNameLocator() {
		
		WebElement emText = driver.findElement(By.tagName("em"));
		System.out.println("text: " +emText.getText());
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", emText);
		assertEquals(emText.getText(), "Discover");
		
	}
	
	@Test(priority=1)
	public void linkTextLocator() {
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", booksLink);
		booksLink.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
		
	}
	
	@Test(priority=2)
	public void partialLinkText() {
		WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", cookingBook);
		cookingBook.click();
		assertEquals(driver.getTitle(), "Cooking with love – Booklovers");
		
	}
	
	@Test(priority=3)
	public void classNameLocator() {
		WebElement productPrice = driver.findElement(By.className("price"));
		System.out.println(productPrice.getText());
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", productPrice);
		assertTrue(productPrice.getText().contains("20.55"));
	}
	
	@Test(priority=4)
	public void idLocator() {
		WebElement tabReview = driver.findElement(By.id("tab-title-reviews"));
		tabReview.click();
		WebElement comment = driver.findElement(By.id("comment-6"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", comment);
		assertTrue(comment.isDisplayed());
		
	}
	
	@Test(priority=5)
	public void checkBoxTest() throws InterruptedException {
		WebElement checkbox =driver.findElement(By.id("wp-comment-cookies-consent"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", checkbox);
		assertTrue(checkbox.isEnabled()); //functioneaza pe toate input
		//jseExecutor.executeScript("arguments[0].setAttribute('disabled','')", checkbox);
		checkbox.click();
		assertTrue(checkbox.isSelected()); //functioneaza doar pe checkboxuri type="checkbox"
		
	}
	
	@Test(priority=6)
	public void xpathLocator() {
		WebElement commentField = driver.findElement(By.xpath("//textarea[@id='comment']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", commentField);
		commentField.sendKeys("My comment");
	}
	
	@Test(priority=7)
	public void nameLocator() {
		WebElement nameField = driver.findElement(By.name("author"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", nameField);
		nameField.sendKeys("Johnny Bravo");
	}
	
	@Test(priority=8)
	public void cssSelector() {
		WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", emailField);
		emailField.sendKeys("gmail@johnnybravo.com");
		WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
		submitButton.click();
		
		Alert alertJs = driver.switchTo().alert();
		alertJs.accept();
		
		WebElement rating3Stars = driver.findElement(By.cssSelector("a[class='star-3']"));
		rating3Stars.click();
		submitButton.click();
	}
	
	
	

}
