package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactsPage;
import utils.BaseTest;
import utils.ScreenShots;

public class SendMessagesTest extends BaseTest{
	
	@Test
	public void sendMessageReturnsSucessMessage() {
		ContactsPage contactsPage = navMenu.navToContacts();
		contactsPage.sendMessage("Test", "test@test.test", "test subject", "test message");
		assertTrue(contactsPage.returnMessageSentInfo("Thank you for your message. It has been sent."));
	}

	@Test
	public void sendMessageWithoutNameReturnsFalse() {
		ContactsPage contactsPage = navMenu.navToContacts();
		contactsPage.sendMessage("", "test@test.test", "test subject", "test message");
		assertTrue(contactsPage.emptyFieldWarrningMessage());
		ScreenShots shot = new ScreenShots();
		shot.screenshot(driver);
	}
}
