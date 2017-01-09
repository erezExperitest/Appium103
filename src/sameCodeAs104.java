//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class sameCodeAs104 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "1";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_QUERY, "@name='SM-G920F'");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G920F");
//        capabilities.setCapability(MobileCapabilityType.APP, "com.android.chrome");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='SM-G920F'");

        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void test_1() {
        driver.getClient().click("NATIVE", "xpath=//*[@id='location_bar']", 0, 1);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}