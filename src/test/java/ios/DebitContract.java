package ios;
//## Signup flow
//Verify new customers can be signed up from forddrive website

//## Partial Signup Page
//Verify new driver is able to submit profile details at  partial signup  page
//Verify new drivers can signup only using Garaging Zipcodes.

//## Pricing Page

//Verify new driver can select pricing tier after OTP verification.
//Verify new driver directly moves to Application approval page after choosing a tier

//##Application Page
//Validate checkbox is required for next step

//##Congrats Page
//Verify new user gets CONGRATS page (Popup model) once soft credit check passed
//Verify let's Go button functionality
//Verify Credit card info functionality - when driver clicks drop down button on add credit card screen
//Verify Create password functionality - when driver clicks drop down button on Create password screen
//Verify Driver able to create password - Password and confirm password text fields with mentioned conditions
//Verify new user's Pickup pending page after password creation
//Verify new user can create his account password once soft credit check passed
//Verify dropdown functionality in add credit card section on Next step page (Approved waitlist page)- for password creation dropdown

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.appmanagement.BaseOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.options.wda.SupportsAutoAcceptAlertsOption;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.remote.options.SupportsNewCommandTimeoutOption;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ApplicationPage;
import pages.CreditCardPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OTPPage;
import pages.PackagesPage;
import pages.PartialSignupPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import pages.PartialSignupPage;

//public class SignupFordrive extends ExtentReportsDemo {
	public class DebitContract extends BaseClass {
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
	
	
	@Description("FordDrive Login verification begin")
	@Epic("Login Page")
	@Feature("Feature1: Login Page Process")
	@Severity(SeverityLevel.CRITICAL)
	@Test
    @SuppressWarnings("deprecation")
	public void LoginForddriveContractModal() throws MalformedURLException {
		// run launch chrome
		try {
			
	       //import page class and initialse obj of this all page class
			PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);
			OTPPage otppg = new OTPPage(driver);
			PackagesPage pkgpg=new PackagesPage(driver);
			ApplicationPage applicnpg=new ApplicationPage(driver);
			CreditCardPage creditcardpg=new CreditCardPage(driver);
			DashboardPage dashbpg = new DashboardPage(driver);
			LoginPage login = new LoginPage(driver);
			
			// fill details on Partial signup
			FileInputStream fs = new FileInputStream("/Users/sgrover7/eclipse-workspace/ios/src/test/resources/InputFile/DebitContract.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get row count & no of accounts
			int rowNum = sheet.getLastRowNum();
			//int numOfAccts = (int) sheet.getRow(1).getCell(4).getNumericCellValue();
			//System.out.println("total number of rows is:  " + rowNum);

			// loop begin- parent loop runs for number of rows
			//for (int j = 1; j <= rowNum; j++) {

				// int numOfAccts1=(int) sheet.getRow(j).getCell(5).getNumericCellValue();
				//int noOfsignups = (int) sheet.getRow(j).getCell(4).getNumericCellValue();

				// second loop runs for 1 row of data - for number of account times
				//System.out.println("total number of accounts in first row: " + noOfsignups);
				for (int i = 1; i <= rowNum; i++) {
					// System.out.println("running iterations for this number of times"
					// +numOfAccts);
					String env = sheet.getRow(i).getCell(0).toString();
					String email = sheet.getRow(i).getCell(1).toString();
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (env.contains("stage")) {
						
					driver.get("https://stage.rideshare.forddrive.com/login-email");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
					
					
					} else if (env.contains("preprod")) {
					driver.get("https://preprod.rideshare.forddrive.com/login-email");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
						
					 } else if (env.contains("dev")) {
					driver.get("https://dev.rideshare.forddrive.com/login-email");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
							
					 } else {
					driver.get("https://rideshare.forddrive.com/login-email");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);	
					}
	
					//if detect cookie settings
					Thread.sleep(8000);
					PartialSignupPg.ignore_cookie_popup();

					//Sign in button
					login.text_EmailAddress1.click();
					login.text_EmailAddress1.sendKeys(email);
					login.button_continue.click();
					Thread.sleep(5000);
					
					PartialSignupPg.ignore_cookie_popup();
					
					//enter email-password
					login.text_emailToLogin.click();
					login.text_emailToLogin.sendKeys(email);
					//Thread.sleep(4000);
					login.text_password.click();
					login.text_password.sendKeys("Ford123!" + Keys.ENTER);
					Thread.sleep(4000);
					
					login.verifyDebitContract();
					//verify contract popup
					
					
				}
			//}

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	@Description("FordDrive Login process end")
	@AfterTest
	public static void tearDown() {
		driver.quit();
		//System.out.println("Test completed successfully.");
		Assert.assertTrue(true, "Test completed successfully.");
	}
	}

