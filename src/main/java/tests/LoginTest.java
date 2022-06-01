package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateToLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername("TestUser");
		loginPage.setPassword("12345@67890");
		loginPage.clickSubmit();
		assertEquals(navMenu.getLoggedUser(), "Test User");
		
	}

}
