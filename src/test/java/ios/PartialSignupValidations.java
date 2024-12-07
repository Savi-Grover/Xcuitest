package ios;

//Validate new driver can see zipcode tooltip field in Partial Signup
//Verify Get started button is disabled when partial profile page not completed
//Validate format of First Name & Last Name field in Partial Signup
//Validate format of Email & phone number field in Partial Signup
//Validate format of zipcode field in Partial Signup

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.PartialSignupPage;


public class PartialSignupValidations extends BaseClass {
	static AppiumDriver driver;
	
	@Description("IOS Setup")
	@BeforeTest
	@SuppressWarnings({ "deprecation", "unused", "unused", "unused", "unused" })
	
	  public AppiumDriver setup() throws MalformedURLException{

		 BaseClass bs=new BaseClass();
		 driver=bs.initialize_driver();
		 return driver;
	}
 
	PartialSignupPage PartialSignupPg;
	
	@Description("FordDrive partial signup page verification begin")
	@Epic("Partial Signup Page")
	@Feature("Feature1: Partial Signup Page Validations")
	@Severity(SeverityLevel.CRITICAL)
    @Test
	@SuppressWarnings("deprecation")
	public static void PartialSignupValidations() throws MalformedURLException {

		//import page class and initialse obj of this all page class
		PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);

		// run launch chrome
		try {

			// fill details on Partial signup
			FileInputStream fs = new FileInputStream("/Users/sgrover7/eclipse-workspace/ios/src/test/resources/InputFile/PartialSignupValidations.xlsx");
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
					
					} 
					else if (env.contains("preprod")) {
					driver.get("https://preprod.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
						
					 } 
					else if (env.contains("dev")) {
					driver.get("https://dev.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
							
					 } 
					else {
					driver.get("https://rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
						
					}
					
					//if detect cookie settings
					PartialSignupPg.ignore_cookie_popup();
					
					//check Get started button is disabled 
					PartialSignupPg.Verify_button_disabled();
					
					//fill partial signup invalid data
					PartialSignupPg.fill_signup1_invalid();
					
					//capture all Validation msg
					PartialSignupPg.capture_validations_fn();
					PartialSignupPg.capture_validations_ln();
					PartialSignupPg.capture_validations_email();
					PartialSignupPg.capture_validations_phone();
					PartialSignupPg.capture_validations_zip();
					
					//verify zipcode tooltip
					PartialSignupPg.tooltip_verify();
					
					
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	@Description("FordDrive partial signup page verification end")
	@AfterTest
	public static void tearDown() {
		//driver.quit();
		//Assert.assertTrue(true, "Test completed successfully.");
	}
	
}
