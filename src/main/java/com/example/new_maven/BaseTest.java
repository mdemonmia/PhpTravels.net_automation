//package com.example.new_maven;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//public class BaseTest {
//	
//	protected static WebDriver driver;
//	protected WebDriverWait wait;
//	protected JavascriptExecutor js;
//	
//	@BeforeSuite
//	public void setup() {
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//	}
//	
//	@AfterSuite
//	public void tearDown() {
//		if(driver !=null) {
//			driver.quit();
//			driver=null;
//		}
//	}
//
//}

package com.example.new_maven;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;  // ← import যোগ করো
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	
	@BeforeSuite
	public void setup() {
		ChromeOptions options = new ChromeOptions();  // ← যোগ করো
		options.addArguments("--headless");           // ← যোগ করো
		options.addArguments("--no-sandbox");         // ← যোগ করো
		options.addArguments("--disable-dev-shm-usage"); // ← যোগ করো
		
		driver = new ChromeDriver(options);  // ← options পাঠাও
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
