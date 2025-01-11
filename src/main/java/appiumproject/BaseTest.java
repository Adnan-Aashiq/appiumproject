package appiumproject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	public DesiredCapabilities caps;
	
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
		config.driver = new AndroidDriver(appiumServerUrl, caps);
		config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
