package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Explor_Documents;

public class Documenttestcase extends BaseTest{
  @Test
  public void Documents() {
	  driver.get("https://phptravels.net/page/travel-documents");
	  Explor_Documents Dc=new Explor_Documents(driver);
	  Dc.Documentclick();
  }
}
