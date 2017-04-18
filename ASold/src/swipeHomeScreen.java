//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class swipeHomeScreen {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\appium-project";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
//        dc.setCapability(MobileCapabilityType.UDID, "668bbfe5");
//        dc.setCapability(MobileCapabilityType.UDID, "636cb7a36d429661e6be6d70e1447a66268f73ff");
        dc.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='android'");
        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), dc);
    }

    @Test
    public void testUntitled() {
        driver.swipe(100,200,220,300,500);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}