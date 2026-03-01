package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.How_book;

public class bookTestcase extends BaseTest{
  @Test
  public void Bookclick() {
	  driver.get("https://phptravels.net/page/how-to-book");
	  How_book HB=new How_book(driver);
	  HB.Click_book();
  }
}
