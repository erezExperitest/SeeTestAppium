

import com.experitest.appium.SeeTestAndroidDriver;
import com.experitest.appium.SeeTestAndroidElement;
import com.experitest.appium.SeeTestCapabilityType;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class remoteAS {
    private String host = "192.168.2.35";
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
//        dc.setCapability(MobileCapabilityType.APP,"D:\\Program Files (x86)\\Experitest\\AppiumStudio-10.5.24\\bin\\ipas\\eribank.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability(SeeTestCapabilityType.WAIT_FOR_DEVICE_TIMEOUT_MILLIS, 30000);
        dc.setCapability(SeeTestCapabilityType.DEVICE_QUERY,"@os='android'");
        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), dc);

    }

    @Test
    public void testUntitled() {
        driver.unlockDevice();

        long startTime = System.currentTimeMillis();
        int i=1;
        long tottalTime =0;
        do {
            driver.context("NATIVE_APP");
            driver.unlockDevice();
            driver.launchApp();
            driver.unlockDevice();
            driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
            driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
            driver.findElement(By.xpath("//*[@text='Login']")).click();
            driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
            driver.findElement(By.xpath("//*[@text='Select']")).click();
            driver.swipeWhileNotFound(By.xpath("xpath=//*[@text='Argentina']"),730, SwipeElementDirection.DOWN,750,0,4,false);
            driver.findElement(By.xpath("//*[@text='Argentina']")).click();
            driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
            driver.findElement(By.xpath("xpath=//*[@text='Cancel']")).click();
            driver.findElement(By.xpath("//*[@text='Logout']")).click();

            driver.get("http://www.wikipedia.org");
            driver.context("WEB");
            driver.sleep(10000);
            driver.findElement(By.id("searchInput")).sendKeys("expert");
            driver.getClient().sendText("{ENTER}");
            driver.swipe(SwipeElementDirection.DOWN,206,1225);
            System.out.println("----------------------------------------------------------------------------------");
            System.err.println("This is iterantion NO.:" + i);
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
    public void tearDown() {
        driver.quit();
    }
}