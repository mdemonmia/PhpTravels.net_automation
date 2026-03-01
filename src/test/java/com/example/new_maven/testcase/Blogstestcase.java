package com.example.new_maven.testcase;

import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Blogs;

public class Blogstestcase extends BaseTest{
  @Test
  public void Blogstest() {
	  driver.get("https://phptravels.net/page/blog");
	  Blogs Bb=new Blogs(driver);
	  Bb.Clickblogs();
  }
}
