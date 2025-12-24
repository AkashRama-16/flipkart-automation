package tests;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.testng.annotations.Test;

import base.Base;
import pages.CustomerCarePage;
import pages.HomePage;
import utils.LoggerHelper;

public class customerCarePageTest extends Base {
	private static final Logger logger = LoggerHelper.getLogger(NotificationPageTest.class);

	@Test(testName = "Customer Care Page Title Test")
	public void customerCarePageTitleTest() {
		HomePage homePage = new HomePage(driver);
		homePage.navigateToCustomerSupportPage();
		extentTest.info("Navigated to Customer Support page");
		CustomerCarePage cutomerCarePage = new CustomerCarePage(driver);
		assertEquals(cutomerCarePage.getcustomerCarePageTitle(), "Flipkart Help Center | 24x7 Customer Care Support",
				"Customer care page title mismatch");
		logger.info("Customer care page title is displayed");
		extentTest.pass("Customer care page title is displayed");
	}
}