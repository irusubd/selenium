package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	
	public WebDriver driver;
	public WebElement dropdown;
	public Select selectDropdown;

	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToPage() {
		driver.get("https://keybooks.ro/account/edit-address/shipping/");
	}
	
	public By countryDropDown = By.id("shipping_country");
	
	public void setCountry(int index) {
		dropdown = driver.findElement(countryDropDown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByIndex(index);
	}
	
	public String getCountry() {
		dropdown = driver.findElement(countryDropDown);
		selectDropdown = new Select(dropdown);
		return selectDropdown.getFirstSelectedOption().getText();
	}
	
	public By stateDropDown = By.id("shipping_state");
	
	public void setState(String value) {
		dropdown = driver.findElement(stateDropDown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByValue(value);
	}
	
	public String getState() {
		dropdown = driver.findElement(stateDropDown);
		selectDropdown = new Select(dropdown);
		return selectDropdown.getFirstSelectedOption().getText();
	}
	


}
