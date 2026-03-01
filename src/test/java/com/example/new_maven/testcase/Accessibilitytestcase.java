package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Explor_accessbility;

public class Accessibilitytestcase extends BaseTest {
  @Test
  public void accessibilityClick() {
	  driver.get("https://phptravels.net/page/accessibility");
	  Explor_accessbility Ea=new Explor_accessbility(driver);
	  Ea.clickAccessibility();
  }
}
