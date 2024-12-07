package ios;
//##password page  validations
//Verify Submit button is disabled when fields are not filled completely (Credit card fields).
//Verify Validations messages on Create password section - Password and confirm password text fields 
//--(Not providing one lower and upper case, Without number and special characters and less than 6 characters...)
//Verify Driver fails to create the password without mentioned conditions
//To verify "Create Password" button is disabled when password not created
//To verify Driver is able to provide Valid Driver license number, personal information and Zip code for the Soft Credit check.
//Validate Driving License number for Experian Check
//Check error message on invalid Driver license
//Validate Date of birth of driver
//Validate Home address.

import org.testng.annotations.AfterMethod;
import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
import pages.ApplicationPage;
import pages.CreditCardPage;
import pages.DashboardPage;
import pages.OTPPage;
import pages.PackagesPage;
import pages.PartialSignupPage;


public class ApplicationPageValidations extends BaseClass {
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
		ApplicationPage applicnpg;
		CreditCardPage creditcardpg;
		DashboardPage dashbpg;
		
		@Description("FordDrive application page verification begin")
		@Epic("Application Page")
		@Feature("Feature4: Application Page Validations")
		@Severity(SeverityLevel.CRITICAL)
		@Test
	    @SuppressWarnings("deprecation")
  	    public static void ApplicationPageValidations() throws MalformedURLException {
        //import page class and initialse obj of this all page class
			
		PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);
		OTPPage otppg = new OTPPage(driver);
		PackagesPage pkgpg=new PackagesPage(driver);
		ApplicationPage applicnpg=new ApplicationPage(driver);
		//CreditCardPage creditcardpg=new CreditCardPage(driver);
		//DashboardPage dashbpg = new DashboardPage(driver); 
				
		// run launch chrome
		try {

			// fill details on Partial signup
			FileInputStream fs = new FileInputStream("/Users/sgrover7/eclipse-workspace/ios/src/test/resources/InputFile/ApplicationPageValidatons.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get row count & no of accounts
			int rowNum = sheet.getLastRowNum();
			int numOfAccts = (int) sheet.getRow(1).getCell(4).getNumericCellValue();
			System.out.println("total number of rows is:  " + rowNum);

			// loop begin- parent loop runs for number of rows
			for (int j = 1; j <= rowNum; j++) {

				// int numOfAccts1=(int) sheet.getRow(j).getCell(5).getNumericCellValue();
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
					
					//add code to check oops page and break
					
					// choose package based on excel data
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					if (tier.contains("1")) {
						pkgpg.pkg_tier1_premium.click(); // chnage tier
					} 
					else  {
						pkgpg.pkg_tier2_standard.click();
					}
					Thread.sleep(5000);
					
					// address page
					//applicnpg.fill_application_dont_submit();
					
					//to see submit disabled when application page not fully filled
					boolean submitbutton= applicnpg.button_submit.isEnabled();
					Assert.assertFalse(submitbutton);
					
					//fill application with invlaid data
					applicnpg.invalid_application();
					
					//verify all validation messages
					applicnpg.verify_DL();
					applicnpg.verify_DOB();
					applicnpg.verify_addressSymbol();
					applicnpg.verify_city();
					applicnpg.verify_state();
					applicnpg.verify_zip();
					
					
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@AfterMethod
		@Description("FordDrive application page verification end")
		@AfterTest
		public static void tearDown() {
			driver.quit();
			//System.out.println("Test completed successfully.");
			Assert.assertTrue(true, "Test completed successfully.");
		}

}
