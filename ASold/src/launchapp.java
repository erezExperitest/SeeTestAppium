import com.experitest.appium.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.junit.*;
import java.net.URL;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

public class launchapp {
    private String host = "localhost";
    private int port = 8889;
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    private String bundle = "com.experitest.ExperiBank";
    private String springboardIdentifier = "xpath=//*[contains(@contentDescription,'App') or contains(@contentDescription,'apps')  or @contentDescription='Xperia™ Home' or @id='workspace']";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        dc.setCapability(MobileCapabilityType.UDID, "LGD85589b241b0");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\erez.akri.experitest\\AppData\\Roaming\\appiumstudio\\original-apks\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        dc.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, true);
        driver = new SeeTestAndroidDriver<>(new URL("http://"+host+":"+port), dc);
    }

    @Test
    public void testUntitled() {

//    	System.out.println(driver.currentActivity());
//    	Assert.assertEquals(driver.currentActivity(), ".LoginActivity");
//    	
//    	driver.closeApp();
//    	driver.findElement(By.xpath(springboardIdentifier));


        driver.launchApp();
        Assert.assertEquals(driver.currentActivity(), ".LoginActivity");


//    	makePayment();
//    	driver.resetApp();
//    	login();
//    	Assert.assertEquals("50.00$", getBalance());
//    	driver.resetApp();
//    	
//    	driver.closeApp();
//    	driver.launchApp();
//    	login();
//    	Assert.assertEquals("100.00$", getBalance());
//    	
//    	driver.removeApp(bundle);
//    	Assert.assertFalse("App was not removed correctly", driver.getClient().getInstalledApplications().contains(bundle));
//    	
//    	driver.installApp(bundle);
//    	Assert.assertFalse("App was not installed correctly", driver.getClient().getInstalledApplications().contains(bundle));

    }
    private String getBalance(){
        return driver.findElement(By.xpath("//*[@nodeName='H1']")).getText().split(":")[0];
    }

    private void makePayment(){

        login();


        driver.getClient().waitForElement("NATIVE", "//*[@id='makePaymentButton']", 0, 10000);
        WebElement makePayment = driver.findElement(By.xpath("//*[@text='Make Payment']"));
        makePayment.click();

        driver.getClient().waitForElement("NATIVE", "//*[@hint='Phone']", 0, 10000);
        driver.findElement(By.xpath("//*[@hint='Phone']")).sendKeys("55151");
        driver.hideKeyboard();

        driver.findElement(By.xpath("//*[@hint='Name']")).sendKeys("app manager");
        driver.hideKeyboard();

        driver.findElement(By.xpath("//*[@hint='Amount']")).sendKeys("100");
        driver.hideKeyboard();

        WebElement selectCountry = driver.findElement(By.xpath("//*[@id='countryButton']"));
        selectCountry.click();

        driver.findElement(By.xpath("//*[@text='New Zealand']")).click();

        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();

        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }

    private void login() {

        driver.closeApp();
        driver.launchApp();

        WebElement userName = driver.findElement(By.xpath("//*[@id='usernameTextField']"));
        userName.sendKeys("company");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id='passwordTextField']"));
        passwordField.sendKeys("company");

        WebElement loginElement = driver.findElement(By.xpath("//*[@id='loginButton']"));
        loginElement.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}