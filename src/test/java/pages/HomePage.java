package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import appiumproject.BaseTest;
import appiumproject.config;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseTest{
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(config.driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Login\"]")
	private WebElement loginHomeButton;
	public HomePage clickLoginHomeButton() {
		click(loginHomeButton);
		return this;
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
	private WebElement emailField;
	public HomePage enterEmail() {
		sendKeys(emailField,"adnantesting@mailinator.com");
		return this;
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
	private WebElement passwordField;
	public HomePage enterPassword() {
		sendKeys(passwordField,"Test123.");
		return this;
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")
	private WebElement loginButton;
	public HomePage clickLoginButton() {
		click(loginButton);
		return this;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")
	private WebElement successMessage;
	public void verifySuccessMessage() {
		waitForVisibilityOfElement(successMessage);
		String successTitle = successMessage.getText();
		System.out.println("Alert Title: " + successTitle);
		Assert.assertEquals(successTitle, "Success", "The alert title text does not match!");
	}
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"android:id/message\"]")
	private WebElement alertMessage;
	public void verifyalertMessage() {
		waitForVisibilityOfElement(alertMessage);
		String alertTitle = alertMessage.getText();
		System.out.println("Alert Title: " + alertTitle);
		Assert.assertEquals(alertTitle, "You are logged in!", "The alert title text does not match!");
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement okButton;
	public HomePage clickOkButton() {
		click(okButton);
		return this;
	}
}
