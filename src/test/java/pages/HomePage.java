package pages;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// constructor
	public HomePage(WebDriver driver) {
		// this.driver = Base.getDriver();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement flipkartLogo;

	@FindBy(xpath = "//input[contains(@title,'Search for Products')]")
	WebElement searchboxField;

	@FindBy(xpath = "//a[@title='Dropdown with more help links']")
	WebElement dropdownHelpLinks;

	@FindBy(xpath = "//li[text()='Notification Preferences']")
	WebElement notificationPrefencesbutton;

	@FindBy(xpath = "//*[contains(text(),'Fashion')]")
	WebElement FashionDropdown;

	String navigationSubmenu = "//div[@class='jqs3Ji']/object/a";
	
	@FindBy(xpath="//a[@title='24x7 Customer Care']")
	WebElement customerCarebutton;

	// Action methods
	public Boolean getFlipkartLogoStatus() {
		return flipkartLogo.isDisplayed();

	}

	public String getSearchBoxText() {
		return searchboxField.getAttribute("placeholder");
	}

	public void navigateToNotificationPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdownHelpLinks).moveToElement(notificationPrefencesbutton).click().perform();
	}

	public Set<String> verifyNavigationSubMenu() {
		Actions actions = new Actions(driver);
		actions.moveToElement(FashionDropdown).perform();
		List<WebElement> subMenuItems = driver.findElements(By.xpath(navigationSubmenu));

		Set<String> actualMenuItems = new LinkedHashSet<>();
		for (WebElement item : subMenuItems) {
			actualMenuItems.add(item.getText().trim());
		}

		return actualMenuItems;
	}
	
	public void navigateToCustomerSupportPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdownHelpLinks).moveToElement(customerCarebutton).click().perform();
	}
}
