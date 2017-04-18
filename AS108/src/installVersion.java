//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class installVersion {
    private String host = "localhost";
    private int port = 8889;
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        dc.setCapability(MobileCapabilityType.UDID, "0e1f7f2fcdc5b47b1c76d07bac240d09a99fd68d");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.BrowserO:1554");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.BrowserO");
        driver = new SeeTestIOSDriver<>(new URL("http://"+host+":"+port), dc);
    }

    @Test
    public void testUntitled() {
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}