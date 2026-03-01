package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Explor_insurence;

public class Insurencetestcase extends BaseTest {
  @Test
  public void clickInsurence() {
	  driver.get("https://phptravels.net/page/travel-insurance");
	  Explor_insurence Ei= new Explor_insurence(driver);
	  Ei.clickInsurence();
  }
}
