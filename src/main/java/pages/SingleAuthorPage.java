package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SingleAuthorPage {

	public WebDriver driver;

	public SingleAuthorPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSkillTotal(String skill) throws InterruptedException {
		
		WebElement skillTotal = driver.findElement(By.xpath("//div[contains(text(),'"+skill+"')]/parent::div/following-sibling::div/div/div"));
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(skillTotal));
		
		return skillTotal.getText();
		
	}

}
