package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.slf4j.Logger;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import utils.LoggerHelper;
import utils.TestData;

public class HomePageTest extends Base {
	private static final Logger logger = LoggerHelper.getLogger(HomePageTest.class);

	@Test(testName = "Flipkart logo displayed test")
	public void testLogo() {
		HomePage homepage = new HomePage(driver);
		Boolean Displayed = homepage.getFlipkartLogoStatus();
		assertTrue(Displayed, "Flipkart logo not displayed in Homepage");
		logger.info("Flipkart Logo is Displayed");
		extentTest.pass("Flipkart logo is displayed in Homepage");
	}

	@Test(testName = "Search box content validation test")
	public void testSearchField() {
		HomePage homepage = new HomePage(driver);
		String pageFieldContent = homepage.getSearchBoxText();
		assertEquals(pageFieldContent, "Search for Products, Brands and More", "Search box placeholder mismatch");
		logger.info("Valid data is displayed in search field");
		extentTest.pass("Valid data is displayed in search field");
	}

	@Test(testName = "Verify fashion Submenu")
	public void testFashionSubMenu() {
		HomePage homepage = new HomePage(driver);
		TestData data = new TestData();
		
		Set<String> actualItems = homepage.verifyNavigationSubMenu();
	    Set<String> expectedItems = data.getExpectedFashionMenuItems();

	    assertEquals(actualItems, expectedItems, "Fashion SubNavigation Menu Items are mismatching");
	    logger.info("Valid Sub Menu Items are displayed in Fashion dropdown");
	    extentTest.pass("Valid Sub Menu Items are displayed in Fashion dropdown");
	}
}
