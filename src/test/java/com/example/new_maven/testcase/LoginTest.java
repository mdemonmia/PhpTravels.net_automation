package com.example.new_maven.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Login;

public class LoginTest extends BaseTest{
	
  @Test(priority=1)
  public void validLogin() {
	  driver.get("https://phptravels.net/login");
	  Login alogin=new Login(driver);
	  alogin.Entermail("emonrpi@gmail.com");
	  alogin.Enterpassword("123456@");
	  alogin.isCheck();
	  alogin.SubmitLogin();
	  Assert.assertTrue(alogin.isErrorDisplay(), "Invalid credentials.");
	  
	  
  }
  
  @Test(priority=2)
  public void inValidLogin() {
	  driver.get("https://phptravels.net/login");
	  Login alogin=new Login(driver);
	  alogin.Entermail("");
	  alogin.Enterpassword("");
	  alogin.SubmitLogin();
	  
	  Assert.assertTrue(alogin.emailErrorDisplay(), "please fill out the email field.");
	  Assert.assertTrue(alogin.passErrorDisplay(), "please fill out password field");
	  
  }
  
  @Test(priority=3)
  public void inValidEmailLogin() {
	  driver.get("https://phptravels.net/login");
	  Login alogin=new Login(driver);
	  alogin.Entermail("");
	  alogin.Enterpassword("123456@");
	  alogin.isCheck();
	  alogin.SubmitLogin();
	  
	  Assert.assertTrue(alogin.emailErrorDisplay(), "please fill out the email field.");
	  
	  
  }
  
  @Test(priority=4)
  public void inValidPasswordLogin() {
	  driver.get("https://phptravels.net/login");
	  Login alogin=new Login(driver);
	  alogin.Entermail("emonrpi@gmail.com");
	  alogin.Enterpassword("");
	  alogin.isCheck();
	  alogin.SubmitLogin();
	  
	  Assert.assertTrue(alogin.passErrorDisplay(), "please fill out the email field.");   
  }
  
  @Test(priority=5)
  public void forgotPasswordvalidLogin() {
	  driver.get("https://phptravels.net/login");
	  Login alogin=new Login(driver);
	  alogin.ClickForgotpassword("emonrpi@gmail.com");
	     
  }
  
  @Test(priority=6)
  public void forgotPasswordInvalidLogin() {
	  driver.get("https://phptravels.net/login");
	  Login alogin=new Login(driver);
	  alogin.ClickForgotpassword("");
	  Assert.assertTrue(alogin.clickFpassErrorDisplay(), "Please fill out email field.");
	     
  }
  
}
