package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LongPress extends BaseTest {

    @Test

    public void gestureTest() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPress(ele);
        String menuName = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuName,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Thread.sleep(2000);


 /*       driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String settingsText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(settingsText,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Test");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();*/



    }

}
