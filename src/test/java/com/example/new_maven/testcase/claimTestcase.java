package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Support_claim;

public class claimTestcase extends BaseTest {
  @Test
  public void clickClaim() {
	  driver.get("https://phptravels.net/page/file-a-claim");
	  Support_claim SC=new Support_claim(driver);
	  SC.Clickclaim();
  }
}
