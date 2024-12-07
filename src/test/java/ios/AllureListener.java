package ios;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.Generate.CustomLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener
{
	
	//user defined method
 private static String getTestMethodName(ITestResult iTestResult) {
	 return iTestResult.getMethod().getConstructorOrMethod().getName();
 }
 
 //allure method
 @Attachment
 public byte[] saveFailureScreenShot(AppiumDriver driver) {
	 return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
 }
 
//allure method
 @Attachment(value="{0}", type= "text/plain")
 public static String saveTextLog(String message) {
	 return message;
 }
 
 @Attachment(value="{0}", type = "image/png", fileExtension = ".png")
 public byte[] takeScreenshot(AppiumDriver driver) {
 System.out.println("taking screenshot");
 return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
 
 }
 
 //we need to take all method from iTestListener class & override those methods
 @Override
 public void onStart(ITestContext iTestContext) {
	 System.out.println("onStart method begin  " +iTestContext.getName());
	 
	 //refer the same driver as used in testcase
	 iTestContext.setAttribute("AppiumDriver", BaseClass.getDriver());
 }
	
 @Override
 public void onFinish(ITestContext iTestContext) {
	 System.out.println("onFinish method begin  " +iTestContext.getName());
	 
 }
 
 @Override
 public void onTestStart(ITestResult iTestResult) {
	 System.out.println("onTest method begin  " +getTestMethodName(iTestResult)+ " started");
	 
 }
 
 @Override
 public void onTestSuccess(ITestResult iTestResult) {
	 System.out.println("onTestSuccess method begin " +getTestMethodName(iTestResult)+ " success");
	 
 }
 
 @Override
 public void onTestFailure(ITestResult iTestResult) {
	 System.out.println("onTestFailure method begin " +getTestMethodName(iTestResult)+ " failed");
	 Object testClass = iTestResult.getInstance();
	 AppiumDriver driver = BaseClass.getDriver();
	 
	 //Allure Screenshot and save Testlog
	 
	 if(driver instanceof AppiumDriver) {
		 System.out.println("Screeshot captured for testcase: " +getTestMethodName(iTestResult));
		 takeScreenshot(driver);
		 
	 }
	 saveTextLog(getTestMethodName(iTestResult)+ "failed and screenshot taken!");
	 
	 
 }
 
 @Override
 public void onTestSkipped(ITestResult iTestResult) {
	 System.out.println("onTestSkipped method begin" +getTestMethodName(iTestResult)+ " skipped");
	 
 }
 
 @Override
 public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	 System.out.println("test failed but it is defined sucess ration" +getTestMethodName(iTestResult)+ " start");
	 
 }
}
