package ios;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.Synchronized;

public class BaseClass {
public static AppiumDriver driver;

public static ThreadLocal<AppiumDriver> tdriver = new ThreadLocal<AppiumDriver>();

public AppiumDriver initialize_driver() throws MalformedURLException {
	XCUITestOptions options = new XCUITestOptions();
	options.setDeviceName("iPhone 16")
	.setPlatformName("18.1")
	.setBundleId("com.apple.mobilesafari")
	.safariAllowPopups()
	.setSafariAllowPopups(true)
	.setAutoAcceptAlerts(true)
	.setFullReset(false)
	.setClearSystemFiles(true)
	.setConnectHardwareKeyboard(true)
	.setForceSimulatorSoftwareKeyboardPresence(true);
	// appium server url
	URL url = new URL("http://127.0.0.1:4723");
	driver = new IOSDriver(url, options);
	
	
	//after above initialse , we are locking driver to thread driver and returning it so that
	//it can be called by other classes
	tdriver.set(driver);
	return getDriver();
	
}

public static synchronized AppiumDriver  getDriver() {
	// TODO Auto-generated method stub
	return tdriver.get();
}
}
