package ios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class FirstIOSTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		firstTest();
	}
	
	@SuppressWarnings("deprecation")
	public static void firstTest() throws MalformedURLException {
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15")
		.setPlatformName("17.4")
		.setBundleId("com.apple.mobilesafari");
	
		//appium server url
		URL url = new URL("http://127.0.0.1:4723");
		AppiumDriver driver = new IOSDriver(url,options);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//code to navigate to stage url
		System.out.println("before url stage");
		driver.get("https://stage.rideshare.forddrive.com/sign-up");
		System.out.println("after url stage");
		
		
	}

}
