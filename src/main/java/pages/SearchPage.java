package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	public WebDriver driver;
	public String title;
	public SearchPage(WebDriver driver, String title) {
		this.driver = driver;
		this.title = title;
	}
	
	public By searchLink = By.cssSelector("button[title='Open search']");
	public By searchField = By.name("s");
	
	public By bookImage = By.cssSelector("img[class='wp-post-image']");
	
	public void searchBook() {
		driver.findElement(searchLink).click();
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(title,Keys.ENTER);
	}
	
	public String getImageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(bookImage));

		return driver.findElement(bookImage).getAttribute("alt");
		
	}


}
