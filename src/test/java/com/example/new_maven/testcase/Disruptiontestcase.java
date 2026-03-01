package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Disruption;

public class Disruptiontestcase extends BaseTest {
  @Test
  public void disruption() {
	  driver.get("https://phptravels.net/page/disruption");
	  Disruption Dd=new Disruption(driver);
	  Dd.clickInsurence();
  }
}
