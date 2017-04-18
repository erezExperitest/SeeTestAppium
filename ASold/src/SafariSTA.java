
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

import java.net.MalformedURLException;
import java.net.URL;

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
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='ios'");
//        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "safari:http://www.wikipedia.org");
//        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "safari:http://www.google.com");
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.Preferences");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(SeeTestCapabilityType.WAIT_FOR_DEVICE_TIMEOUT_MILLIS, 3000);
        driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);
    }



    @Test
    public void enterTest(){
        driver.getClient().swipe("Up", 500, 500);
        driver.findElement(By.xpath("//*[@placeholder='Settings']")).sendKeys("not");
        driver.getClient().sendText("{ENTER}");


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}