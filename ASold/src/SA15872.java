import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

public class SA15872 {
  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "SA15872";
  protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;
  
  @Before
  public void setUp() throws MalformedURLException {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
      capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
      capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
      capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
      capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='ios'");
      capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBankO");
      capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
      capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//      capabilities.setCapability("automationName","XCUITest");
//      capabilities.setCapability("automationName","UIautomation");
      driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);
  }
  
  @Test
  public void testSA15872() {
      driver.context("NATIVE_APP");
      driver.findElement(By.xpath("//*[@name='usernameTextField']")).sendKeys("sdfgsdf");
//      String type = login.getAttribute("type");
//      System.out.println("Type : "+type);
//      assertEquals(type,"XCUIElementTypeButton");
  }
  
  @After
  public void tearDown() {
      driver.quit();
  }
}