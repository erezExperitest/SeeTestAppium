//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class nativeContext_SA17090_ANDROID {
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
        dc.setCapability(MobileCapabilityType.UDID, "daeb0cf1");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\erez.akri.experitest\\AppData\\Roaming\\appiumstudio\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
//        dc.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), dc);
    }

    @Test
    public void testUntitled() {
        testActual();
//            testActual();

    }

    public void testActual()  {
        try {
            driver.context("NATIVE_APP");
            System.out.println(driver.getContext());
            System.out.println(driver.getContextHandles());
            driver.context("NATIVE_APP_INSTRUMENTED");
            driver.getClient().setShowReport(false);
            String bla = driver.getContextHandles().toString();
            System.out.println(bla);
            driver.getClient().setShowReport(true);
            driver.getClient().report("getContextHandles result:"+bla,true);

            //instrumented xpath
//            driver.findElement(By.xpath("xpath=//*[@hint='Password']")).sendKeys("a");
//            driver.findElement(By.xpath("xpath=//*[@hint='Password']")).clear();
            //non-instrumented xpath
//            driver.findElement(By.xpath("xpath=//*[@id='passwordTextField']")).sendKeys("a");
//            driver.findElement(By.xpath("xpath=//*[@id='passwordTextField']")).clear();
        }catch (Exception e){}
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}