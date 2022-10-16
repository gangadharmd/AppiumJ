package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollDemo extends BaseTest {

    @Test

    public void scroll() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scroll by text name
        /*driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"WebView\"));"));*/
        scrollToEndAction();

        Thread.sleep(2000);

    }

}
