package ios;

import com.experitest.appium.SeeTestCapabilityType;
import com.experitest.appium.SeeTestIOSDriver;
import com.experitest.appium.SeeTestIOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class eribankAppiumiOS {

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

    @Ignore
    public void test() {
        ArrayList<Long> iterationsTimeList = new ArrayList<>();
        int i;
        for (i=0;i<10;i++) {
            long iterationStartTime = System.currentTimeMillis();
            driver.launchApp();
            driver.findElement(By.name("usernameTextField")).clear();
            driver.findElement(By.name("usernameTextField")).sendKeys("company");
            driver.findElement(By.name("passwordTextField")).clear();
            driver.findElement(By.name("passwordTextField")).sendKeys("company");
            driver.findElement(By.name("loginButton")).click();
            driver.findElement(By.name("makePaymentButton")).click();
            driver.findElement(By.name("countryButton")).click();
            swipeDown();
            swipeDown();
            driver.findElement(By.name("Mexico")).click();
            driver.findElement(By.name("cancelButton")).click();
            driver.findElement(By.name("logoutButton")).click();
            driver.closeApp();
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

    void swipeDown(){
        //Get the size of screen.
        Dimension size = driver.manage().window().getSize();
//        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.70);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.30);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
//        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top.
        driver.swipe(startx, starty, startx, endy, 3000);

        try {
            Thread. sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}