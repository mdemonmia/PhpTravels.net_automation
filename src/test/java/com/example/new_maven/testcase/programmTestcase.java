package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Support_program;

public class programmTestcase extends BaseTest {
  @Test
  public void support_Programm() {
	  driver.get("https://phptravels.net/page/affiliate-program");
	  Support_program SP=new Support_program(driver);
	  SP.Click_programm();
  }
}
