import com.experitest.appium.SeeTestCapabilityType;
import com.experitest.appium.SeeTestIOSDriver;
import com.experitest.appium.SeeTestIOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ScrollWebIOS {
	@Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[3][0]);
    }

    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='ios'");
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "http://google.com");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void testUntitled() {
        driver.context("WEBVIEW_1");
//        driver.findElement(By.id("lst-ib")).sendKeys("dfgdfg");
//        driver.findElement(By.xpath("//div[@class=\"sbico\"]")).click();
//        driver.findElement(By.linkText("dfgdfg | Facebook")).click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}