package iOS;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class eribankAuppiumiOSinstrumented {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;


    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "D:\\Program Files (x86)\\Experitest\\SeeTest-10.3\\bin\\ipas\\EriBank.ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "ee311eac774e828a2b3869047e3ec1abb78f16ef");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.ExperiBank");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole");
        driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws Exception {
            driver.findElement(By.xpath("//*[@placeholder='Username']")).clear();
            driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).clear();
        driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).sendKeys("company");
            driver.findElement(By.xpath("//*[@text='Login']")).click();
            driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
            driver.findElement(By.xpath("//*[@text='Select']")).click();
            driver.findElement(By.xpath("//*[@accessibilityLabel='Colombia']")).click();
            driver.findElement(By.xpath("//*[@text='Cancel']")).click();
            driver.findElement(By.xpath("//*[@text='Logout']")).click();

    }

}