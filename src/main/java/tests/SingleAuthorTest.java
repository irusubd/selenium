package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

public class SingleAuthorTest extends BaseTest{
	
	@Test
	public void skillTest() throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateToSingleAuthor();
		
		SingleAuthorPage singleAuthorPage = new SingleAuthorPage(driver);
		
		assertEquals(singleAuthorPage.getSkillTotal("Drama"), "95%");
		assertEquals(singleAuthorPage.getSkillTotal("Biography"), "75%");
		assertEquals(singleAuthorPage.getSkillTotal("Cookbooks"), "82%");
		
	}

}
