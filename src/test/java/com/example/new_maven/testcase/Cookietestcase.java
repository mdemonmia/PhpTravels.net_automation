package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_cookie;

public class Cookietestcase extends BaseTest{
  @Test(priority=1)
  public void cookieClick1() {
	  driver.get("https://phptravels.net/page/cookies-policy");
	  Company_cookie Cc=new Company_cookie(driver);
	  Cc.Clickcookie();
  }
  
  @Test(priority=2)
  public void cookieClick2() {
	  
	  Company_cookie Cc=new Company_cookie(driver);
	  Cc.Clickcookie2();
  }
}
