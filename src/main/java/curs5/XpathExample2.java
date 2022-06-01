package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample2 extends BaseTest{
	
//	@Test(priority=0)
	public void xpathExample1() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", popupLink);
		Thread.sleep(2000);
		popupLink.click();
		
		//child //form[contains(@class,'popup_form')]/child::div[contains(@class,'login_field')]/child::input[@id='log']
		WebElement userField = driver.findElement(By.xpath("//form[contains(@class,'popup_form')]/child::div[contains(@class,'login_field')]/child::input[@id='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", userField);
		userField.sendKeys("TestUser");
		Thread.sleep(2000);
		
		//descendant //form[contains(@class,'popup_form')]/descendant::input[@id='log']
		WebElement passField = driver.findElement(By.xpath("//form[contains(@class,'popup_form')]/descendant::input[@id='password']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", passField);
		passField.sendKeys("TestUser");
		Thread.sleep(2000);
		
		// following sibling
		WebElement rememberMeBox = driver.findElement(By.xpath("//div[contains(@class, 'login_field' )]/following-sibling::div[contains(@class, 'remember_field')]/input"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", rememberMeBox);
		rememberMeBox.click();
		Thread.sleep(2000);
		
		// preceding
		WebElement submitButton = driver.findElement(By.xpath("//form[contains(@class, 'login_form')]/preceding::input[@class='submit_button']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", submitButton);
		submitButton.click();
		Thread.sleep(2000);
	}
	
	@Test
	public void xpathExample2() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", popupLink);
		Thread.sleep(2000);
		popupLink.click();	
		
		// ancestor
		WebElement username = driver.findElement(By.xpath("//input[contains(@class, 'submit_button')]/ancestor::form/div[contains(@class, 'login_field')]/input"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", username);
		username.sendKeys("TestUser");
		Thread.sleep(2000);
		
		// 
		WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'submit_button')]/ancestor::form/child::div[contains(@class, 'password_field')]/input"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", password);
		password.sendKeys("12345@67890");
		Thread.sleep(2000);
		
		WebElement rememberMe = driver.findElement(By.xpath(""));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", rememberMe);
		rememberMe.click();
		Thread.sleep(2000);
		
		
			
		}
		
		
		
		
	}

