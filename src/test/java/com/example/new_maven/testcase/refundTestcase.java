package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Support_refund;

public class refundTestcase extends BaseTest{
  @Test
  public void refund_Click() {
	  driver.get("https://phptravels.net/page/refund-policy");
	  Support_refund SR=new Support_refund(driver);
	  SR.Click_refund();
  }
}
