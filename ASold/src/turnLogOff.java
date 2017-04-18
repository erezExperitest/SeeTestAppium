//package <set your test package>;

import com.experitest.appium.SeeTestAndroidDriver;
import com.experitest.appium.SeeTestAndroidElement;
import com.experitest.appium.SeeTestCapabilityType;
import com.experitest.appium.SeeTestConsoleLogLevel;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class turnLogOff {
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
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability(SeeTestCapabilityType.CONSOLE_LOG,SeeTestConsoleLogLevel.OFF);
        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), dc);
    }

    @Test
    public void testUntitled() {
        Eribank();
        driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void Eribank(){
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("555555");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("gandy");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("10000");
        driver.findElement(By.xpath("//*[@id='countryTextField']")).click();
        driver.findElement(By.xpath("//*[@text='Select']")).click();
    }
}