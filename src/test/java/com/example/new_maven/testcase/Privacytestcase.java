package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_privacy;

public class Privacytestcase extends BaseTest {
  @Test(priority=1)
  public void Privacytest1() {
	  driver.get("https://phptravels.net/page/privacy-policy");
	  Company_privacy Cp=new Company_privacy(driver);
	  Cp.clickPrivacy();
  }
  
  @Test(priority=2)
  public void Privacytest2() {
	  
	  Company_privacy Cp=new Company_privacy(driver);
	  Cp.privacyClick2();
  }
}
