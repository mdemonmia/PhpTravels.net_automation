package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signup {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public signup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    // ✅ মেনু ক্লিক বাদ দিয়ে সরাসরি register পেজে যাও
    public void customerSignup() {
        driver.get("https://www.phptravels.net/register");
        wait.until(ExpectedConditions.urlContains("register"));
    }

    public void enterName(String firstName, String lastName) {
        WebElement firstUser = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("first_name")));
        firstUser.clear();
        if (firstName != null && !firstName.trim().isEmpty()) {
            firstUser.sendKeys(firstName);
        }

        WebElement lastUser = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("last_name")));
        lastUser.clear();
        if (lastName != null && !lastName.trim().isEmpty()) {
            lastUser.sendKeys(lastName);
        }
    }

    public void contactEmail(String email) {
        WebElement mail = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("email")));
        mail.clear();
        if (email != null && !email.trim().isEmpty()) {
            mail.sendKeys(email);
        }
    }

    public void Password(String pwd) {
        WebElement password = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("password")));
        password.clear();
        if (pwd != null && !pwd.trim().isEmpty()) {
            password.sendKeys(pwd);
        }
    }

    public void confirmPassword(String Cpwd) {
        WebElement cpwd = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("confirm_password")));
        cpwd.clear();
        if (Cpwd != null && !Cpwd.trim().isEmpty()) {
            cpwd.sendKeys(Cpwd);
        }
    }

    public void isCheck() {
        WebElement check = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='terms']")));
        if (!check.isSelected()) {
            js.executeScript("arguments[0].click();", check);
        }
    }

    public void CreateAccountSubmit() {
        WebElement CA = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@x-show='!isSubmitting'] | //button[@type='submit']")));
        js.executeScript("arguments[0].click();", CA);
    }

    public boolean FirstnameErrorDisplay() {
        try {
            WebElement firstError = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(
                        "//*[contains(text(),'First Name') or contains(text(),'first name')]")));
            return firstError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean LastnameErrorDisplay() {
        try {
            WebElement lastError = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(
                        "//*[contains(text(),'Last Name') or contains(text(),'last name')]")));
            return lastError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean emailErrorDisplay() {
        try {
            WebElement emailError = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(
                        "//*[contains(text(),'Email') or contains(text(),'email')]")));
            return emailError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean pwdErrorDisplay() {
        try {
            WebElement pwdError = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(
                        "//*[contains(text(),'Password') or contains(text(),'password')]")));
            return pwdError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean confirmpwdErrorDisplay() {
        try {
            WebElement confError = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(
                        "//*[contains(text(),'Confirm Password') or contains(text(),'confirm password')]")));
            return confError.isDisplayed();
        } catch (Exception e) {
            System.out.println("Blank confirm password.");
        }
        return false;
    }
}