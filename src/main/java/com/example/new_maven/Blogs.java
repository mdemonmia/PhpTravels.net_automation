package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Blogs {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Blogs(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Clickblogs() {
		WebElement blogs=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[" +
			              "contains(translate(@href,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'/blog')" +
			              " or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'blog')" +
			            "]")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", blogs);
		try {
			blogs.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", blogs);
		}
		wait.until(ExpectedConditions.urlContains("/page/blog"));
	}

}
