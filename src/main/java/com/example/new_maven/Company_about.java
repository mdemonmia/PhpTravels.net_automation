package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Company_about {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Company_about(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.js = (JavascriptExecutor) driver;
    }

    public void aboutUsmenuClick() {
    	WebElement company=wait.until(ExpectedConditions.elementToBeClickable(By
    			.xpath("//*[self::a or self::button or self::span]" +
    					"[normalize-space()='Company']")));
    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", company);
    	try {
    		new Actions(driver).moveToElement(company).pause(Duration.ofMillis(200)).perform(); 
		} catch (Exception ignored) {
			
		}
    	try {
    		company.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", company);
		}
    	
    	WebElement about1=wait.until(ExpectedConditions.elementToBeClickable(By
    			.xpath("//a[normalize-space()='About us' or normalize-space()='About Us' or contains(@href,'/page/about-us')]")));
    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", about1);
    	try {
    		about1.click();
		} catch (Exception e) {
			 js.executeScript("arguments[0].click();", about1);
		}
    	wait.until(ExpectedConditions.urlContains("/page/about-us"));
    }
    
    public void selectAbout() {
    	WebElement about2=wait.until(ExpectedConditions.elementToBeClickable(By
    			.xpath("//a[@href='https://phptravels.net/page/about-us']//span[@class='material-symbols-outlined text-base mr-1.5 text-blue-500 group-hover:text-blue-600'][normalize-space()='chevron_right']")));
    	js.executeScript("arguments[0].click();", about2);
    }
    
}