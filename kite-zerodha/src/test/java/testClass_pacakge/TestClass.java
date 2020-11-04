package testClass_pacakge;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom_pacakge.KiteZerodhaHomePage;
import pom_pacakge.KiteZerodhaLoginPage;
import pom_pacakge.KiteZerodhaLogoutPage;
import testBrowserSetup.Pojo;
import utilities.Utilty;

public class TestClass extends Pojo{
	WebDriver driver;
	KiteZerodhaLoginPage kiteZerodhaLoginPage;
	KiteZerodhaHomePage kiteZerodhaHomePage;
	KiteZerodhaLogoutPage kiteZerodhaLogoutPage;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createObject() {
		System.out.println("Before Class");
		kiteZerodhaLoginPage = new KiteZerodhaLoginPage(driver);
		kiteZerodhaHomePage = new KiteZerodhaHomePage(driver);
		kiteZerodhaLogoutPage = new KiteZerodhaLogoutPage(driver);
	}
	
	@BeforeMethod
	public void loginToUserAccount() {
		System.out.println("Before Method");
		driver.get("https://kite.zerodha.com/");
		kiteZerodhaLoginPage.sendKiteLoginPageUsername("DV1510");
		kiteZerodhaLoginPage.sendKiteLoginPagePassword("Vijay@123");
		kiteZerodhaLoginPage.clickKiteLoginPageLogin();
		kiteZerodhaLoginPage.sendKiteLoginPagePin("959594");
		kiteZerodhaLoginPage.clickKiteLoginPageContinue();
	}
	
	@Test
	public void verifydashboard() {
		testID = 100;
		System.out.println("Test");
		String link = kiteZerodhaHomePage.verifyKiteHomePageDashboardlink();
		if(link.equals("https://kite.zerodha.com/dashboard"))
		{
			System.out.println("Dashboard link is "+link);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@Test
	public void verifyorder() {
		testID = 200;
		System.out.println("Test");
		String link = kiteZerodhaHomePage.verifyKiteHomePageOrderslink();
		if(link.equals("https://kite.zerodha.com/orders"))
		{
			System.out.println("Dashboard link is "+link);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@AfterMethod
	public void logoutAccount(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utilty.takeScreenshot(driver, testID);
		}
		Thread.sleep(10000);
		System.out.println("After Method");
		kiteZerodhaHomePage.clickOnKiteHomePageLogout();
		kiteZerodhaLogoutPage.clickKiteChangeUser();
	}
	
	@AfterClass
	public void clearObjects() {
		System.out.println("After Class");
		kiteZerodhaHomePage = null;
		kiteZerodhaLoginPage = null;
		kiteZerodhaLogoutPage = null;
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver = null;
		System.gc();
	}
}
