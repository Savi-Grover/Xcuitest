package ios;
//##password page  validations
//Verify Submit button is disabled when fields are not filled completely (Credit card fields).
//Verify Validations messages on Create password section - Password and confirm password text fields 
//--(Not providing one lower and upper case, Without number and special characters and less than 6 characters...)
//Verify Driver fails to create the password without mentioned conditions
//To verify "Create Password" button is disabled when password not created
//Back button on Pricing tier page should navigate to OTP page. ( All locations )
//Verify pricing tier list should be displayed as per the location (SD, BA, LA)
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.appmanagement.BaseOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.options.wda.SupportsAutoAcceptAlertsOption;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ApplicationPage;
import pages.CreditCardPage;
import pages.DashboardPage;
import pages.OTPPage;
import pages.PackagesPage;
import pages.PartialSignupPage;


public class PricingTierPageValidations extends BaseClass {
	static AppiumDriver driver;
	
	@Description("IOS Setup")
	@BeforeTest
	@SuppressWarnings({ "deprecation", "unused", "unused", "unused", "unused" })
	
	  public AppiumDriver setup() throws MalformedURLException{

		 BaseClass bs=new BaseClass();
		 driver=bs.initialize_driver();
		 return driver;
	}
	 
	//initialise null objects for pages files
	PartialSignupPage PartialSignupPg;
	OTPPage otppg;
	PackagesPage pkgpg;
	
	@Description("FordDrive packages page verification begin")
	@Epic("Pricing Tier Page")
	@Feature("Feature3: Package page Validations")
	@Severity(SeverityLevel.CRITICAL)
    @Test
	@SuppressWarnings("deprecation")
	public static void PricingTierPageValidations() throws MalformedURLException {

		//import page class and initialse obj of this all page class
		PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);
		OTPPage otppg = new OTPPage(driver);
		PackagesPage pkgpg=new PackagesPage(driver);
				
		// run launch chrome
		try {

			// fill details on Partial signup
			FileInputStream fs = new FileInputStream("/Users/sgrover7/eclipse-workspace/ios/src/test/resources/InputFile/PricingTierPageValidations.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get row count & no of accounts
			int rowNum = sheet.getLastRowNum();
			int numOfAccts = (int) sheet.getRow(1).getCell(4).getNumericCellValue();
			System.out.println("total number of rows is:  " + rowNum);

			// loop begin- parent loop runs for number of rows
			for (int j = 1; j <= rowNum; j++) {

				int noOfsignups = (int) sheet.getRow(j).getCell(4).getNumericCellValue();

				// second loop runs for 1 row of data - for number of account times
				System.out.println("total number of accounts in first row: " + noOfsignups);
				for (int i = 1; i <= noOfsignups; i++) {
					// System.out.println("running iterations for this number of times"
					// +numOfAccts);
					String env = sheet.getRow(j).getCell(0).toString();
					String loc = sheet.getRow(j).getCell(1).toString();
					String zipcode = sheet.getRow(j).getCell(2).toString();
					String tier = sheet.getRow(j).getCell(3).toString();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (env.contains("stage")) {
					
					driver.get("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
					
					} else if (env.contains("preprod")) {
						driver.get("https://preprod.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
						String context=((SupportsContextSwitching) driver).getContext();
						System.out.println(context);
						
					 } else if (env.contains("dev")) {
						driver.get("https://dev.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
						String context=((SupportsContextSwitching) driver).getContext();
						System.out.println(context);
							
					 } else {
						driver.get("https://rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
						String context=((SupportsContextSwitching) driver).getContext();
						System.out.println(context);
						
					}
					
					//if detect cookie settings
					PartialSignupPg.ignore_cookie_popup();
					
					//Partial page enter data
					PartialSignupPg.fill_signup1();
					//fill zipcode based on excel data 
					PartialSignupPg.text_HomeZipCode.click();
					Thread.sleep(5000);		
					if (loc.contains("LA")) {
						PartialSignupPg.text_HomeZipCode.sendKeys("90007");
					
					} // fetch for loc based from sheet
					else if (loc.contains("SD")) {
						PartialSignupPg.text_HomeZipCode.sendKeys("92142");
					} else {
						PartialSignupPg.text_HomeZipCode.sendKeys("95140");
					}
					
					PartialSignupPg.submit_signup1();
					
					// Fetch OTP and paste
					//if detect cookie settings
					otppg.ignore_cookie_popup_otp();
					
					otppg.fill_send_otp();
					
					//check tiers page validations
					//skip tier choose
					
					//car image verifications
					pkgpg.verify_image_Car();
					
					//budle insu link
					pkgpg.verify_insurance_icon();
					
					//texts verify
					pkgpg.verify_text_AwarWinning();
					pkgpg.verify_text_Vehicle_Maintenance();
					pkgpg.verify_text_Ultimate_Flexibility();
					
					//spark icon
					pkgpg.verify_lightning_icon();
					
					//check tier values and miles for each location
					if (loc.contains("SD")) {
						pkgpg.verify_SD();
					} else if (loc.contains("SF")) {
						pkgpg.verify_SF();
					}

					else {
						pkgpg.verify_LA();
					}
					
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false, "try block for script failed");
			
		}
	}
	@Description("FordDrive packages page verification end")
    @AfterTest
	public static void tearDown() {
		driver.quit();
		//System.out.println("Test completed successfully.");
		Assert.assertTrue(true, "Test completed successfully.");
		//river.close();
	}
	
}
