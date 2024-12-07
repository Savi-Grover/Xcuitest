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

public class ApplicationPage extends BaseClass{
	public AppiumDriver driver;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public ApplicationPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Driver’s License Number\"]")
    public WebElement text_LicensePlate;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Birth Day\"]")
	public WebElement text_day;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Birth Month\"]")
	public WebElement text_month;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Birth Year\"]")
	public WebElement text_year;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Home Address\"]")
	public WebElement text_address;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"City\"]")
	public WebElement text_city;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"State\"]")
	public WebElement text_state;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Zip Code\"]")
	public WebElement text_zip;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSwitch[@value=\"0\"]")
	public WebElement checkbox_consent;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
	public WebElement button_submit;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Please do not use special characters ( ), . # /\"]")
	public WebElement address_symbol_error;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Verification\"]")
	public WebElement headertext_ssnpage;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSecureTextField[@name=\"SSN\"]")
	public WebElement text_snn;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	public WebElement button_continue;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"We’re unable to approve your application.\"]")
	public WebElement error_experianFail;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"You need at least 3 characters\"]")
	public WebElement invalid_DL;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Please enter a valid date of birth\"]")
	public WebElement invalid_DOB;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"Invalid characters\"])[1]")
	public WebElement invalid_char1;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"Invalid characters\"])[2]")
	public WebElement invalid_char2;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"You need 5 digits\"]")
	public WebElement invalid_5digits;
	
	@Step("Filling Application page")
	public void fill_application() throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("123");
		text_month.click();
		text_month.sendKeys("11");
		text_day.click();
		text_day.sendKeys("11");
		text_year.click();
		text_year.sendKeys("1921");
		text_address.click();
		text_address.sendKeys("1433 MARCONI RD");
		text_city.click();
		text_city.sendKeys("WALLTOWNSHIP");
		text_state.click();
		text_state.sendKeys("NJ");
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys("77602"+ Keys.ENTER);
		Thread.sleep(7000);
		
		
	}
	
//	@Step("Filling Application page prod")
//	public void fill_application_prod() throws InterruptedException {
//		text_LicensePlate.click();
//		text_LicensePlate.sendKeys("123");
//		text_month.click();
//		text_month.sendKeys("06");
//		text_day.click();
//		text_day.sendKeys("13");
//		text_year.click();
//		text_year.sendKeys("1993");
//		text_address.click();
//		text_address.sendKeys("16 hyacinth dr");
//		text_city.click();
//		text_city.sendKeys("fords");
//		text_state.click();
//		text_state.sendKeys("NJ");
//		checkbox_consent.click();
//		text_zip.click();
//		text_zip.sendKeys("77602"+ Keys.ENTER);
//		Thread.sleep(7000);
//		
//		
//	}
	
	@Step("Filling Application page- custom address")
	public void fill_application_custom(String addr1, String city, String state, String zipc) throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("123");
		text_month.click();
		text_month.sendKeys("11");
		text_day.click();
		text_day.sendKeys("11");
		text_year.click();
		text_year.sendKeys("1975");
		text_address.click();
		text_address.sendKeys(addr1);
		text_city.click();
		text_city.sendKeys(city);
		text_state.click();
		text_state.sendKeys(state);
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys(zipc+ Keys.ENTER);
		Thread.sleep(7000);
		
		
	}
	//not using anywhere
	public void fill_application_dont_submit() throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("123");
		text_month.click();
		text_month.sendKeys("11");
		text_day.click();
		text_day.sendKeys("11");
		text_year.click();
		text_year.sendKeys("1988");
		text_address.click();
		text_address.sendKeys("1433 MARCONI RD");
		text_city.click();
		text_city.sendKeys("WALLTOWNSHIP");
		text_state.click();
		text_state.sendKeys("NJ");
		//checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys("77602");
		Thread.sleep(7000);
		
		
	}
	@Step("Fill application for experian fail user")
	public void fill_application_ExperianFail() throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("123");
		text_month.click();
		text_month.sendKeys("11");
		text_day.click();
		text_day.sendKeys("11");
		text_year.click();
		text_year.sendKeys("1988");
		text_address.click();
		text_address.sendKeys("1433 CLOONEY ST");
		text_city.click();
		text_city.sendKeys("JERSEY CITY");
		text_state.click();
		text_state.sendKeys("NJ");
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys("77602"+ Keys.ENTER);
		Thread.sleep(7000);
		
		
	}
	
	@Step("Fill application for experian special user")
	public void fill_application_Experianspecial(String month, String day, String year, String addr1,
			String city, String st, String zip, String ssn, String cond) throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("ABCD123456789");
		text_month.click();
		text_month.sendKeys(month);
		text_day.click();
		text_day.sendKeys(day);
		text_year.click();
		text_year.sendKeys(year);
		text_address.click();
		text_address.sendKeys(addr1);
		text_city.click();
		text_city.sendKeys(city);
		text_state.click();
		text_state.sendKeys(st);
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys(zip+ Keys.ENTER);
		Thread.sleep(7000);
		
		try{
			if(headertext_ssnpage.isDisplayed()) {
				text_snn.click();
				text_snn.sendKeys(ssn+ Keys.ENTER);
				Thread.sleep(6000);
				//button_continue.click();
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			//System.out.println("no ssn field needed");
		}
		
		System.out.println("Rule of this testcase...." +cond);
		Assert.assertTrue(true, "Rule of this testcase.... " +cond);
		
	}
	
	@Step("Fill application for users in excel")
	public void fill_application_Experianspecial1(String month, String day, String year, String addr1,
			String city, String st, String zip, String ssn) throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("123");
		text_month.click();
		text_month.sendKeys(month);
		text_day.click();
		text_day.sendKeys(day);
		text_year.click();
		text_year.sendKeys(year);
		text_address.click();
		text_address.sendKeys(addr1);
		text_city.click();
		text_city.sendKeys(city);
		text_state.click();
		text_state.sendKeys(st);
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys(zip+ Keys.ENTER);
		Thread.sleep(7000);
		
		try{
			if(headertext_ssnpage.isDisplayed()) {
				text_snn.click();
				text_snn.sendKeys(ssn);
				Thread.sleep(6000);
				button_continue.click();
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			//System.out.println("no ssn field needed");
		}
		
		//System.out.println("Rule of this testcase...." +cond);
		//Assert.assertTrue(true, "Rule of this testcase.... " +cond);
		
	}
	@Step("Application page filled with invalid data")
	public void invalid_application() throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("A");
		text_month.click();
		text_month.sendKeys("a");
		text_day.click();
		text_day.sendKeys("b");
		text_year.click();
		text_year.sendKeys("1800");
		text_address.click();
		text_address.sendKeys("1433 MARCONI RD, 12D");
		text_city.click();
		text_city.sendKeys("111");
		text_state.click();
		text_state.sendKeys("11");
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys("avc"+ Keys.ENTER);
		Thread.sleep(7000);
		Thread.sleep(7000);
	}
	
	@Step("verify Driver License validation message")
	public void verify_DL() throws InterruptedException {
		boolean text=invalid_DL.isDisplayed();
		AssertJUnit.assertTrue(text);
		text_LicensePlate.sendKeys("a" +Keys.ARROW_DOWN);
	}
	
	@Step("verify DOB validation message")
	public void verify_DOB() throws InterruptedException {
		boolean text=invalid_DOB.isDisplayed();
		AssertJUnit.assertTrue(text);
		text_month.sendKeys("a" +Keys.ARROW_DOWN);
        text_day.sendKeys("a" +Keys.ARROW_DOWN);
		text_year.sendKeys("a" +Keys.ARROW_DOWN);
	}
	
	@Step("verify address validation message for special char")
	public void verify_addressSymbol() throws InterruptedException {
		boolean text=address_symbol_error.isDisplayed();
		AssertJUnit.assertTrue(text);
		//scroll bar 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, String> scrollObject = new HashMap();
//		scrollObject.put("direction", "up");
//		js.executeScript("mobile: swipe", scrollObject);


		text_address.sendKeys("a" +Keys.ARROW_DOWN);
	}
	
	@Step("verify city validation message")
	public void verify_city() throws InterruptedException {
		boolean text=invalid_char1.isDisplayed();
		AssertJUnit.assertTrue(text);
	}
	
	@Step("verify state validation message")
	public void verify_state() throws InterruptedException {
		boolean text=invalid_char2.isDisplayed();
		AssertJUnit.assertTrue(text);
	}
	
	@Step("verify zipcode validation message")
	public void verify_zip() throws InterruptedException {
		boolean text=invalid_5digits.isDisplayed();
		AssertJUnit.assertTrue(text);
	}
	@Step("Fill application for low credit score user")
	public void fill_application_LowScore() throws InterruptedException {
		text_LicensePlate.click();
		text_LicensePlate.sendKeys("123");
		text_month.click();
		text_month.sendKeys("11");
		text_day.click();
		text_day.sendKeys("11");
		text_year.click();
		text_year.sendKeys("1988");
		text_address.click();
		text_address.sendKeys("3413 LINE AVE");
		text_city.click();
		text_city.sendKeys("AMARILLO");
		text_state.click();
		text_state.sendKeys("TX");
		checkbox_consent.click();
		text_zip.click();
		text_zip.sendKeys("79106"+ Keys.ENTER);
		Thread.sleep(7000);
		
		
	}
	
	@Step("check experian failure")
	public void chec_experian() throws InterruptedException {
		boolean sts=error_experianFail.isDisplayed();
		if(sts) {
		Assert.assertTrue(sts, "We’re unable to approve your application.");
		}
		
		else {
		Assert.assertTrue(false,"low credit score test verification - failed");
		}
	}
	
	@Step("check SSN page")
	public void SSn_page() throws InterruptedException {
		boolean sts=headertext_ssnpage.isDisplayed();
		if(sts) {
		Assert.assertTrue(sts, "SSN page verified reached profile not accessible");
		}
		
		else {
		Assert.assertTrue(false,"SSN page verification when profile not accessible - failed");
		}
	}
	
	@Step("check SSN field")
	public void SSn_page_field() throws InterruptedException {
		boolean sts1=headertext_ssnpage.isDisplayed();
		if(sts1) {
		Assert.assertTrue(sts1, "SSN page verified reached profile not accessible");
		}
		
		else {
		Assert.assertTrue(false,"SSN page verification when profile not accessible - failed");
		}
	}
	
	@Step("check SSN submit button disabled when ssn not entered")
	public void check_continu_disable() throws InterruptedException {
		boolean sts1=button_continue.isEnabled();
		if(sts1) {
		Assert.assertTrue(false, "Continue button enabled before entering text - failed");
		}
		
		else {
		Assert.assertTrue(true,"Continue button disabled before entering text - verified");
		}
	}

	@Step("enter wrong SSN")
	public void wrong_ssn_submit() throws InterruptedException {
		text_snn.click();
		text_snn.sendKeys("123123123");
		Thread.sleep(3000);
	}
	
	@Step("enter SSN custom")
	public void enter_ssn_submit_custom(String ssn) throws InterruptedException {
		try {
		if (headertext_ssnpage.isDisplayed()) {
		text_snn.click();
		text_snn.sendKeys(ssn);
		Thread.sleep(6000);
		button_continue.click();
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Step("check experian failure after wrong ssn")
	public void chec_experian1() throws InterruptedException {
		boolean sts=error_experianFail.isDisplayed();
		if(sts) {
		Assert.assertTrue(sts, "Error Page received when Experian failed- verified");
		}
		
		else {
		Assert.assertTrue(false,"Error Page not received when Experian failed- not verified");
		}
	}
}
