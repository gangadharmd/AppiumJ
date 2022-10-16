package com.appium;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {

    @Test

    public void apiumTest() throws MalformedURLException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String settingsText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(settingsText,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Test");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();



    }

}
