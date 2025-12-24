package tests;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.NotificationPreferencePage;
import utils.LoggerHelper;

public class NotificationPageTest extends Base {
	private static final Logger logger = LoggerHelper.getLogger(NotificationPageTest.class);

	@Test(testName = "Notification preference navigation page test")
	public void testPageTitle() {
		HomePage homepage = new HomePage(driver);
		homepage.navigateToNotificationPage();
		extentTest.info("User navigated to Notification page");
		NotificationPreferencePage notificationpage = new NotificationPreferencePage(driver);
		assertEquals(notificationpage.getNotificationPageTitle(), "NOTIFICATION PREFERENCES",
				"Notification page title mismatch");
		logger.info("Notification page title is displayed");
		extentTest.pass("Notification page title is displayed");
	}
}
