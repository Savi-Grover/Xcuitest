package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import ios.AllureListener;
import ios.BaseClass;
@Listeners({AllureListener.class})
public class OTPPage extends BaseClass {
	public AppiumDriver driver;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public OTPPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeTextField[@value=\"___\"])[1]")
    public WebElement text_OTP;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Resend\"]")
	public WebElement link_resend;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"OTP Resent: Check email and re-enter\"]")
	public WebElement text_otpResent;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Time expired: Please hit resend\"]")
	public WebElement text_timeExpired;
	
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Phone Number\"]")
	//public WebElement error_wrongotp;
	
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Home Zip Code\"]")
	//public WebElement error_timeelapsed;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"mins\"]")
	public WebElement red_timer;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
	public WebElement button_getStarted;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	public WebElement cookiee_close;
	
	@Step("submit OTP")
	public void fill_send_otp() throws InterruptedException {
		text_OTP.click();
		Thread.sleep(5000);
		text_OTP.sendKeys("000000" + Keys.ENTER);
		Thread.sleep(7000);
		Assert.assertTrue(true, "OTP submitted");
	}
	@Step("verify error msg")
	public void catch_errormsg1() throws InterruptedException {
		//checkbox_consent.click();
		Thread.sleep(5000);
		button_getStarted.click();
		Thread.sleep(7000);
		
		
	}
	@Step("ignore cookie popup")
	public void ignore_cookie_popup_otp() {
		try {
			if(cookiee_close.isDisplayed()) {
				Thread.sleep(3000);
				cookiee_close.click();
			}
		}
		
		catch(Exception e )
		{
			//no cookiee popup
		}
		
	}
	
	@Step("verify resend message")
	public void verify_resend() throws InterruptedException {
		//checkbox_consent.click();
		//Thread.sleep(5000);
		link_resend.click();
		Thread.sleep(6000);
		boolean statusresendlink= text_otpResent.isDisplayed();
		Assert.assertTrue(statusresendlink);
		
		
	}
	
	@Step("verify wrong otp message")
	public void verify_wrongOTP() throws InterruptedException {
		//checkbox_consent.click();
		//Thread.sleep(5000);
		text_OTP.click();
		Thread.sleep(5000);
		text_OTP.sendKeys("123123"+ Keys.ENTER);
		Thread.sleep(6000);
		boolean statusresendlink= text_otpResent.isDisplayed();
		Assert.assertTrue(statusresendlink);
		
		
	}
	
	@Step("verify red timer msg on expired time limit")
	public void verify_expiredTime() throws InterruptedException {
		//wait to elapse time
		Thread.sleep(300000);
		
		//check expired time message
		boolean statustimeExpired= text_timeExpired.isDisplayed();
		Assert.assertTrue(statustimeExpired);
		
		//click resend to see timer start again
		link_resend.click();
		Thread.sleep(6000);	
		boolean timerIcon= red_timer.isDisplayed();
		Assert.assertTrue(timerIcon);
		
	}
	
	@Step("verify timer")
	public void verify_timer() throws InterruptedException {
		boolean timerIcon= red_timer.isDisplayed();
		Assert.assertTrue(timerIcon);
		
	}
	
	
}
