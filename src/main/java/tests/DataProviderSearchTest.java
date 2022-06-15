package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchPage;
import utils.BaseTest;

public class DataProviderSearchTest extends BaseTest{
	
	@DataProvider(name = "searchTestData")
	public Object[][] searchTestData() {
		
		Object data[][] = new Object[4][1];
		
		//title						
		data[0][0] = "A banquet of  mouse";
		data[1][0] = "Cooking with love";
		data[2][0] = "Let the sun shine";
		data[3][0] = "New galaxy";
		
		return data;
		
	}
	
	@Test(dataProvider = "searchTestData")
	public void searchTests(String bookTitle) {
		
		SearchPage searchPage = new SearchPage(driver, bookTitle);
		searchPage.searchBook();
		assertEquals(searchPage.getImageTitle(), bookTitle);
		
	}

}
