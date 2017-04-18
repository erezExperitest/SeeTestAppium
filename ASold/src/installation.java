//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class installation {
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
        dc.setCapability(MobileCapabilityType.UDID, "cbc20b1088c65f4a27dca70b158843f69f249a64");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\erez.akri.experitest\\AppData\\Roaming\\appiumStudio\\apk\\com.experitest.ExperiBank.1.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
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