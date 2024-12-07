package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import ios.BaseClass;

public class FooterPage extends BaseClass{
	public AppiumDriver driver;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public FooterPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Ford Drive Logo\"]")
    public WebElement logo_forddrive;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Elevate Your Rideshare Game\"]")
	public WebElement text_forddrivecom;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	public WebElement close_butn;
	
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"SUV Season Sales Event\"]")
	public WebElement title_fordcom;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"BackButton\"]")
	public WebElement button_back;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"FAQ\"]")
	public WebElement link_faq;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"FAQ\"])[1]")
	public WebElement title_faq;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Cookie Settings\"]")
	public WebElement link_cookieSettings;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Confirm My Choices\"]")
	public WebElement button_confirmCookies;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Terms & Conditions\"]")
    public WebElement link_termsCond;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Terms and Conditions\"]")
	public WebElement text_termsCond;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Visit Ford.com\"]")
	public WebElement link_visitFordcom;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Step Up to the Starting Line\"]")
	public WebElement text_visitfordcom;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Notice\" and @value=\"Privacy Notice\"]")
	public WebElement link_privacyNotice;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Ford US Privacy Notice\"]")
	public WebElement button_privacyNotice;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Your Privacy Choices\"]")
	public WebElement link_privacyChoices;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"Your Privacy Choices\"])[1]")
	public WebElement text_privacyChoices;

	//private Assert AssertJUnit;
	
	@Step("Footer verification started")
	public void footer_verify() throws InterruptedException {
	
		footer_image();
		footer_faq();
		//footer_cookie();
		footer_tc();
		footer_fordcom();
		footer_privacyNotice();
		footer_privacyChoice();
		
	}
	
	@Step("ford drive image link verification")
	public void footer_image() throws InterruptedException {
		//forddrive.com image
	logo_forddrive.click();
	Thread.sleep(7000);	
	String pgTitle=text_forddrivecom.getText().toString();
	String expected1Title= "Elevate Your Rideshare Game";
    if(pgTitle.contains(expected1Title)) {
	System.out.println("forddrive image link navigation is correct");
		}
	else {}
	button_back.click();
	}
	
	@Step("ford drive faq link verification")
	public void footer_faq() throws InterruptedException{
		//Faq
				link_faq.click();
				Thread.sleep(3000);	
				String pageTitle=title_faq.getText().toString();
				String expectedTitle= "FAQ";
				if(pageTitle.contains(expectedTitle)) {
				Assert.assertTrue(true, "faq link verified");
				System.out.println("fAQ link navigation is correct");
				}
				else {
					AssertJUnit.assertFalse(true);
					}
				button_back.click();	
	}
	
	@Step("ford drive cookie link verification")
	public void footer_cookie() throws InterruptedException{
		//cookie settings
				link_cookieSettings.click();
				Thread.sleep(3000);	
				button_confirmCookies.click();	
		
	}
	
	@Step("ford drive t&c link verification")
	public void footer_tc() throws InterruptedException{
		//tc
				link_termsCond.click();
				Thread.sleep(3000);	
				String currentUrl1=text_termsCond.getText().toString();
				String getUrlString1= "Terms and Conditions";
				if(currentUrl1.equalsIgnoreCase(getUrlString1)) {
					System.out.println("tc link navigation is correct");
					Assert.assertTrue(true, "tc link verified");
				}
				else{
					AssertJUnit.assertFalse(true);
					}
				button_back.click();
		
	}
	
	@Step("ford drive ford.com link verification")
	public void footer_fordcom() throws InterruptedException{
		//ford.com
				link_visitFordcom.click();
				Thread.sleep(3000);	
				String currentUrl2=title_fordcom.getText().toString();
				try {
				close_butn.click();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				//XCUIElementTypeButton[@name="Close"]
				String getUrlString2= "SUV SEASON SALES EVENT";
				if(currentUrl2.equalsIgnoreCase(getUrlString2)) {
					System.out.println("ford.com link navigation is correct");
					Assert.assertTrue(true, "ford.com link verified");
				}
				else{
					AssertJUnit.assertFalse(true);
					}
				button_back.click();
				Thread.sleep(3000);	
		
	}
	
	@Step("ford drive privacy notice link verification")
	public void footer_privacyNotice() throws InterruptedException{
		//privacy notice
				link_privacyNotice.click();
				Thread.sleep(3000);	
				String currentUrl3=button_privacyNotice.getText().toString();
				String getUrlString3= "Ford US Privacy Notice";
				if(getUrlString3.equalsIgnoreCase(currentUrl3)) {
					System.out.println("privacy notice link navigation is correct");
					Assert.assertTrue(true, "privacy notice link verified");
				}
				else{
					AssertJUnit.assertFalse(true);
					}
				button_back.click();
				Thread.sleep(3000);	
		
	}
	
	@Step("ford drive privacy choice link verification")
	public void footer_privacyChoice() throws InterruptedException{
		//privacy choices
				link_privacyChoices.click();
				Thread.sleep(3000);	
				String currentUrl4=text_privacyChoices.getText().toString();
				String getUrlString4= "Your Privacy Choices";
				if(currentUrl4.equalsIgnoreCase(getUrlString4)) {
					System.out.println("privacy choices link navigation is correct");
					Assert.assertTrue(true, "privacy choice link verified");
				}
				else{
					AssertJUnit.assertFalse(true);
					}
				button_back.click();
				Thread.sleep(3000);		
		
	}
	
	
}
