import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class nativeContext_SA17090_ios {
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
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\erez.akri.experitest\\AppData\\Roaming\\appiumstudio\\original-apks\\EriBankO.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
//        dc.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        driver = new SeeTestIOSDriver<>(new URL("http://"+host+":"+port), dc);
    }

    @Test
    public void testUntitled() {
            testActual();
//            testActual();

    }

    public void testActual()  {
        try {
//            System.out.println(driver.getContext());
//            driver.context("NATIVE_APP_INSTRUMENTED");
//            //non-instrumented xpath
//            driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='passwordTextField']")).sendKeys("a");
//            driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='passwordTextField']")).clear();
            //instrumented xpath
//            driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Password']")).sendKeys("a");
//            driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='passwordTextField']")).clear();

            driver.launchApp("com.experitest.ExperiBank");
//            driver.context("NATIVE_APP");
            System.out.println(driver.getContext());
            System.out.println(driver.getContextHandles());
            //instrumented xpath
            driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='passwordTextField']")).sendKeys("a");
//            driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Password']")).sendKeys("a");
            //non-instrumented xpath
//        driver.findElement(By.xpath("//*[@accessibilityLabel='usernameTextField']")).click();
//        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("a");
        }catch (Exception e){}
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
}