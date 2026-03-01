package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Explor_best;

public class Besttestcase extends BaseTest {
  @Test
  public void Explorbest() {
	  driver.get("https://phptravels.net/page/best-travel-deals");
	  Explor_best Eb=new Explor_best(driver);
	  Eb.ExecutorBest();
  }
}
