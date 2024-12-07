package pages;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import ios.AllureListener;
import ios.BaseClass;

public class PartialSignupPage extends BaseClass{
	public AppiumDriver driver;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public PartialSignupPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Legal First Name\"]")
    public WebElement text_FirstName;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Legal Last Name\"]")
	public WebElement text_LastName;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Email\"]")
	public WebElement text_Email;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Phone Number\"]")
	public WebElement text_phoneNo;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Home Zip Code\"]")
	public WebElement text_HomeZipCode;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSwitch[@value=\"0\"]")
	public WebElement checkbox_consent;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
	public WebElement button_getStarted;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Sign In\"]")
	public WebElement link_signIn;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Info Icon\"]")
	public WebElement icon_toolTip;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"This should be your home zip code where you intend to park your vehicle.\"]")
	public WebElement msg_toolTip;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	public WebElement cookie_check;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Enter a valid Legal First Name\"]")
	public WebElement invalidFN;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Enter a valid Legal Last Name\"]")
	public WebElement invalidLN;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Please enter an email address in the correct format\"]")
	public WebElement invalidEmail;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Please enter a phone number in the correct format\"]")
	public WebElement invalidPhoneNo;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Provided Zip Code must be 5 digits\"]")
	public WebElement invalidzipode;
	
	@Step("Login into Ford Drive")
	public void Login() throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys("DAVID");
		text_LastName.click();
		text_LastName.sendKeys("LANGE");
		text_Email.click();
		String emailvar = createEmail() + "@yopmail.com";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("1231231231");
			
	}
	
	@Step("captured error message for firstname")
	public void capture_validations_fn() {
		boolean text1=invalidFN.isDisplayed();
		AssertJUnit.assertTrue(text1);
		//text_FirstName.sendKeys("a"+Keys.CANCEL);
	}
	
	@Step("captured error message for lastname")
	public void capture_validations_ln() {
		boolean text1=invalidLN.isDisplayed();
		AssertJUnit.assertTrue(text1);
		text_FirstName.sendKeys(Keys.ARROW_DOWN);
		
	}
	@Step("captured error message for email")
	public void capture_validations_email() {
		boolean text1=invalidEmail.isDisplayed();
		AssertJUnit.assertTrue(text1);
		text_LastName.sendKeys(Keys.DOWN);
	}
	
	@Step("captured error message for phone")
	public void capture_validations_phone() {
		//text_FirstName.sendKeys(Keys.DOWN);
		boolean text1=invalidPhoneNo.isDisplayed();
		AssertJUnit.assertTrue(text1);
		text_Email.sendKeys(Keys.DOWN);
	}
	
	@Step("captured error message for zip")
	public void capture_validations_zip() {
		//text_FirstName.sendKeys(Keys.DOWN);
		boolean text1=invalidzipode.isDisplayed();
		AssertJUnit.assertTrue(text1);
	} 
	@Step("Fill Partial Signup")
	public void fill_signup1() throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys("DAVID");
		text_LastName.click();
		text_LastName.sendKeys("LANGE");
		text_Email.click();
		String emailvar = createEmail() + "@yopmail.com";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("1231231231");
			
	}
	
//	@Step("Fill prod Partial Signup")
//	public void fill_signup1_prod() throws InterruptedException {
//		text_FirstName.click();
//		text_FirstName.sendKeys("Savi");
//		text_LastName.click();
//		text_LastName.sendKeys("Grover");
//		text_Email.click();
//		String emailvar = createEmail() + "@yopmail.com";
//		text_Email.sendKeys(emailvar);
//		System.out.println(emailvar);
//		Thread.sleep(5000);
//		text_phoneNo.click();
//		text_phoneNo.sendKeys("1231231231");
//			
//	}
	
	@Step("Fill Partial Signup custom Names")
	public void fill_signup_custom(String fn, String ln) throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys(fn);
		text_LastName.click();
		text_LastName.sendKeys(ln);
		text_Email.click();
		String emailvar = createEmail() + "@yopmail.com";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("1231231231");
			
	}
	
	@Step("Fill Partial Signup")
	public void fill_signup2() throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys("DAVID");
		text_LastName.click();
		text_LastName.sendKeys("LANGE");
		text_Email.click();
		String emailvar = createEmailLower() + "@yopmail.com";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("1231231231");
			
	}
	
	@Step("Fill Partial Signup- for experian special user")
	public void fill_signup_experian_special(String fn, String ln) throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys(fn);
		text_LastName.click();
		text_LastName.sendKeys(ln);
		text_Email.click();
		String emailvar = createEmailLower() + "@yopmail.com";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("1231231231");
			
	}
	
	@Step("Fill Partial Signup with invalid data")
	public void fill_signup1_invalid() throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys("2");
		text_LastName.click();
		text_LastName.sendKeys("122");
		text_Email.click();
		//String emailvar = createEmail() + "@yopmail.com";
		String emailvar= "123@yopmail";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("abc");
		text_HomeZipCode.click();
		text_HomeZipCode.sendKeys("Abc");
		checkbox_consent.click();
		button_getStarted.click();
		Thread.sleep(6000);
		text_FirstName.click();
		
			
	}
	
	@Step("Capturing all validation messages")
	public void Capture_validations() throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys("2");
		text_LastName.click();
		text_LastName.sendKeys("122");
		text_Email.click();
		//String emailvar = createEmail() + "@yopmail.com";
		String emailvar= "123@yopmail";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("abc");
		text_HomeZipCode.click();
		text_HomeZipCode.sendKeys("Abc");
		checkbox_consent.click();
		button_getStarted.click();
			
	}
	
	
	@Step("ignore cookie popup ")
	public void ignore_cookie_popup() {
		try {
			if(cookie_check.isDisplayed()) {
				Thread.sleep(3000);
				cookie_check.click();
			}
		}
		catch(Exception e )
		{
			//no code
		}
		
	}
	
	@Step("Fill Partial Signup for a low credit score user")
	public void fill_lowScoreSignup() throws InterruptedException {
		text_FirstName.click();
		text_FirstName.sendKeys("RAMONA");
		text_LastName.click();
		text_LastName.sendKeys("BUSBY");
		text_Email.click();
		String emailvar = createEmail() + "@yopmail.com";
		text_Email.sendKeys(emailvar);
		System.out.println(emailvar);
		Thread.sleep(5000);
		text_phoneNo.click();
		text_phoneNo.sendKeys("1231231231");
		}
	
	@Step("Submit Partial SIgnup")
	public void submit_signup1() throws InterruptedException {
		checkbox_consent.click();
		Thread.sleep(5000);
		button_getStarted.click();
		Thread.sleep(7000);
			
	}

	@Step("Generated email yopmail")
	private static String createEmail() {
		// TODO Auto-generated method stub
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
	
	@Step("Generated email yopmail lowercase")
	private static String createEmailLower() {
		// TODO Auto-generated method stub
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
	@Step("Verify zipcode tooltip")
	public void tooltip_verify() {
		icon_toolTip.click();
		boolean msg=icon_toolTip.isDisplayed();
		Assert.assertTrue(msg);
		//scroll bar 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap();
		scrollObject.put("direction", "up");
		js.executeScript("mobile: swipe", scrollObject); 
		
	}
	
	@Step("Verify get started button disabled without filling partial signup data")
	public void Verify_button_disabled() {
		boolean buttonStatus=button_getStarted.isEnabled();
		Assert.assertFalse(buttonStatus, "Get Started Button is disabled without data");
		
	}
	
}
