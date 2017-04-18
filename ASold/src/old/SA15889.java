package old;

import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class SA15889 {
  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project41";
    private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "SA15889";
  protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;
  
  @Before
  public void setUp() throws MalformedURLException {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
      capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
      capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
      capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
      capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@os='android'");
//      capabilities.setCapability(MobileCapabilityType.APP, "D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\eribank.apk");
      capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
//      capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
      capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

      driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), capabilities);
  }
  
  @Test
  public void testSA15889() {
      driver.context("NATIVE_APP");
      driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
      driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
      driver.findElement(By.xpath("//*[@id='loginButton']")).click();
      driver.findElement(By.xpath("//*[@contentDescription='Your balance is: 100.00$']"));
      driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
      driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys("087423687143");
      driver.findElement(By.xpath("//*[@text='Name']")).sendKeys("Eyal");
      driver.findElement(By.xpath("//*[@text='Amount']")).sendKeys("50");
      driver.findElement(By.xpath("//*[@text='Select']")).click();
      driver.findElement(By.xpath("//*[@text='USA']")).click();
      driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
      driver.findElement(By.xpath("//*[@text='Yes']")).click();
      driver.findElement(By.xpath("//*[@contentDescription='Your balance is: 50.00$']"));
      driver.findElement(By.xpath("//*[@id='logoutButton']")).click();
/*      driver.resetApp();
      driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
      driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
      driver.findElement(By.xpath("//*[@id='loginButton']")).click();
      driver.findElement(By.xpath("//*[@contentDescription='Your balance is: 100.00$']"));*/

      
      
      
  }
  
  @After
  public void tearDown() {
      driver.quit();
  }
}