package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Company_about {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Company_about(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.js = (JavascriptExecutor) driver;
    }

    // ✅ সরাসরি About Us পেজে যাও
    public void aboutUsmenuClick() {
        driver.get("https://www.phptravels.net/page/about-us");
        wait.until(ExpectedConditions.urlContains("about-us"));
    }

    // ✅ About Us পেজ লোড হয়েছে কিনা চেক করো
    public boolean isAboutPageLoaded() {
        try {
            wait.until(ExpectedConditions.urlContains("about-us"));
            return driver.getCurrentUrl().contains("about-us");
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ selectAbout — সরাসরি URL দিয়ে navigate
    public void selectAbout() {
        driver.get("https://www.phptravels.net/page/about-us");
        wait.until(ExpectedConditions.urlContains("about-us"));
    }
}