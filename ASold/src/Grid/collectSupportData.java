package Grid;//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class collectSupportData {
    private String host = "localhost";
    private int port = 8889;
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        dc.setCapability(SeeTestCapabilityType.USE_REMOTE_GRID, true);
        dc.setCapability(SeeTestCapabilityType.USERNAME, "erez-user");
        dc.setCapability(SeeTestCapabilityType.PASSWORD, "Experitest2012");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability(SeeTestCapabilityType.PROJECT_NAME, "");
//        dc.setCapability(MobileCapabilityType.UDID, "858202");
        dc.setCapability(SeeTestCapabilityType.DEVICE_QUERY,"@os='android' and @dhminternalhost='192.168.1.210'");
        driver = new SeeTestAndroidDriver<>(new URL("https://qacloud.experitest.com:443"), dc);

    }

    @Test
    public void testUntitled() {

        String file = driver.getClient().collectSupportData("","",driver.getClient().getDeviceProperty("device.name"),"d","d","d");
        try {
            driver.getClient().getRemoteFile(file,10000,"C:\\Users\\erez.akri.experitest\\Desktop\\");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}