package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Support_investor;

public class Investors extends BaseTest{
  @Test
  public void investortest() {
	  driver.get("https://phptravels.net/page/investors");
	  Support_investor SI=new Support_investor(driver);
	  SI.clickInvestors();
  }
}
