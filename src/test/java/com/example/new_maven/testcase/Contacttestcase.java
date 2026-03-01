package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_contact;

public class Contacttestcase extends BaseTest {
	
  @Test(priority=1)
  public void Contacttest1() {
	  driver.get("https://phptravels.net/page/contact-us");
	  Company_contact Cc=new Company_contact(driver);
	  Cc.selectContact();
  }
  
  @Test(priority=2)
  public void Contacttest2() {
	  Company_contact Cc=new Company_contact(driver);
	  Cc.selectContact2();
  }
  
}
