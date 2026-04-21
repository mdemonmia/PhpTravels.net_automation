package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Blogs {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Blogs(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    // ✅ সরাসরি blog পেজে যাও
    public void Clickblogs() {
        driver.get("https://www.phptravels.net/page/blog");
        wait.until(ExpectedConditions.urlContains("blog"));
    }

    // ✅ Blog পেজ লোড হয়েছে কিনা চেক
    public boolean isBlogPageLoaded() {
        try {
            wait.until(ExpectedConditions.urlContains("blog"));
            return driver.getCurrentUrl().contains("blog");
        } catch (Exception e) {
            return false;
        }
    }
}


