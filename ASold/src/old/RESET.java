package old;

import com.experitest.appium.SeeTestAndroidDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


//import org.openqa.selenium.remote.CapabilityType;


public class RESET {
    AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("app", "D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\EriBank.apk");
        capabilities.setCapability("deviceName","Emulator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.experitest.ExperiBank");
        capabilities.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET,true);
//        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        driver = new SeeTestAndroidDriver(new URL("http://127.0.0.1:8889/wd/hub"), capabilities);
    }

    @Test
    public void restart() throws Exception {
//driver.launchApp();
//        installEribank();
        org.junit.Assert.assertEquals(true,doPayment());
            driver.resetApp();
        org.junit.Assert.assertEquals(true,chackForBalanceChange());

        Thread.sleep(1000);


    }

    @Test
    public void launch() throws Exception {
//        installEribank();
//        org.junit.Assert.assertEquals(true,doPayment());
        driver.launchApp();
//        org.junit.Assert.assertEquals(true,chackForBalanceChange());

        Thread.sleep(1000);
    }

    @Ignore
    public void close() throws Exception {
//        installEribank();
//        org.junit.Assert.assertEquals(true,doPayment());
        driver.close();
//        org.junit.Assert.assertEquals(true,chackForBalanceChange());
        Thread.sleep(1000);
    }


    @After
    public void teardown(){
        //close the app
        driver.quit();
    }

 boolean doPayment() throws InterruptedException {
     driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
     driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
     driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
     Thread.sleep(1500);
//     String amount = driver.findElement(By.xpath("")).getText();
//     String a = driver.findElement(By.xpath("//*[contains(@content-desc,'Your balance is: ')]")).getText();
     try {
         driver.findElement(By.xpath("//*[@content-desc='Your balance is: 100.00$']"));
     }catch (Exception e){
         System.err.println("Balance isn't 100$ at begging of test");
         return false;
     }
//     if (driver.findElement(By.xpath("//*[@contentDescription='Your balance is: 100.00$']")){
//         System.out.println("not clean at launch");
//         Assert.assertEquals(false,true);
//     }
     driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
     driver.findElement(By.id("com.experitest.ExperiBank:id/countryButton")).click();
     driver.findElement(By.xpath("//*[@text='USA']")).click();
     driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("654");
     driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("sdfsd");
     driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("500000");
     driver.hideKeyboard();
     driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
     driver.findElement(By.id("android:id/button1")).click();
     System.err.println("------------------payment was made------------------");
     return true;
 }

 boolean chackForBalanceChange(){
     driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
     driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
     driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
     try {
         driver.findElement(By.xpath("//*[@content-desc='Your balance is: 100.00$']"));
     }catch (Exception e){
         System.err.println("Balance isn't 100$");
         return false;
     }
     System.err.println("-------------Balance 100$----------------");
     return true;
 }
 void installEribank() throws IOException {
     Runtime rt = Runtime.getRuntime();
//     rt.exec("d:");
     rt.exec("D:\\Users\\erez.akri.experitest\\AppData\\Local\\Android\\sdk\\platform-tools\\adb.exe uninstall com.experitest.ExperiBank");
     rt.exec("D:\\Users\\erez.akri.experitest\\AppData\\Local\\Android\\sdk\\platform-tools\\adb.exe install \"D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\EriBank.apk\"");
//     rt.exec("adb install \"D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\EriBank.apk\"");
 }
}
