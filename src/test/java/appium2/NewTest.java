package appium2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appiumproject.BaseTest;
import pages.HomePage;

public class NewTest extends BaseTest{
	HomePage homepage;
	
	@BeforeMethod
	public void BeforeMethod() {
		homepage = new HomePage();
		
	}
	@Test
	public void testLogin() throws InterruptedException {
		homepage.clickLoginHomeButton();
		homepage.enterEmail();
		homepage.enterPassword();
		homepage.clickLoginButton();
		homepage.verifySuccessMessage();
		homepage.verifyalertMessage();
		Thread.sleep(3000);
		System.out.println("Test Completed");
	}

	
}
