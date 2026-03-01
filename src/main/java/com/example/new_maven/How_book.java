package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class How_book {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public How_book(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
				
	}

	public void Click_book() {
		WebElement book=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[@href='https://phptravels.net/page/how-to-book']//span[@class='material-symbols-outlined text-base mr-1.5 text-blue-500 group-hover:text-blue-600'][normalize-space()='chevron_right']")));
		js.executeScript("arguments[0].click();", book);
	}
}
