package ios;
//## Experian validations

import org.testng.Assert;

//To verify Driver receives SSN error page when SSN profile isn't accessible
//To verify error screen is displayed experian check is failed.
//To verify the continue button should enable after providing SSN

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
//
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.ode.events.EventHandler.Action;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

@Listeners({AllureListener.class})
public class ExperianSpecial extends BaseClass {
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

		@Description("Experian SSN usecase")
		@Epic("Application Page")
		@Feature("Feature4: Application Page Validations")
		@Severity(SeverityLevel.CRITICAL)
		@Test
	    @SuppressWarnings("deprecation")
	public static void ExperianFailTest() throws MalformedURLException {

		
		//import page class and initialse obj of this all page class
		PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);
		OTPPage otppg = new OTPPage(driver);
		PackagesPage pkgpg=new PackagesPage(driver);
		ApplicationPage applicnpg=new ApplicationPage(driver);
		CreditCardPage creditcardpg=new CreditCardPage(driver);
		DashboardPage dashbpg = new DashboardPage(driver);
		
		// run launch chrome
		try {

			// fill details on Partial signup
			FileInputStream fs = new FileInputStream("/Users/sgrover7/eclipse-workspace/ios/src/test/resources/InputFile/ExperianSpecial.xlsx");
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
					
					//import more data from sheet
					String fn = sheet.getRow(j).getCell(5).toString();
					String ln = sheet.getRow(j).getCell(6).toString();
					String month = sheet.getRow(j).getCell(7).toString();
					String day = sheet.getRow(j).getCell(8).toString();
					String year = sheet.getRow(j).getCell(9).toString();
					String addr1 = sheet.getRow(j).getCell(10).toString();
					String city = sheet.getRow(j).getCell(11).toString();
					String state = sheet.getRow(j).getCell(12).toString();
					String zip = sheet.getRow(j).getCell(13).toString();
					String SSN = sheet.getRow(j).getCell(14).toString();
					
					//condition
					String condition = sheet.getRow(j).getCell(17).toString();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					if (env.contains("stage")) {
						
					driver.get("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
					}
					
					else if (env.contains("preprod")) {
						driver.get("https://preprod.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
						
					 } else if (env.contains("dev")) {
							
					 } else {
						 driver.get("https://rideshare.forddrive.com/sign-up?referrer=https%3A%2F%2Fbonjour.uber.com%2F");
						
					}
					
					//if detect cookie settings
					PartialSignupPg.ignore_cookie_popup();
					
					//Partial page enter data
					PartialSignupPg.fill_signup_experian_special(fn,ln);
					//fill zipcode based on excel data 
					PartialSignupPg.text_HomeZipCode.click();
					Thread.sleep(5000);		
					if (loc.contains("LA")) {
						PartialSignupPg.text_HomeZipCode.sendKeys("90007");
					
					} // fetch for loc based from sheet
					else if (loc.contains("SD")) {
						PartialSignupPg.text_HomeZipCode.sendKeys("92142");
					} else {
						PartialSignupPg.text_HomeZipCode.sendKeys("94123");
					}
					
					PartialSignupPg.submit_signup1();
					
					//if detect cookie settings
					otppg.ignore_cookie_popup_otp();
					// Fetch OTP and paste
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
					applicnpg.fill_application_Experianspecial(month,day,year,addr1,city,state,zip,SSN,condition);
					
					//SSN verification page 
					
					//page title
					//applicnpg.SSn_page();
					
					
					//SSN field present/absent
					//applicnpg.SSn_page_field();
					
					//verify continue button is disabled before entering ssn value
					//applicnpg.check_continu_disable();
					
					//enter SSN
					//applicnpg.enter_ssn_submit_custom(SSN);
					
					//click continue
					//applicnpg.button_continue.click();
					
					//identify lets go button coming or not
					creditcardpg.verify_letsgo();
					
					Thread.sleep(6000);
					//System.out.println("Rule of this testcase...." +condition);
					//error page
					//applicnpg.chec_experian1();
					//
					
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		@AfterMethod
		@Description("FordDrive experian verification end")
		@AfterTest
		public static void tearDown() {
			//driver.quit();
			//System.out.println("Test completed successfully.");
			Assert.assertTrue(true, "Test completed successfully.");
		}

}
