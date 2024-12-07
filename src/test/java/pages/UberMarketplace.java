package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class UberMarketplace {
	public AppiumDriver driver = null;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public UberMarketplace(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Login with Uber\"]")
    public WebElement Button_LoginWithUber;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Allow\"]")
	public WebElement Button_uberAllow;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Person\"]")
	public WebElement icon_Person;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Enter phone number or email\"]")
	public WebElement text_uberEmail;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	public WebElement button_continueEmail;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSecureTextField[@name=\"Enter your password\"]")
	public WebElement text_uberPassword;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Ford Mustang Mach-E\"]")
	public WebElement icon_forddrivetile;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Login with password\"]")
	public WebElement button_loginWithPasswd;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
	public WebElement button_uberGetStarted;
	
	
	@Step("Click on person ico to uber login")
	public void uber_right_corner() throws InterruptedException {
		icon_Person.click();
		Thread.sleep(10000);
		
		try {
			boolean uber= text_uberEmail.isDisplayed();
			if(uber) {
				text_uberEmail.click();
			}
		}
		
		catch(Exception e ) {
			icon_Person.click();
			Thread.sleep(10000);
		}
	}
	
	@Step("Clicking on Allow popup uber")
	public void allow_uber_popup() throws InterruptedException {
	try {
	boolean buttonAllow=Button_uberAllow.isDisplayed();
	if(buttonAllow) {
		Button_uberAllow.click();
		Thread.sleep(4000);
	               }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
 
	@Step("Handle uber login with OTP or login with password")
	public void handle_password() throws InterruptedException {
		try {
			button_loginWithPasswd.click();
			Thread.sleep(3000);
			text_uberPassword.click();
			text_uberPassword.sendKeys("password123!@#"+Keys.ENTER);
			Thread.sleep(5000);
		}
		
		catch(Exception e) {
			// TODO: handle exception
			text_uberPassword.click();
			text_uberPassword.sendKeys("password123!@#"+Keys.ENTER);
			Thread.sleep(5000);
		}
	}
	
	
	

}
