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

public class simple {
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
        dc.setCapability(SeeTestCapabilityType.USERNAME, "erez");
        dc.setCapability(SeeTestCapabilityType.PASSWORD, "Experitest2012");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability(SeeTestCapabilityType.PROJECT_NAME, "");
//        dc.setCapability(MobileCapabilityType.UDID, "858202");
        dc.setCapability(SeeTestCapabilityType.DEVICE_QUERY,"@os='android'");
        driver = new SeeTestAndroidDriver<>(new URL("http://192.168.4.63:8090"), dc);

    }

    @Test
    public void testUntitled() {
////        driver.installApp("D:\\Program Files (x86)\\Experitest\\AppiumStudio-10.5.24\\bin\\ipas\\eribank.apk");
////driver.startActivity("com.experitest.ExperiBank",".LoginActivity");

//        driver.deviceAction("unlock");
////
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("555555");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("gandy");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("10000");
        driver.findElement(By.xpath("//*[@id='countryTextField']")).click();
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        driver.sleep(1000);
        driver.swipeWhileNotFound(By.xpath("xpath=//*[@text='Argentina']"),730, SwipeElementDirection.DOWN,750,0,4,false);
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
        driver.get("ynet.co.il");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}