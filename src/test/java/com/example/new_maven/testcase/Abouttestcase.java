package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_about;

public class Abouttestcase extends BaseTest{
	
  @Test(priority=1)
  public void About1() {
	  driver.get("https://phptravels.net/page/about-us");
	  Company_about Ca=new Company_about(driver);
	  Ca.aboutUsmenuClick();
  }
  
  @Test(priority=2)
  public void About2() {
	  Company_about Ca=new Company_about(driver);
	  Ca.selectAbout();
  }
}
