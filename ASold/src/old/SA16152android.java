package old;

import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class SA16152android {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project41";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA15889";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='android'");
      capabilities.setCapability(MobileCapabilityType.APP, "D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\eribank.apk");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
//      capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void testSA15889() throws InterruptedException {
        Thread.sleep(5000);
        driver.resetApp();
        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}