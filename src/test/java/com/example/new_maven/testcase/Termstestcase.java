package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_terms;

public class Termstestcase extends BaseTest {
  @Test(priority=1)
  public void Terms1() {
	  driver.get("https://phptravels.net/page/terms-of-use");
	  Company_terms Ct=new Company_terms(driver);
	  Ct.clickTerms();
  }
  
  @Test(priority=2)
  public void Terms2() {
	  driver.get("https://phptravels.net/page/terms-of-use");
	  Company_terms Ct=new Company_terms(driver);
	  Ct.clickTerms2();
  }
}
