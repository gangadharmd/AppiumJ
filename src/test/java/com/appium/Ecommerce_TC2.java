package com.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Ecommerce_TC2 extends BaseTest {

    @Test

    public void apiumTest() throws MalformedURLException, InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ravi");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." + "scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

       /*String toastmessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
       Assert.assertEquals(toastmessage,"Please enter your name");*/

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if (productName.equalsIgnoreCase("Air Jordan 4 Retro")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." + "scrollIntoView(text(\"Jordan 6 Rings\"));"));

        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"))));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        // Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(), "Jordan 6 Rings");
        double amount = 0;

        for (int i = 0; i < driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size(); i++) {
            //   System.out.println(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1));
            amount = amount + formattedAmount(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText(), 1);
        }

        System.out.println(amount);

        Assert.assertEquals(formattedAmount(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText(), 2), amount);

        longPress(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.xpath("//android.widget.Button[text(),'Visit to the website to complete purchase']")).click();
        Thread.sleep(20000);
        Set<String> handles = driver.getContextHandles();
        System.out.println(handles.size());
        Iterator<String> it = handles.iterator();
        String context = it.next();
        System.out.println(context);
        context = it.next();
        System.out.println(context);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("gangadhar");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


    }

}
