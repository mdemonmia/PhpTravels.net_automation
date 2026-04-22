package com.example.new_maven.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.new_maven.BaseTest;
import com.example.new_maven.Login;

public class LoginTest extends BaseTest {

    // ✅ driver.get() বাদ দিলাম — Entermail() নিজেই navigate করবে

//    @Test(priority = 1)
//    public void validLogin() {
//    	driver.get("https://www.phptravels.net/login");
//        Login alogin = new Login(driver);
//        
//        alogin.Entermail("emonrpi@gmail.com");
//        alogin.Enterpassword("123456@");
//        alogin.isCheck();
//        alogin.SubmitLogin();
//        // ✅ error check নয়, login success চেক করো
//        Assert.assertTrue(alogin.isLoggedIn(), "Invalid credentials.");
//    }

    @Test(priority = 2)
    public void inValidLogin() {
    	driver.get("https://www.phptravels.net/login");
        Login alogin = new Login(driver);
//        alogin.LoginClick();
        alogin.Entermail("");
        alogin.Enterpassword("");
        alogin.SubmitLogin();

        Assert.assertTrue(alogin.emailErrorDisplay(), "please fill out the email field.");
       
    }

    @Test(priority = 3)
    public void inValidEmailLogin() {
    	driver.get("https://www.phptravels.net/login");
        Login alogin = new Login(driver);
//        alogin.LoginClick();
        alogin.Entermail("");
        alogin.Enterpassword("123456@");
        alogin.isCheck();
        alogin.SubmitLogin();

        Assert.assertTrue(alogin.emailErrorDisplay(), "please fill out the email field.");
    }

    @Test(priority = 4)
    public void inValidPasswordLogin() {
    	driver.get("https://www.phptravels.net/login");
        Login alogin = new Login(driver);
//        alogin.LoginClick();
        alogin.Entermail("user@phptravels.com");
        alogin.Enterpassword("");
        alogin.isCheck();
        alogin.SubmitLogin();

        Assert.assertTrue(alogin.passErrorDisplay(), "please fill out the password field.");
    }

    @Test(priority = 5)
    public void forgotPasswordvalidLogin() {
    	driver.get("https://www.phptravels.net/login");
        Login alogin = new Login(driver);
//        alogin.LoginClick();
        // ✅ ClickForgotpassword নিজেই forgot-password পেজে যাবে
        alogin.ClickForgotpassword("user@phptravels.com");
    }
//
    @Test(priority = 6)
    public void forgotPasswordInvalidLogin() {
    	driver.get("https://www.phptravels.net/login");
        Login alogin = new Login(driver);
//        alogin.LoginClick();
        alogin.ClickForgotpassword("");
        Assert.assertTrue(alogin.clickFpassErrorDisplay(), "Please fill out email field.");
    }
}