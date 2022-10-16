package com.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class BrowserTest extends BrowserBaseTest {

    @Test

    public void apiumTest() throws MalformedURLException, InterruptedException {

        driver.get("http://google.com");
      //  Thread.sleep(20000);
        driver.findElement(By.name("q")).sendKeys("gangadhar");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

    }

}
