package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Explor_FAQ;

public class FAQtestcase extends BaseTest {
  @Test
  public void faq() {
	  driver.get("https://phptravels.net/page/frequently-asked-questions");
	  Explor_FAQ EF=new Explor_FAQ(driver);
	  EF.clickFAQ();
  }
}
