package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import pages.ShippingAddressPage;
import utils.BaseTest;

public class ShippingAddressTest extends BaseTest{
	
	@Test
	public void loginTest() {
		
		LoginPage loginPage = navMenu.navigateToLogin();
		loginPage.loginInApp("TestUser", "12345@67890");
		assertEquals(navMenu.getLoggedUser(), "Test User");
		
		ShippingAddressPage shipAddr = new ShippingAddressPage(driver);
		shipAddr.goToPage();
		
		shipAddr.setCountry(41);
		assertEquals(shipAddr.getCountry(), "Canada");
		
		shipAddr.setState("NL");
		assertEquals(shipAddr.getState(), "Newfoundland and Labrador");
		
	}

}
