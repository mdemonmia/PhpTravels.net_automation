package com.example.new_maven.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.new_maven.BaseTest;
import com.example.new_maven.Blogs;

public class Blogstestcase extends BaseTest {

    @Test
    public void Blogstest() {
        Blogs Bb = new Blogs(driver);
        Bb.Clickblogs(); // এটাই navigate করবে
        Assert.assertTrue(Bb.isBlogPageLoaded(), "Blog page did not load.");
    }
}