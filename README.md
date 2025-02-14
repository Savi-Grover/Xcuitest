# steps -appium-ios

**IOS Automation - Installation in MAC**
1. brew install node
2. brew install java
3. npm install -g appium
4. npm install appium-doctor -g
5. appium-doctor --ios

**Perform path setting in nano /.zshrc in mac**

6. brew doctor
7. xcode-select --install
8. xcode-select -p
9. brew install Carthage

**Install drivers :**

10. appium driver list
11. appium driver install xcuitest
12. appium driver list  
13. appium driver install uiautomater2

**Start Xcode and set simulator 
  Download Appium Inspector** 

14. filter in privacy settings of mac
15. Terminal : xattr -d com.apple.quarantine -"path of appium inspector"
16. Try decoding xpaths of mobile elements in NATIVE_APP mode from appium inspector.

**IOS driver capabilities used**
NOTE: Update the PlatformName, DeviceName according to the Simulator you downloaded.

XCUITestOptions options = new XCUITestOptions();

		options.setDeviceName("iPhone 15")
		.setPlatformName("17.4")
		.setBundleId("com.apple.mobilesafari")
		.safariAllowPopups()
		.setSafariAllowPopups(true)
		.setAutoAcceptAlerts(true)
		.setFullReset(false)
		.setClearSystemFiles(true)
		.setConnectHardwareKeyboard(true)
		.setForceSimulatorSoftwareKeyboardPresence(true);
    
    URL url = new URL("http://127.0.0.1:4723");
		AppiumDriver driver = new IOSDriver(url, options);
    
**Created a simple maven project in Eclipse**
1. Created simple maven project in eclipse with artifact id and group id.
2. Added maven dependencies in pom.xml; updated maven ; clean ; build project.
3. Added package in src = ios where all testcases (classes) will be contained.
4. Added package in src = pages where all page files will be contained.
5. Added above driver capabilities and initialised driver in main java class.
6. Run testcase as java application

**Page Object Model**

1. Define all methods and web elements by @iosXCUITFindBy in page.java.
2. import page.class in testcase classes ; initialise object of each page at class level. These objects will be utilized to call 
methods and elements of page.java into testcases by . operator.
3. Resusability / change in xpaths or methods will be just done in page.java file only.
4. Testcase.java will just indicate flow of execution to call page.java class's functions & webelements.

**TestNG Installation**
1. On eclipse project > HELP on top > install new software > ADD > TestNG ; https://testng.org/testng-eclipse-update-site
2. Add testng libraries in project - in pom - add testng maven dependencies
3. Convert testcase to TESTNG
4. Run testcase as TestNG.

**TestNG.XML**

	<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
	<suite  name="Suite1">
	<test thread-count="5" name="Test">
	<classes>
	<class name="ios.ApplicationPageValidations"/>
	</classes>
	</test> <!-- Test -->
	</suite> <!-- Suite -->

**Allure Reports Installation**

1. brew install allure - in terminal or download allure.zip and unzip it.
2. check allure --version
3. System set path in zshrc
export PATH="path of bin folder of allure"
4. set latest maven dependency in project for allure, aspectjweaver ; aspectjtools
5. Run testcase as testng.
6. refresh the project ; you will see output for allure in "allure-results" folder
7. Go to new window terminal : command = allure serve "path-of-allure-results-folder"
8. Reports will appear in below format:
	
![image](https://media.github.ford.com/user/30776/files/979ba17b-2e11-4859-b515-e3569bfa8fe7)

**Running Imported Project**

1. you can run the testscripts individually by testng suite.
2. or you can run any testng.xml 

![image](https://media.github.ford.com/user/30776/files/7f5fda26-7576-499b-9bd5-62c3e91916f6)

3. make sure to change path of input excel fle according to your machine path address.(Go to FileInputStream fs = new FileInputStream(PATH)) 

![image](https://media.github.ford.com/user/30776/files/295f4a09-a2e4-4551-8710-b345810f0afc)

**JENKINS MAVEN INTEGRATION**
1. in pom.xml - declare <configuration> having maven sure-fire pluggin and within configuration to have <suiteXML> aong with path of TestNG.xml file( this xml will have HLL testcases classes to be run for regression )
2. In Jenkins-> install the maven integration pluggin
3. In Jenkins Dashboard -> create a free style project 'Project Name'
4. In Jenkins advanced section -> map the project github repo or local path of project
5. In Build Section-> choose Maven Build step
6. In goal -> clean test
7. in goal specify file -> pom.xml | SAVE
8. BUILD NOW
9. verify console/build histroy

**TEST REPORTS TESTNG- JENKINS INTEGRATION**
1. In Managed Jenkins-> pluggins-> install the testNG Results pluggin
2. In Jenkins Dashboard -> create/choose a test project 
3. In Configuration> Post Build Section-> choose Maven Build step; and add post build action to Publish TESTNG result with testng-result.xml file path.( this path is inside sure-fire pluggin folder in project )
4. SAVE
5. BUILD NOW


