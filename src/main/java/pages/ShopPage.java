package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	
	public WebDriver driver;
	public WebElement dropdown;
	public Select selectDropdown;

	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By orderDropDown = By.name("orderby");
	
	public void filterByValue(String value) {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByValue(value);
	}
	
	public void filterByIndex(int index) {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByIndex(index);
	}
	
	public void filterByVisibleText(String visibleText) {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByVisibleText(visibleText);
	}
	
	public String getCurrentSelectedOption() {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);
		return selectDropdown.getFirstSelectedOption().getText();
	}

}
