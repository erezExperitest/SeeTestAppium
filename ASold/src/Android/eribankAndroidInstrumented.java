package Android;//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class eribankAndroidInstrumented {
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
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new SeeTestAndroidDriver<SeeTestAndroidElement>(new URL("http://"+host+":"+port), capabilities);
    }

    @Test
    public void testUntitled() {
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.linkText("Make Payment")).click();
        driver.findElement(By.linkText("Select")).click();
//        driver.getClient().elementListSelect("", "text=Colombia", 0, false);
        driver.findElement(By.linkText("Colombia")).click();
        driver.findElement(By.linkText("Cancel")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}