package appiumproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	public DesiredCapabilities caps;
	public static Properties prop;
	
	@BeforeTest
	@Parameters({"platformName","deviceName"})
	public void beforeTest(String platformName, String deviceName) throws InterruptedException, IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		prop.load(fis);
		String AndroidAppAutomationName = prop.getProperty("AndroidAppAutomationName");
		String AndroidAppPackageName = prop.getProperty("AndroidAppPackageName");
		String AndroidAppActivityName = prop.getProperty("AndroidAppActivityName");
		String AndroidAppVersion = prop.getProperty("AndroidAppVersion");
		String AppiumURl = prop.getProperty("AppiumURl");
		
		caps = new DesiredCapabilities();
		caps.setCapability("platformName", platformName);
		caps.setCapability("appium:deviceName", deviceName);
		caps.setCapability("appium:automationName", AndroidAppAutomationName);
		caps.setCapability("appium:platformVersion", AndroidAppVersion);
		caps.setCapability("appium:appPackage", AndroidAppPackageName);
		caps.setCapability("appium:appActivity", AndroidAppActivityName);

		String pathToApplication = System.getProperty("user.dir") + "/src/test/java/android.wdio.native.app.v1.0.8.apk";
		caps.setCapability("appium:app", pathToApplication);
		URL appiumServerUrl = URI.create(AppiumURl).toURL();
		config.driver = new AndroidDriver(appiumServerUrl, caps);
	}
	
	public void waitForVisibilityOfElement(WebElement element) {
		WebDriverWait wait= new WebDriverWait(config.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void click(WebElement element) {
		waitForVisibilityOfElement(element);
		element.click();
		
	}
	
	public void sendKeys(WebElement element, String txt) {
		waitForVisibilityOfElement(element);
		element.sendKeys(txt);
		
	}
	
	@AfterTest
	public void afterTest() {
		if (config.driver != null) {
			config.driver.quit();
		}
	}

}
