package com.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Miscellaneous extends BaseTest {

    @Test

    public void practice() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
        driver.findElements(AppiumBy.className("android.widget.CheckedTextView")).get(3).click();



    }

}
