package performanceComparison;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;



//import org.openqa.selenium.remote.CapabilityType;


public class eribank{
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "4.4.2");
        capabilities.setCapability("deviceName","Emulator");
        capabilities.setCapability("platformName","Android");


//        capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
//        capabilities.setCapability("app", "chrome");
        capabilities.setCapability("appPackage","com.experitest.ExperiBank");
        capabilities.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
//        capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testCal() throws Exception {
        //locate the Text on the calculator by using By.name()
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
//        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton"));
//        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
//        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
//        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
//        driver.findElement(By.id("com.experitest.ExperiBank:id/countryButton")).click();
//        driver.findElement(By.id("//*[@id='countryButton']")).click();
//        driver.findElement(By.linkText("Make Payment")).click();
//        driver.findElement(By.linkText("Select")).click();
//        WebElement element = driver.findElement(By.linkText("Mexico"));
//        WebElement element = driver.findElement(By.linkText("Mexico"));
        WebElement element = driver.findElement(By.id("//*[@text='Mexico']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
//        driver.findElement(By.linkText("Mexico")).click();
        driver.findElement(By.linkText("Cancel")).click();
        driver.findElement(By.linkText("Logout")).click();

    }

    @AfterClass
    public void teardown(){
        //close the app
        driver.quit();
    }

//    void swipeDown(){
//        //Get the size of screen.
//        Dimension size = driver.manage().window().getSize();
//        System.out.println(size);
//
//        //Find swipe start and end point from screen's with and height.
//        //Find starty point which is at bottom side of screen.
//        int starty = (int) (size.height * 0.80);
//        //Find endy point which is at top side of screen.
//        int endy = (int) (size.height * 0.20);
//        //Find horizontal point where you wants to swipe. It is in middle of screen width.
//        int startx = size.width / 2;
//        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
//
//        //Swipe from Bottom to Top.
//        driver.swipe(startx, starty, startx, endy, 3000);
//        Thread.sleep(2000);
//    }
//
//    void anotherSwipe(){
//        //Get the size of screen.
//        Dimension size = driver.manage().window().getSize();
//        System.out.println(size);
//
//        //Find swipe x points from screen's with and height.
//        //Find x1 point which is at right side of screen.
//        int x1 = (int) (size.width * 0.20);
//        //Find x2 point which is at left side of screen.
//        int x2 = (int) (size.width * 0.80);
//
//        //Create object of TouchAction class.
//        TouchAction action = new TouchAction((MobileDriver)driver);
//
//        //Find element to swipe from right to left.
//        WebElement ele1 =  (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/front").get(3);
//        //Create swipe action chain and perform horizontal(right to left) swipe.
//        //Here swipe to point x1 Is at left side of screen. So It will swipe element from right to left.
//        action.longPress(ele1).moveTo(x1,580).release().perform();
//
//        //Find element to swipe from left to right.
//        WebElement ele2 =  (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/back").get(3);
//        //Create swipe action chain and perform horizontal(left to right) swipe.
//        //Here swipe to point x2 Is at right side of screen. So It will swipe element from left to right.
//        action.longPress(ele2).moveTo(x2,580).release().perform();
//    }
}
