package appium2;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

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
		// uptown app
		//caps.setCapability("appium:appPackage", "com.uptodown");
		//caps.setCapability("appium:appActivity", "com.uptodown.activities.MainActivity");
		//String pathToApplication = System.getProperty("user.dir") + "/src/test/java/uptodown-app-store-6-46.apk";
		
		// webdriver app
		caps.setCapability("appium:appPackage", "com.wdiodemoapp");
		caps.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
		String pathToApplication = System.getProperty("user.dir") + "/src/test/java/android.wdio.native.app.v1.0.8.apk";
		
		caps.setCapability("appium:app", pathToApplication);

		// Use URI to create a URL instance
		URL appiumServerUrl = URI.create("http://localhost:4723/wd/hub").toURL();
		driver = new AndroidDriver(appiumServerUrl, caps);

		Thread.sleep(5000);

		// Interact with the app
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]"))
				.sendKeys("adnantesting@mailinator.com");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]"))
				.sendKeys("Test123.");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup"))
				.click();

		// Verify success messages
		String alertTitle = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).getText();
		System.out.println("Alert Title: " + alertTitle);

		String successMessage = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		System.out.println("Success Message: " + successMessage);

		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		Thread.sleep(5000); // Wait before closing
		System.out.println("Test Completed");

	}

	@Test
	public void f() {
		System.out.println("Test executed successfully.");
	}

	@AfterTest
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}
}
