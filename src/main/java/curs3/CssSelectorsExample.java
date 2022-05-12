package curs3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorsExample extends BaseTest {
	
	@Test(priority=1)
	public void cssSelector1() {
		
		// ul[id='menu_user']
		// #menu_user
		// By.id('menu_user')
		
		// id --> #
		WebElement loginPopup = driver.findElement(By.cssSelector("#menu_user"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", loginPopup);
		System.out.println(loginPopup.getText());
		
		// class --> .
		WebElement logoSlogon = driver.findElement(By.cssSelector(".logo_slogan"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", logoSlogon);
		System.out.println(logoSlogon.getText());
		
		// div.column-1_2 h3.sc_title_underline
		WebElement inspireText = driver.findElement(By.cssSelector("div.column-1_2 h3.sc_title_underline"));
		System.out.println(inspireText.getText());
		
		// div[class*='column-1_2'] h3.sc_title_underline
		WebElement inspireText2 = driver.findElement(By.cssSelector("div[class*='column-1_2'] h3.sc_title_underline"));
		System.out.println(inspireText2.getText());
		
		// div[class*='column-1_2'] h3[class*='sc_title_underline']
		WebElement inspireText3 = driver.findElement(By.cssSelector("div[class*='column-1_2'] h3[class*='sc_title_underline']"));
		System.out.println(inspireText3.getText());

		
		
	}

}
