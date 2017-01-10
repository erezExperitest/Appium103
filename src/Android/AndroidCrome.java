package Android;

/**
 * Created by erez.akri on 09-Jan-17.
 */
//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidCrome {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "3";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='SM-G920F'");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new SeeTestAndroidDriver<SeeTestAndroidElement>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void test_3() {
        if (driver.getClient().waitForElement("WEB", "id=searchInput", 0, 10000)) {
            // If statement
        }
        driver.context("WEBVIEW_1");
        driver.get("http://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).sendKeys("jerusalem");
        driver.getClient().sendText("{ENTER}");
        if (driver.getClient().swipeWhileNotFound("Down", 0, 2000, "WEB", "xpath=//*[@text='holy city']", 1000, 5, true)) {
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}