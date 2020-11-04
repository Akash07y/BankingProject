package pom_pacakge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteZerodhaLoginPage {

	@FindBy(xpath = "//input[@id='userid']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='pin']")
	WebElement pin;
	
	@FindBy(xpath = "//button[text()='Login ']")
	WebElement loginButton;
	
	@FindBy(xpath = "//button[text()='Continue ']")
	WebElement continueButton;
	
	public KiteZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	public void sendKiteLoginPageUsername(String username) {
		userName.sendKeys(username);
	}
	
	public void sendKiteLoginPagePassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void clickKiteLoginPageLogin() {
		loginButton.click();
	}
	
	public void sendKiteLoginPagePin(String userPin) {
		pin.sendKeys(userPin);
	}
	
	public void clickKiteLoginPageContinue() {
		continueButton.click();
	}
	
}
