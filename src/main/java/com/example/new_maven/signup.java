package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signup {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public signup(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void customerSignup() {
		WebElement signUpmenu=wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//span[contains(text(),'Signup')]")));
		Actions action=new Actions(driver);
		action.moveToElement(signUpmenu).build().perform();
		WebElement clickCustomer=wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//span[contains(text(),'Customer Signup')]")));
		
		clickCustomer.click();
	
	}
	
	public void enterName(String firstName,String lastName) {
//		driver.findElement(By.id("first_name")).sendKeys(firstName);
//		driver.findElement(By.id("last_name")).sendKeys(lastName);
		
		WebElement firstUser=driver.findElement(By.id("first_name"));
		firstUser.clear();
		if(firstName !=null && !firstName.trim().isEmpty()) {
			firstUser.sendKeys(firstName);
		}
		
		WebElement lastUser=driver.findElement(By.id("last_name"));
		lastUser.clear();
		
		if(lastName !=null && !lastName.trim().isEmpty()) {
			lastUser.sendKeys(lastName);
		}
		
	}
	
	
	public void contactEmail(String email) {
		//driver.findElement(By.id("email")).sendKeys(email);
		WebElement mail=driver.findElement(By.id("email"));
		mail.clear();
		
		if(email !=null && !email.trim().isEmpty()) {
			mail.sendKeys(email);
		}
	}
	
	public void Password(String pwd) {
//		driver.findElement(By.id("password")).sendKeys(pwd);
		
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		
		if(pwd !=null && !pwd.trim().isEmpty()) {
			password.sendKeys(pwd);
		}
	}
	
	public void confirmPassword(String Cpwd) {
//		driver.findElement(By.id("confirm_password")).sendKeys(Cpwd);
		WebElement cpwd=driver.findElement(By.id("confirm_password"));
		cpwd.clear();
		
		if(Cpwd !=null && !Cpwd.trim().isEmpty()) {
			cpwd.sendKeys(Cpwd);
		}
	}
	
	public void isCheck() {
		WebElement check=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='terms']")));
		if(!check.isSelected()) {
			js.executeScript("arguments[0].click();", check);
		}
		
	}
	
	public void CreateAccountSubmit() {
		WebElement CA= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@x-show='!isSubmitting']")));
		js.executeScript("arguments[0].click();", CA);
	}
	
	
	public boolean FirstnameErrorDisplay() {
		try {
			WebElement firstError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(text(),'First Name')]")));
				return firstError.isDisplayed();
			}
		catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean LastnameErrorDisplay() {
		
		try {
			WebElement lastError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(text(),'Last Name')]")));
			return lastError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	public boolean emailErrorDisplay() {
		try {
			WebElement emailError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(text(),'Email')]")));
			return emailError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean pwdErrorDisplay() {
		try {
			WebElement pwdError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(text(),'Password')]")));
			return pwdError.isDisplayed();
		} catch (Exception e) {
			return false;
		}	
	}
	
	public boolean confirmpwdErrorDisplay() {
		try {
			WebElement confError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(text(),'Confirm Password')]")));
			return confError.isDisplayed();
		} catch (Exception e) {
			System.out.println("Blank confirm password.");
		}
		return false;
	}
}
