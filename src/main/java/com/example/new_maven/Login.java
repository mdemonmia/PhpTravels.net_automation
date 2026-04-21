package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    // ✅ সরাসরি login পেজে যাও — মেনু ক্লিকের দরকার নেই
    public void LoginClick() {
        driver.get("https://www.phptravels.net/login");
        wait.until(ExpectedConditions.urlContains("login"));
    }

    public void Entermail(String email) {
        // ✅ login পেজে navigate করো
        driver.get("https://www.phptravels.net/login");
        
        WebElement mail = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='email' or @name='email' or @type='email']")));
        mail.clear();
        if (email != null && !email.trim().isEmpty()) {
            mail.sendKeys(email);
        } else {
            System.out.println("Blank email.");
        }
    }

    public void Enterpassword(String pwd) {
        WebElement passwd = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='password' or @name='password' or @type='password']")));
        passwd.clear();
        if (pwd != null && !pwd.trim().isEmpty()) {
            passwd.sendKeys(pwd);
        } else {
            System.out.println("Blank password");
        }

        // ✅ toggle password বাটন না থাকলে skip করবে
        try {
            WebElement showPass = driver.findElement(By.xpath("//span[@id='toggle-password']"));
            if (showPass.isDisplayed()) {
                js.executeScript("arguments[0].click();", showPass);
            }
        } catch (Exception e) {
            System.out.println("Toggle password button not found, skipping.");
        }
    }

    public void isCheck() {
        try {
            WebElement check = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[normalize-space()='Remember Me'] | //input[@name='remember']")));
            js.executeScript("arguments[0].click();", check);
        } catch (Exception e) {
            System.out.println("Remember Me checkbox not found, skipping.");
        }
    }

    public void ClickForgotpassword(String cmail) {
        // ✅ সরাসরি forgot password পেজে যাও
        driver.get("https://www.phptravels.net/forgot-password");
        
        WebElement enterMail = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='email' or @name='email' or @type='email']")));
        enterMail.clear();
        if (cmail != null && !cmail.trim().isEmpty()) {
            enterMail.sendKeys(cmail);
        }

        WebElement Fsubmit = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit'] | //input[@type='submit']")));
        js.executeScript("arguments[0].click();", Fsubmit);
    }

    public void SubmitLogin() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@x-show='!isSubmitting'] | //button[@type='submit']")));
        js.executeScript("arguments[0].click();", submit);
    }

    // ✅ Valid login এর পর dashboard/account পেজে redirect হয়েছে কিনা চেক করো
    public boolean isLoggedIn() {
        try {
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("account"),
                ExpectedConditions.urlContains("dashboard"),
                ExpectedConditions.urlContains("profile"),
                ExpectedConditions.urlContains("phptravels.net/en")
            ));
            return true;
        } catch (Exception e) {
            System.out.println("Login failed - not redirected.");
            return false;
        }
    }

    // ✅ Invalid credentials error message চেক
    public boolean isErrorDisplay() {
        try {
            WebElement Errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Invalid') or contains(text(),'invalid') " +
                         "or contains(text(),'incorrect') or contains(text(),'Incorrect') " +
                         "or contains(text(),'wrong') or contains(text(),'Wrong')]")));
            return Errormsg.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error message not displayed.");
            return false;
        }
    }

    // ✅ Email field এ validation error আছে কিনা চেক
    public boolean emailErrorDisplay() {
        try {
            WebElement errorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='email' or @name='email']")));
            // field empty থাকলে browser validation দেখাবে
            String validationMsg = (String) js.executeScript(
                "return arguments[0].validationMessage;", errorEmail);
            System.out.println("Email validation message: " + validationMsg);
            return validationMsg != null && !validationMsg.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Password field এ validation error আছে কিনা চেক
    public boolean passErrorDisplay() {
        try {
            WebElement errorPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='password' or @name='password']")));
            String validationMsg = (String) js.executeScript(
                "return arguments[0].validationMessage;", errorPwd);
            System.out.println("Password validation message: " + validationMsg);
            return validationMsg != null && !validationMsg.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Forgot password পেজে email field আছে কিনা চেক
    public boolean clickFpassErrorDisplay() {
        try {
            WebElement Fpwd = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='email' or @name='email' or @type='email']")));
            return Fpwd.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}