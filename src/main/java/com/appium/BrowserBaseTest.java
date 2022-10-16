package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void browserInitializeDriver() throws MalformedURLException {
        service =
                new AppiumServiceBuilder().
                        withAppiumJS(
                                new File(
                                        "C:\\Users\\sony\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")
                        ).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("deviceName", "TestPhone");
        //options.setCapability("app", "C:\\Users\\sony\\AppiumJ\\src\\test\\resources\\ApiDemos-debug.apk");
      //  options.setCapability("app","C:\\\\Users\\\\sony\\\\AppiumJ\\\\src\\\\test\\\\resources\\\\General-Store.apk");
        options.setChromedriverExecutable("F:\\106\\chromedriver.exe");
        options.setCapability("browserName","Chrome");
        options.setCapability("–session-override",true);
        options.setCapability("newCommandTimeout", 100000);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



    public double formattedAmount(String s, int i){
        double d = Double.parseDouble(s.substring(i));
        return d;

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
