package com.example.new_maven.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.new_maven.BaseTest;
import com.example.new_maven.Company_about;

public class Abouttestcase extends BaseTest {

    // ✅ Test 1: About Us পেজে যাওয়া যাচ্ছে কিনা চেক
    @Test(priority = 1)
    public void About1() {
        Company_about Ca = new Company_about(driver);
        Ca.aboutUsmenuClick();
        // ✅ পেজ সঠিকভাবে লোড হয়েছে কিনা Assert করো
        Assert.assertTrue(Ca.isAboutPageLoaded(), "About Us page did not load.");
    }

    // ✅ Test 2: About Us পেজের কন্টেন্ট আছে কিনা চেক
    @Test(priority = 2)
    public void About2() {
        Company_about Ca = new Company_about(driver);
        Ca.selectAbout();
        Assert.assertTrue(Ca.isAboutPageLoaded(), "About Us page did not load.");
    }
}