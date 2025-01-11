package appium2;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class NewTest {
	public DesiredCapabilities caps;
	public AppiumDriver driver = null;

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:deviceName", "emulator-5554");
		caps.setCapability("appium:automationName", "UIAutomator2");
		caps.setCapability("appium:platformVersion", "15.0");
		caps.setCapability("appium:appPackage", "com.wdiodemoapp");
		caps.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");

		String pathToApplication = System.getProperty("user.dir") + "/src/test/java/android.wdio.native.app.v1.0.8.apk";
		caps.setCapability("appium:app", pathToApplication);
		URL appiumServerUrl = URI.create("http://localhost:4723/wd/hub").toURL();
		driver = new AndroidDriver(appiumServerUrl, caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testLogin() throws InterruptedException {
		Thread.sleep(5000);

		// Interact with the app
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]"))
				.sendKeys("adnantesting@mailinator.com");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]"))
				.sendKeys("Test123.");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")).click();

		// Wait for the alert title to appear
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
		WebElement alertTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")));

		// Get the text and assert
		String successTitle = alertTitleElement.getText();
		System.out.println("Alert Title: " + successTitle);
		Assert.assertEquals(successTitle, "Success", "The alert title text does not match!");

		
		// Verify success messages
		String alertTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		Assert.assertEquals(alertTitle, "You are logged in!", "The alert title text does not match!");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		Thread.sleep(3000);
		System.out.println("Test Completed");
	}

	@AfterTest
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}
}
