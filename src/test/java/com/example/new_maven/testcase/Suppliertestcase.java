package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_supplier;

public class Suppliertestcase extends BaseTest{
  @Test(priority=1)
  public void privacy1() {
	  driver.get("https://phptravels.net/page/become-a-supplier");
	  Company_supplier Cs=new Company_supplier(driver);
	  Cs.clickSupplier();
  }
  
  @Test(priority=2)
  public void Privacy2() {
	  driver.get("https://phptravels.net/page/become-a-supplier");
	  Company_supplier Cs=new Company_supplier(driver);
	  Cs.clickPrivacy2();
  }
}
