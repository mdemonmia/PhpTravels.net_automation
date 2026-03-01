package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Service_tours;

public class toursTestcase extends BaseTest{
  @Test
  public void tours_click() {
	  driver.get("https://phptravels.net/tours");
	  Service_tours St=new Service_tours(driver);
//	  St.Select_service("Dhaka");
	  St.selectStartDate("25-02-2026");
	  St.selectDuration("4-7 Days");
  }
}
