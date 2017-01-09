package performanceComparison;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class eribankAppium {

    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/erez.akri/workspace/project2";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "2";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;

//    private AppiumDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("app", "/Applications/STA/SeeTest-Trunk/bin/ipas/EriBankO.ipa");
//        capabilities.setCapability("platformName", "IOS");
//        capabilities.setCapability("udid", "36f0a41a8fca9263c1f977b915dcb5668a0b83fc");
//        capabilities.setCapability("deviceName", "Ipad");
//        capabilities.setCapability("bundleId", "com.experitest.ExperiBankO");
//        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("automationName","XCUITest");
//        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
//                + "/WebDriverAgent/Config.xcconfig");
//        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole");
//        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities)capabilities);
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='iPhone 7 B0100'");
//        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank/.LoginActivity");
        capabilities.setCapability(MobileCapabilityType.APP, "/Applications/STA/SeeTest-Trunk/bin/ipas/EriBankO.ipa");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestIOSDriver<>(new URL("http://"+host+":"+port), capabilities);

    }

    @Test
    public void test() {
//		System.out.println(driver.getPageSource());
        long startTime = System.currentTimeMillis();
        int i;
        for (i=0;i<10;i++) {
            driver.findElement(By.name("usernameTextField")).clear();
            driver.findElement(By.name("usernameTextField")).sendKeys("company");
            driver.findElement(By.name("usernameTextField")).clear();
            driver.findElement(By.name("usernameTextField")).sendKeys("company");
//            driver.findElement(By.name("passwordTextField")).clear();
//            driver.findElement(By.name("passwordTextField")).sendKeys("company");
//            driver.findElement(By.name("loginButton")).click();
//            driver.findElement(By.name("makePaymentButton")).click();
//            driver.findElement(By.name("countryButton")).click();
//            driver.findElement(By.name("Colombia")).click();
//            driver.findElement(By.name("cancelButton")).click();
//            driver.findElement(By.name("logoutButton")).click();
//        System.out.println(driver.getPageSource());
        }
        long tottalTime = (System.currentTimeMillis()-startTime)/1000;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(this.getClass().getName());
        System.out.println(i +" itarations took "+ tottalTime + " seconds");
        System.out.println("avarage time per iteration was: " + (tottalTime/i));
        System.out.println("----------------------------------------------------------------------------------");

    }

    @After
    public void tearDown() {
        driver.quit();
    }



}