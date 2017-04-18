//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class _1 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "1";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='iPhone1'");
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.BrowserO");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void test_1() {
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@placeholder='Go to this address']")).sendKeys("dfgfdg");
//        driver.findElement(By.xpath("//*[@placeholder='Go to this address']")).sendKeys("");
//        driver.findElement(By.xpath("//*[@placeholder='Go to this address']")).clear();
        driver.getClient().elementSendText("NATIVE", "xpath=//*[@placeholder='Go to this address']", 0, "");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}