package Android;//package <set your test package>;

import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class ScrollWebAndroid {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
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
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='SM-G920F'");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestAndroidDriver<SeeTestAndroidElement>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void testUntitled() {
        driver.get("http://google.com");
        if (driver.getClient().waitForElement("WEB", "id=lst-ib", 0, 30000)) {
            // If statement
        }
        driver.context("WEBVIEW_1");
        driver.findElement(By.id("lst-ib")).sendKeys("appium");
        if (driver.getClient().waitForElement("WEB", "xpath=//div[@class=\"sbico\"]", 0, 10000)) {
            // If statement
        }
        driver.findElement(By.xpath("//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='tsbb']]")).click();
        if (driver.getClient().waitForElement("WEB", "text=Mobile Testing Appium Framework - Tutorialspoint", 0, 30000)) {
            // If statement
        }
        driver.findElement(By.linkText("Mobile Testing Appium Framework - Tutorialspoint")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}