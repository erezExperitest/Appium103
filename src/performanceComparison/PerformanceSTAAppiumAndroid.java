package performanceComparison; /**
 * Created by erez.akri on 05-Jan-17.
 */
//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

public class PerformanceSTAAppiumAndroid {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='android'");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestAndroidDriver<SeeTestAndroidElement>(new URL("http://"+host+":"+port), capabilities);
//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testUntitled() {
        driver.context("NATIVE_APP");
        long startTime = System.currentTimeMillis();
        int i;
        for (i=0;i<1;i++) {
            driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
            driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
            driver.findElement(By.linkText("Login")).click();
            driver.findElement(By.linkText("Make Payment")).click();
            driver.findElement(By.linkText("Select")).click();
            driver.getClient().elementListSelect("", "text=Mexico", 0, false);
            driver.findElement(By.linkText("Mexico")).click();
            driver.findElement(By.linkText("Cancel")).click();
            driver.findElement(By.linkText("Logout")).click();
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