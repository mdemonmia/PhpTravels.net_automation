package com.example.new_maven.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.signup;

public class signupTestcase extends BaseTest {
	
	
  @Test(priority=1)
  public void signupTest() throws InterruptedException {
	  
	  driver.get("https://phptravels.net/signup");
	  //driver.get("https://demoqa.com/login");
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("Emon", "Mia");
	  SU.contactEmail("emonrpi@gmail.com");
	  SU.Password("123456@");
	  SU.confirmPassword("123456@");
	  Thread.sleep(5000);
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  
  }
  
  @Test(priority=2)
  public void blankallSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("", "");
	  SU.contactEmail("");
	  SU.Password("");
	  SU.confirmPassword("");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  
	  Assert.assertTrue(SU.FirstnameErrorDisplay(), "please fill out the firstname field.");
	  Assert.assertTrue(SU.LastnameErrorDisplay(), "please fill out the lastname field.");
	  Assert.assertTrue(SU.emailErrorDisplay(), "please fill out the email field.");
	  Assert.assertTrue(SU.pwdErrorDisplay(), "please fill out the password field.");
	  Assert.assertTrue(SU.confirmpwdErrorDisplay(), "please fill out the confirm field.");
	  }
  
  @Test(priority=3)
  public void invalidFirstnameSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("", "Mia");
	  SU.contactEmail("emonrpi@gmail.com");
	  SU.Password("@123456@");
	  SU.confirmPassword("@123456@");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  Assert.assertTrue(SU.FirstnameErrorDisplay(), "please fill out the firstname field.");
  }
	  
  @Test(priority=4)
  public void invalidlastnameSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("Emon", "");
	  SU.contactEmail("emonrpi@gmail.com");
	  SU.Password("@123456@");
	  SU.confirmPassword("@123456@");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  Assert.assertTrue(SU.LastnameErrorDisplay(), "please fill out the lastname field.");
  }
  
  @Test(priority=5)
  public void invalidEmailSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("Emon", "Mia");
	  SU.contactEmail("");
	  SU.Password("@123456@");
	  SU.confirmPassword("@123456@");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  Assert.assertTrue(SU.emailErrorDisplay(), "please fill out the email field.");
  }
  
  @Test(priority=6)
  public void invalidEmailmissingSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("Emon", "Mia");
	  SU.contactEmail("emonrpi");
	  SU.Password("@123456@");
	  SU.confirmPassword("@123456@");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  Assert.assertTrue(SU.emailErrorDisplay(), "please include @ in the email address. missing @ in the email address.");
  }
  
  @Test(priority=7)
  public void invalidPasswordSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("Emon", "Mia");
	  SU.contactEmail("emonrpi@gmail.com");
	  SU.Password("");
	  SU.confirmPassword("@123456@");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  Assert.assertTrue(SU.emailErrorDisplay(), "please fill out the password field.");
  }
  
  @Test(priority=8)
  public void invalidConfirmpasswordSignup() {
	  driver.get("https://phptravels.net/signup"); 
	  signup SU=new signup(driver);
	  SU.customerSignup();
	  SU.enterName("Emon", "Mia");
	  SU.contactEmail("emonrpi@gmail.com");
	  SU.Password("@123456@");
	  SU.confirmPassword("");
	  SU.isCheck();
	  SU.CreateAccountSubmit();
	  Assert.assertTrue(SU.emailErrorDisplay(), "please fill out the confirm password field.");
  }
  
}
