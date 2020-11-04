package pom_pacakge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KiteZerodhaHomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath = "//span[text()='Orders']")
	WebElement orders;
	
	@FindBy(xpath = "//span[text()='Holdings']")
	WebElement holdings;
	
	@FindBy(xpath = "//span[text()='Positions']")
	WebElement positions;

	@FindBy(xpath = "//span[text()='Funds']")
	WebElement funds;
	
	@FindBy(xpath = "//span[text()='Apps']")
	WebElement apps;
	
	@FindBy(xpath = "//span[text()='DV1510']")
	WebElement account;
	
	@FindBy(xpath = "//div[@class='dropdown-nav layer-2']//li[10]//a[text()=' Logout']")
	WebElement logout;
	
	String a = "//div//div[@class='dropdown-nav layer-2']//ul//li[10]//a";
	
	public KiteZerodhaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public String verifyKiteHomePageOrderslink() {
		orders.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyKiteHomePagePositionslink() {
		positions.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyKiteHomePageHoldingslink() {
		holdings.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyKiteHomePageFundslink() {
		funds.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyKiteHomePageAppslink() {
		apps.click();
		return driver.getCurrentUrl();
	}
	
	public void clickOnKiteHomePageLogout() throws InterruptedException{
		account.click();
		Thread.sleep(2000);
		By ele = By.xpath("//a[text()=' Logout']/span");
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		logoutButton.click();		
	}

	public String verifyKiteHomePageDashboardlink() {
		dashboard.click();
		return driver.getCurrentUrl();
		
	}


}
