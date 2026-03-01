package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Support_career;

public class careerTestcase extends BaseTest {
  @Test
  public void careerJobs() {
	  driver.get("https://phptravels.net/page/careers-and-jobs");
	  Support_career Sc=new Support_career(driver);
	  Sc.click_Career();
  }
}
