package performanceComparison;

import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class SA15771Android {
  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = System.getProperty("user.dir");
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "SA15771";
  protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;
  
  @Before
  public void setUp() throws MalformedURLException {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
      capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
      capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
      capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
      capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='android'");
      capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
      capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
      capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
      capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
      driver = new SeeTestAndroidDriver<SeeTestAndroidElement>(new URL("http://"+host+":"+port), capabilities);
  }
  
  @Test
  public void testSA15771() {
      System.out.println(System.getProperty("user.dir"));
      driver.getClient().openDevice();
	  String xPath = "//*[@class='android.widget.ImageView']";
	SeeTestAndroidElement findElement = driver.findElement(By.xpath(xPath));
	  String str1 = findElement.getText();
      System.out.println(str1);
  }
  
  @After
  public void tearDown() {
      driver.quit();
  }
}