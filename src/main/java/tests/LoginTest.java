package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority=0, groups = "LoginFunctionality")
	public void loginTest(String username, String password) {
		
		
		LoginPage loginPage = navMenu.navigateToLogin();
		loginPage.loginInApp(username, password);
		assertEquals(navMenu.getLoggedUser(), "Test User");
		loginPage.logoutFromApp();
	}
	
	@Parameters({"invalidUser", "invalidPass"})
	@Test(priority=1, groups = "LoginFunctionality")
	public void invalidLoginTest(String username, String password) {
		
		LoginPage loginPage = navMenu.navigateToLogin();
		loginPage.loginInApp(username, password);
		assertTrue(loginPage.loginErrorIsDisplayed());
		
	}
	

}
