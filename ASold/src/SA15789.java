import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class SA15789 {
  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "SA15789";
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
      capabilities.setCapability("automationName","XCUITest");
      driver = new SeeTestIOSDriver<SeeTestIOSElement>(new URL("http://"+host+":"+port), capabilities);
  }
  
  @Test
  public void testSA15789() {
      driver.context("NATIVE_APP");
      boolean displayed = driver.findElement(By.className("XCUIElementTypeTextField")).isDisplayed();
      
      System.out.println(displayed);
  }
  
  @After
  public void tearDown() {
      driver.quit();
  }
}