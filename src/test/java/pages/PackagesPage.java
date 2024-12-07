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
import org.testng.annotations.Listeners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import ios.AllureListener;
import ios.BaseClass;
@Listeners({AllureListener.class})
public class PackagesPage extends BaseClass {
	public AppiumDriver driver;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public PackagesPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeOther[@value=\"3\"])[2]")
    public WebElement pkg_tier1;
	//XCUIElementTypeStaticText[@name="PREMIUM"]
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"PREMIUM\"]")
    public WebElement pkg_tier1_premium;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeOther[@value=\"3\"])[5]")
	public WebElement pkg_tier2;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"STANDARD\"]")
	public WebElement pkg_tier2_standard;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeOther[@value=\"3\"])[8]")
	public WebElement pkg_tier3;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeOther[@value=\"3\"])[11]")
	public WebElement pkg_tier4;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"package-selection-mache\"]")
	public WebElement image_Car;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Bundled Insurance\"]")
	public WebElement link_BundleInsurance;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Award-Winning EV\"]")
	public WebElement text_Award_Winning_EV;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Vehicle Maintenance\"]")
	public WebElement text_Vehicle_Maintenance;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Ultimate Flexibility\"]")
	public WebElement text_Ultimate_Flexibility;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"pattern\"]")
	public WebElement Image_lightning;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"259\"]")
	public WebElement tiervalue_SD1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"309\"]")
	public WebElement tiervalue_SD2;
	
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"369\"]")
	//public WebElement tiervalue_SD3;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"500\"]")
	public WebElement miles_std;
	
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"1000\"]")
	//public WebElement miles_advanced;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Unlimited miles included\"]")
	public WebElement miles_premium;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"269\"]")
	public WebElement tiervalue_SF1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"319\"]")
	public WebElement tiervalue_SF2;
	
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"379\"]")
	//public WebElement tiervalue_SF3;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"259\"]")
	public WebElement tiervalue_LA1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"309\"]")
	public WebElement tiervalue_LA2;
	
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"389\"]")
	//public WebElement tiervalue_LA3;
	
	
	@Step("Verify car image")
	public void verify_image_Car() throws InterruptedException {
		boolean car=image_Car.isDisplayed();
		Assert.assertTrue(car);
	}
	
	@Step("Verify lightning image")
	public void verify_lightning_icon() throws InterruptedException {
		boolean lightIcon=Image_lightning.isDisplayed();
		Assert.assertTrue(lightIcon);
	}
	
	@Step("Verify bundle insurance link")
	public void verify_insurance_icon() throws InterruptedException {
		boolean lightIcon1=link_BundleInsurance.isDisplayed();
		Assert.assertTrue(lightIcon1);
	}
	
	@Step("Verify text- Award_Winning_EV ")
	public void verify_text_AwarWinning() {
		boolean lightIcon11=text_Award_Winning_EV.isDisplayed();
		Assert.assertTrue(lightIcon11);
			
	}
	
	@Step("Verify text- Vehicle_Maintenance ")
	public void verify_text_Vehicle_Maintenance() {
		boolean lightIcon111=text_Vehicle_Maintenance.isDisplayed();
		Assert.assertTrue(lightIcon111);
			
	}
	
	@Step("Verify text- Ultimate_Flexibility")
	public void verify_text_Ultimate_Flexibility() {
		boolean lightIcon110=text_Ultimate_Flexibility.isDisplayed();
		Assert.assertTrue(lightIcon110);
			
	}
	
	@Step("Verify miles and values in SD")
	public void verify_SD() {
		boolean tier1SD=tiervalue_SD1.isDisplayed();
		if(tier1SD) {
			boolean milesSTD=miles_std.isDisplayed();
			if(milesSTD) {
			Assert.assertTrue(true, "tier 1 miles in SD is correct");
			}
			else {
			Assert.assertTrue(false, "tier 1 miles in SD is incorrect");	
			}
		}
		else {
			Assert.assertTrue(true, "tier 1 value  and miles in SD is incorrect");
		}
		
		boolean tier2SD=tiervalue_SD2.isDisplayed();
		if(tier2SD) {
			boolean milesADV=miles_premium.isDisplayed();
			if(milesADV) {
			Assert.assertTrue(true, "tier 2 miles in SD is correct");
			}
			else {
		    Assert.assertTrue(false, "tier 2 miles in SD is incorrect");	
			}
		}
		
		else {
			Assert.assertTrue(false, "tier 2 value  and miles in SD is incorrect");
		}
		//scroll bar 
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; HashMap<String, String>
		 * scrollObject = new HashMap(); scrollObject.put("direction", "up");
		 * js.executeScript("mobile: swipe", scrollObject);
		 * 
		 * boolean tier3SD=tiervalue_SD3.isDisplayed(); if(tier3SD) { boolean
		 * milesprem=miles_premium.isDisplayed(); if(milesprem) {
		 * Assert.assertTrue(true, "tier 3 miles in SD is correct"); } else {
		 * Assert.assertTrue(false, "tier 3 miles in SD is incorrect"); } }
		 * 
		 * else { Assert.assertTrue(false,
		 * "tier 3 value  and miles in SD is incorrect"); }
		 */
	}
	
	
	@Step("Verify miles and values in LA")
	public void verify_LA() {
		boolean tier1LA=tiervalue_LA1.isDisplayed();
		if(tier1LA) {
			boolean milesSTD=miles_std.isDisplayed();
			if(milesSTD) {
			Assert.assertTrue(true, "tier 1 miles in LA is correct");
			}
			else {
			Assert.assertTrue(false, "tier 1 miles in LA is incorrect");	
			}
		}
		else {
			Assert.assertTrue(true, "tier 1 value  and miles in LA is incorrect");
		}
		
		boolean tier2LA=tiervalue_LA2.isDisplayed();
		if(tier2LA) {
			boolean milesADV=miles_premium.isDisplayed();
			if(milesADV) {
			Assert.assertTrue(true, "tier 2 miles in LA is correct");
			}
			else {
		    Assert.assertTrue(false, "tier 2 miles in LA is incorrect");	
			}
		}
		
		else {
			Assert.assertTrue(false, "tier 2 value  and miles in LA is incorrect");
		}
		//scroll bar 
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; HashMap<String, String>
		 * scrollObject = new HashMap(); scrollObject.put("direction", "up");
		 * js.executeScript("mobile: swipe", scrollObject);
		 * 
		 * boolean tier3LA=tiervalue_LA3.isDisplayed(); if(tier3LA) { boolean
		 * milesprem=miles_premium.isDisplayed(); if(milesprem) {
		 * Assert.assertTrue(true, "tier 3 miles in LA is correct"); } else {
		 * Assert.assertTrue(false, "tier 3 miles in LA is incorrect"); } }
		 * 
		 * else { Assert.assertTrue(false,
		 * "tier 3 value  and miles in LA is incorrect"); }
		 */
	}
	
	@Step("Verify miles and values in SF")
	public void verify_SF() {
		boolean tier1SF=tiervalue_SF1.isDisplayed();
		if(tier1SF) {
			boolean milesSTD=miles_std.isDisplayed();
			if(milesSTD) {
			Assert.assertTrue(true, "tier 1 miles in SF is correct");
			}
			else {
			Assert.assertTrue(false, "tier 1 miles in SF is incorrect");	
			}
		}
		else {
			Assert.assertTrue(true, "tier 1 value  and miles in SF is incorrect");
		}
		
		boolean tier2SF=tiervalue_SF2.isDisplayed();
		if(tier2SF) {
			boolean milesPREM=miles_premium.isDisplayed();
			if(milesPREM) {
			Assert.assertTrue(true, "tier 2 miles i SF is correct");
			}
			else {
		    Assert.assertTrue(false, "tier 2 miles in SF is incorrect");	
			}
		}
		
		else {
			Assert.assertTrue(false, "tier 2 value  and miles in SF is incorrect");
		}
		
//		boolean tier3SF=tiervalue_SF3.isDisplayed();
//		if(tier3SF) {
//			boolean milesPREM=miles_premium.isDisplayed();
//			if(milesPREM) {
//			Assert.assertTrue(true, "tier 2 miles i SF is correct");
//			}
//			else {
//		    Assert.assertTrue(false, "tier 2 miles in SF is incorrect");	
//			}
//		}
//		
//		else {
//			Assert.assertTrue(false, "tier 2 value  and miles in SF is incorrect");
//		}
	}
	
}
