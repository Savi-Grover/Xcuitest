package ios;
//## Signup flow
//Verify new customers can be signed up from forddrive website
//To verify Driver's logo and all other links on all pages

//## Partial Signup Page
//Verify footer links on the main page of Ford drive website

//##OTP Page
//Verify footer links on Partial Profile page-cannot be done

//## Pricing Page
//Verify new driver can click on footer links on package selection page.

//##Application Page
//Verify footer links are clickable on Soft Credit Check page

//##Congrats Page
//Verify footer links on congrats page

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.config.AwaitUnconditionallyReliabilityStrategy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
import pages.FooterPage;
import pages.OTPPage;
import pages.PackagesPage;
import pages.PartialSignupPage;


public class FooterLinksAllPages extends BaseClass {
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
		FooterPage footer;
		
		@Description("FordDrive footer verification begin")
		@Epic("Footer")
		@Feature("Feature1: Footer on all pages ")
		@Severity(SeverityLevel.CRITICAL)	
    @Test
	@SuppressWarnings("deprecation")
	public static void FooterLinksTest() throws MalformedURLException {
		
		// run launch chrome
		try {
			
			
			//import page class and initialse obj of this all page class
			PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);
			OTPPage otppg = new OTPPage(driver);
			PackagesPage pkgpg=new PackagesPage(driver);
			ApplicationPage applicnpg=new ApplicationPage(driver);
			CreditCardPage creditcardpg=new CreditCardPage(driver);
			//DashboardPage dashbpg = new DashboardPage(driver);
			FooterPage footer= new FooterPage(driver);

			// fill details on Partial signup
			FileInputStream fs = new FileInputStream("/Users/sgrover7/eclipse-workspace/ios/src/test/resources/InputFile/FooterLinksAllPages.xlsx");
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
					//String zipcode = sheet.getRow(j).getCell(2).toString();
					String tier = sheet.getRow(j).getCell(3).toString();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (env.contains("stage")) {
						
					driver.get("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
					String context=((SupportsContextSwitching) driver).getContext();
					System.out.println(context);
					Thread.sleep(3000);
					
					//if detect cookie settings
					PartialSignupPg.ignore_cookie_popup();
					
					//Footer link on partial sign-up
					footer.footer_verify();
					
					
					} else if (env.contains("preprod")) {
						
					 } else if (env.contains("dev")) {
							
					 } else {
						 driver.get("https://rideshare.forddrive.com/sign-up?referrer=https%3A%2F%2Fbonjour.uber.com%2F");
						
					}
					
					//if detect cookie settings
					PartialSignupPg.ignore_cookie_popup();
					
					//signup
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
	
					//if detect cookie settings
					//otppg.ignore_cookie_popup_otp();
					// Fetch OTP and paste
					
					//try {
					//	otppg.text_OTP.click();
					//}
					
					//catch(Exception e ) {
					//	
					//}
					Thread.sleep(17000);
					otppg.fill_send_otp();
					
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
					
					//Footer link on address pg
					footer.footer_verify();
					
					// address page
					applicnpg.fill_application();
					
					// Click on Lets Go
					Thread.sleep(15000);
					creditcardpg.button_letsGo.click();	
					Thread.sleep(15000);
					
					//scroll down
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					HashMap<String, String> scrollObject = new HashMap();
					scrollObject.put("direction", "up");
					js.executeScript("mobile: swipe", scrollObject); 
					
					//Footer links on congats page
					//footer.footer_verify();
					//footer.footer_image();
					footer.footer_faq();
					creditcardpg.button_letsGo.click();	
					footer.footer_cookie();
					footer.footer_tc();
					footer.footer_fordcom();
					footer.footer_privacyNotice();
					footer.footer_privacyChoice();
					
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@AfterMethod
		@Description("FordDrive Signup page process end")
		@AfterTest
		public static void tearDown() {
			driver.quit();
			//System.out.println("Test completed successfully.");
			Assert.assertTrue(true, "Test completed successfully.");
		}
		}
