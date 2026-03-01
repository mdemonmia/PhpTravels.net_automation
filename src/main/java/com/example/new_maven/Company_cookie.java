package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Company_cookie {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Company_cookie(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
				
	}
	
	public void Clickcookie() {
		WebElement company=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//*[self::a or self::button or self::span]" +
    					"[normalize-space()='Company']")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'})", company);
		
		try {
			new Actions(driver).moveToElement(company).pause(Duration.ofMillis(500)).perform();
		} catch (Exception ignored) {
			
		}
		
		try {
			company.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", company);
		}
		
		WebElement cookie=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Cookies Policy' or normalize-space()='Cookies Policy' or contains(@href,'/page/cookies-policy')]")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", cookie);
		try {
			cookie.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", cookie);
		}
		
		wait.until(ExpectedConditions.urlContains("/page/cookies-policy"));
	}
	
	public void Clickcookie2() {
		WebElement cookie2=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[@href='https://phptravels.net/page/cookies-policy']//span[@class='material-symbols-outlined text-base mr-1.5 text-blue-500 group-hover:text-blue-600'][normalize-space()='chevron_right']")));
		js.executeScript("arguments[0].click();", cookie2);
	}

}
