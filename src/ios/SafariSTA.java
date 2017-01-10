package ios;

/**
 * Created by erez.akri on 1/10/17.
 */
//package <set your test package>;

import com.experitest.appium.SeeTestCapabilityType;
import com.experitest.appium.SeeTestIOSDriver;
import com.experitest.appium.SeeTestIOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class SafariSTA {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/erez.akri/workspace/project2";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "2";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='iPhone 7 B0100'");
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "safari:http://www.wikipedia.org");
//        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "safari:http://www.google.com");
//        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.Preferences");
//        capabilities.setCapability(IOSMobileCapabilityType.BROWSER_NAME, "safari");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void test_2() {
        ArrayList<Long> iterationsTimeList = new ArrayList<>();
        int i;
        for (i=0;i<10;i++) {
            long iterationStartTime = System.currentTimeMillis();
        driver.context("WEBVIEW");
        driver.findElement(By.id("searchInput")).sendKeys("jerusalem");
        if (driver.getClient().waitForElement("WEB", "text=Jerusalem", 0, 10000)) {
            // If statement
        }
        driver.findElement(By.linkText("Jerusalem")).click();
        if (driver.getClient().waitForElement("WEB", "text=UNESCO World Heritage Site", 0, 30000)) {
            // If statement
        }
        driver.findElement(By.linkText("UNESCO World Heritage Site")).click();
            long iterationEndTime = System.currentTimeMillis();
            long iterationTime = iterationEndTime - iterationStartTime;
            System.out.println("Iteration No. " + i + " took: " + iterationTime / 1000 + " seconds");
            iterationsTimeList.add(iterationTime);
        }
        long totalrunningTime = iterationsTimeList.stream().mapToLong(Long::longValue).sum() / 1000;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(this.getClass().getName());
        System.out.println(i + " itarations took " + totalrunningTime + " seconds");
        System.out.println("avarage time per iteration was: " + (totalrunningTime / i) + " seconds");
        System.out.println("----------------------------------------------------------------------------------");
    }


    @Test
    public void googleImage(){
        ArrayList<Long> iterationsTimeList = new ArrayList<>();
        int i;
        for (i=0;i<10;i++) {
            long iterationStartTime = System.currentTimeMillis();
        driver.context("WEBVIEW_1");
        driver.get("http://www.google.com");
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).sendKeys("experitest");
        driver.findElement(By.xpath("//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='tsbb']]")).click();
//        driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
//        driver.getClient().sendText("{ENTER}");

        if (driver.getClient().waitForElement("WEB", "text=תמונות", 0, 30000)) {
            // If statement
            driver.findElement(By.linkText("תמונות")).click();
        }
//        if (driver.getClient().waitForElement("WEB", "//*[@nodeName='A' and ./*[@name='1tqX0q1YsulfuM:']]", 0, 30000))
//            driver.findElement(By.xpath("//*[@nodeName='A' and ./*[@name='1tqX0q1YsulfuM:']]")).click();
        long iterationEndTime = System.currentTimeMillis();
        long iterationTime = iterationEndTime - iterationStartTime;
        System.out.println("Iteration No. " + i + " took: " + iterationTime / 1000 + " seconds");
        iterationsTimeList.add(iterationTime);
    }
    long totalrunningTime = iterationsTimeList.stream().mapToLong(Long::longValue).sum() / 1000;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(this.getClass().getName());
        System.out.println(i + " itarations took " + totalrunningTime + " seconds");
        System.out.println("avarage time per iteration was: " + (totalrunningTime / i) + " seconds");
        System.out.println("----------------------------------------------------------------------------------");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}