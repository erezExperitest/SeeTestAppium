package old;

import com.experitest.appium.SeeTestIOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class pathFullresetNoreset {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\EriBankO.ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.ExperiBankO");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new SeeTestIOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities) capabilities);


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void restart() throws Exception {
//driver.launchApp();
        driver.resetApp();
//        driver.closeApp();
//        driver.close();

        Thread.sleep(1000);


    }

    @Test
    public void launch() throws Exception {

        driver.launchApp();
        Thread.sleep(1000);
    }

    @Test
    public void close() throws Exception {
        driver.close();
        Thread.sleep(1000);
    }

}
