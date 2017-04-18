import java.io.File;
import java.net.URL;
import java.util.List;

import com.experitest.appium.SeeTestAndroidDriver;
import com.experitest.appium.SeeTestAndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class eribankRegularAuppium {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\appium-project";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "D:\\Program Files (x86)\\Experitest\\SeeTest-10.2\\bin\\ipas\\EriBankO.ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "636cb7a36d429661e6be6d70e1447a66268f73ff");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.ExperiBankO");
        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole");
        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws Exception {
//		System.out.println(driver.getPageSource());
            driver.findElement(By.name("usernameTextField")).clear();
            driver.findElement(By.name("usernameTextField")).sendKeys("company");
            driver.findElement(By.name("passwordTextField")).clear();
            driver.findElement(By.name("passwordTextField")).sendKeys("company");
            driver.findElement(By.name("loginButton")).click();
            driver.findElement(By.name("makePaymentButton")).click();
            driver.findElement(By.name("countryButton")).click();
            driver.findElement(By.name("Colombia")).click();
            driver.findElement(By.name("cancelButton")).click();
            driver.findElement(By.name("logoutButton")).click();
//        System.out.println(driver.getPageSource());

    }

}