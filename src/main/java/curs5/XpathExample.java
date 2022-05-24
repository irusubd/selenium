package curs5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest {

	@Test(priority = 0)
	public void xpathExample1() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// css: li[class='menu_user_login']
		// xpath: //li[@class='menu_user_login']

		WebElement loginMenu = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", loginMenu);
		loginMenu.click();
		Thread.sleep(2000);

		WebElement userField = driver.findElement(By.xpath("//input[@id='log' and @name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", userField);
		userField.sendKeys("TestUser");
		Thread.sleep(2000);

		WebElement passField = driver.findElement(By.xpath("//input[@id='password'] [@name='pwd']"));
//		WebElement passField = driver.findElement(By.xpath("//input[@id='password' and @name='pwd']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", passField);
		passField.sendKeys("12345@67890");
		Thread.sleep(2000);

		WebElement checkBox = driver.findElement(By.xpath("//input[@id='rememberme']"));
		checkBox.click();

		WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit_button']"));
		loginButton.click();

		WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
		assertEquals(userName.getText(), "Test User");

	}

	@Test(priority = 0)
	public void xpathExample2() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
		userName.click();

		WebElement settingsLink = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		settingsLink.click();

		WebElement recentOrdersLink = driver.findElement(By.xpath("//a[contains(text(),'recent')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')",
				recentOrdersLink);
		Thread.sleep(2000);
		recentOrdersLink.click();

		WebElement orderTableHeader = driver
				.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders')]/span[contains(text(),'Order')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')",
				orderTableHeader);
		Thread.sleep(2000);

		WebElement statusTableHeader = driver
				.findElement(By.xpath("(//th[contains(@class, 'woocommerce-orders')]/span)[3]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')",
				statusTableHeader);
		Thread.sleep(2000);

		// xpath: //td[contains(@class,
		// 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),'1653')]
		// css:
		// td[class*='woocommerce-orders-table__cell'][data-title='Order']>a[href*='1653']

		WebElement orderNr = driver.findElement(By.xpath(
				"//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),'1653')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", orderNr);
		Thread.sleep(2000);
		orderNr.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1653/");

	}

}
