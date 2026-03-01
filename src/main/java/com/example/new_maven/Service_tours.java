package com.example.new_maven;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Service_tours {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Service_tours(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		this.js=(JavascriptExecutor) driver;
	}

	
//	public void Select_service(String city) {
//	    // Implicit wait সরিয়ে দিন কারণ এটি WebDriverWait এর সাথে ঝামেলা করে
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); 
//
//	    // ১. 'Search By City' ফিল্ডে শহর পাঠানো
//	    WebElement destination = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search By City']")));
//	    destination.clear();
//	    destination.click();
//	    destination.sendKeys(city);
//
//	    // ২. ড্রপডাউনটি পপুলেট হওয়ার জন্য একটু সময় দিন (এটি স্টেল এলিমেন্ট ঠেকাতে খুব কার্যকর)
//	    try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
//
//	    // ৩. Stale Element হ্যান্ডেল করার জন্য লুপ
//	    boolean clicked = false;
//	    for (int i = 0; i < 5; i++) {
//	        try {
//	            // ড্রপডাউনের নির্দিষ্ট আইটেমটি নতুন করে খুঁজে বের করা
//	            WebElement citySelect = wait.until(ExpectedConditions.presenceOfElementLocated(
//	                By.xpath("//span[contains(@class, 'material-symbols-outlined') and contains(@class, 'text-blue-500')]")));
//	            
//	            // এলিমেন্টটি ক্লিকযোগ্য হওয়া পর্যন্ত অপেক্ষা
//	            wait.until(ExpectedConditions.elementToBeClickable(citySelect));
//	            
//	            // সরাসরি ক্লিক না হলে JS Click ব্যবহার
//	            js.executeScript("arguments[0].click();", citySelect);
//	            clicked = true;
//	            break; 
//	        } catch (Exception e) {
//	            System.out.println("Attempt " + (i+1) + " failed. Retrying...");
//	            try { Thread.sleep(1000); } catch (InterruptedException ie) {}
//	        }
//	    }
//
//	    if (!clicked) {
//	        System.out.println("Could not click city dropdown after 5 attempts.");
//	    }
//	}
	
	public void selectStartDate(String date) {

	    WebElement datePicker = wait.until(
	            ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//input[@placeholder='Start Date']")));

	    // Remove readonly attribute if present
	    js.executeScript("arguments[0].removeAttribute('readonly');", datePicker);

	    datePicker.clear();
	    datePicker.sendKeys(date);

	    // Trigger change event (important)
	    js.executeScript("arguments[0].dispatchEvent(new Event('change'));", datePicker);

	    // Validation
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(datePicker, "value"));
	}
	
	public void selectDuration(String durationText) {

	    // 1️⃣ Open dropdown (JS click)
	    WebElement durationDropdown = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//span[normalize-space()='Any Duration']")
	        )
	    );
	    js.executeScript("arguments[0].click();", durationDropdown);

	    // 2️⃣ Wait until at least one option is present
	    List<WebElement> options = wait.until(
	        ExpectedConditions.presenceOfAllElementsLocatedBy(
	            By.xpath("//div[contains(@class,'dropdown-menu')]//li")
	        )
	    );

	    // 3️⃣ Loop through options & click the matching one
	    boolean clicked = false;
	    for (WebElement option : options) {
	        String text = option.getText().trim();
	        if (!text.isEmpty() && text.equalsIgnoreCase(durationText)) {
	            js.executeScript("arguments[0].scrollIntoView(true);", option);
	            js.executeScript("arguments[0].click();", option);
	            System.out.println("Selected Duration: " + text);
	            clicked = true;
	            break;
	        }
	    }

	    if (!clicked) {
	        System.out.println("Duration not found: " + durationText);
	    }
	}

	
	
}

	



	
	



