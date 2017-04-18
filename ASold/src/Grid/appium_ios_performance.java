package Grid;//package <set your test package>;
import com.experitest.appium.*;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class appium_ios_performance {
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
        dc.setCapability(SeeTestCapabilityType.USE_REMOTE_GRID, true);
        dc.setCapability(SeeTestCapabilityType.USERNAME, "erez-user");
        dc.setCapability(SeeTestCapabilityType.PASSWORD, "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability(SeeTestCapabilityType.PROJECT_NAME, "");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\erez.akri.experitest\\AppData\\Roaming\\appiumStudio\\original-apks\\EriBankO.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBankO");
        dc.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        dc.setCapability(SeeTestCapabilityType.DEVICE_QUERY,"@os='ios' and @dhminternalhost='192.168.1.210'");
        driver = new SeeTestIOSDriver<>(new URL("https://qacloud.experitest.com:443"), dc);;
    }



    @Test
    public void testnew(){


        long startTime = System.currentTimeMillis();
        int i=1;
        long tottalTime =0;
        do {
            driver.context("NATIVE_APP");
            driver.launchApp();

        driver.findElement(By.xpath("//*[@accessibilityLabel='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).sendKeys("company");
        driver.findElement(By.xpath("xpath=//*[@text='Login']")).click();
        driver.findElement(By.xpath("xpath=//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("xpath=//*[@text='Select']")).click();
        driver.swipeWhileNotFound(By.xpath("//*[@accessibilityLabel='Colombia']"), 626, SwipeElementDirection.DOWN, 721, 0, 3, false);
        driver.findElement(By.xpath("//*[@accessibilityLabel='Colombia']")).click();
        driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Cancel']")).click();
        driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Logout']")).click();

        driver.get("http://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("expert");
            driver.getClient().sendText("{ENTER}");
            driver.swipe(SwipeElementDirection.DOWN,206,1225);
//        driver.findElement(By.xpath("xpath=//*[@nodeName='BUTTON' and ./parent::*[@nodeName='FIELDSET']]")).click();

            System.out.println("----------------------------------------------------------------------------------");
            System.err.println("This is iterantion NO.:" + (i+1));
            System.out.println("Teste time:" + tottalTime/3600);
            System.out.println("----------------------------------------------------------------------------------");

        }while ((tottalTime/3600)<4);
        tottalTime = (System.currentTimeMillis()-startTime)/1000;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(this.getClass().getName());
        System.out.println(i +" itarations took "+ tottalTime + " seconds");
        System.out.println("avarage time per iteration was: " + (tottalTime/i));
        System.out.println("----------------------------------------------------------------------------------");

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
