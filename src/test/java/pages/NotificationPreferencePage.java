package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NotificationPreferencePage {

	WebDriver driver;

	// constructor
	public NotificationPreferencePage(WebDriver driver) {
		//this.driver = Base.getDriver();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = "//*[text()='Notification Preferences']")
	WebElement notificationPreferenceTitle;

	// Action methods
	public String getNotificationPageTitle() {
		return notificationPreferenceTitle.getText();
	}
}
