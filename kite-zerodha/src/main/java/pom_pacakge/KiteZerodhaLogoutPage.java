package pom_pacakge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteZerodhaLogoutPage {
	
	@FindBy(xpath="//a[text()='Change user']")
	WebElement chnageUser;
	
	public KiteZerodhaLogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickKiteChangeUser() {
		chnageUser.click();
	}
}
