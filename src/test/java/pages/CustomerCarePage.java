package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerCarePage{
	WebDriver driver;
	
	public CustomerCarePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// locators
	@FindBy(xpath = "//*[text()='Flipkart Help Center | 24x7 Customer Care Support']")
	WebElement customerCarePageTitle;

	// Action methods
	public String getcustomerCarePageTitle() {
		return customerCarePageTitle.getText();
	}
}