package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Company_contact {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Company_contact(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void selectContact() {
		WebElement contact=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Company']")));
		Actions action =new Actions(driver);
		action.moveToElement(contact).build().perform();
		WebElement contactUs=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Contact us']")));
		js.executeScript("arguments[0].click();", contactUs);
		
	}
	
	public void selectContact2() {
		WebElement contact2=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[@href='https://phptravels.net/page/contact-us']//span[@class='material-symbols-outlined text-base mr-1.5 text-blue-500 group-hover:text-blue-600'][normalize-space()='chevron_right']")));
		js.executeScript("arguments[0].click();", contact2);
		
	}

}
