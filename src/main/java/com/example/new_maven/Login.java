package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void LoginClick() {
		WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Login')]")));
		login.click();
	}
	
	public void Entermail(String email) {
		WebElement mail=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		mail.clear();
		
		if(email !=null && !email.trim().isEmpty()) {
			mail.sendKeys(email);
		}else {
			System.out.println("Blank email.");
		}
	}
	
	public void Enterpassword(String pwd) {
		WebElement passwd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		passwd.clear();
		if(pwd !=null && !pwd.trim().isEmpty()) {
			passwd.sendKeys(pwd);
		}else {
			System.out.println("Blank password");
		}
		
		WebElement showPass=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='toggle-password']")));
		js.executeScript("arguments[0].click();", showPass);
	}
	
	public void isCheck() {
		WebElement check=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Remember Me']")));
		js.executeScript("arguments[0].click();", check);
	}
	
	public void ClickForgotpassword(String  cmail) {
		WebElement Fpass=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Forgot Password?']")));
		js.executeScript("arguments[0].click();", Fpass);
		
		WebElement enterMail=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		if(cmail !=null && !cmail.trim().isEmpty()) {
			enterMail.sendKeys(cmail);
		}
		
		WebElement Fsubmit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//button[@type='submit']")));
		Fsubmit.click();
	}
	

	public void SubmitLogin() {
		WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@x-show='!isSubmitting']")));
		js.executeScript("arguments[0].click();", submit);
	}

	
	public boolean emailErrorDisplay() {
		try {
			WebElement ErrorEmail=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			return ErrorEmail.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean passErrorDisplay() {
		try {
			WebElement ErrorPwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			return ErrorPwd.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public boolean clickFpassErrorDisplay() {
		try {
			WebElement Fpwd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			return Fpwd.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public boolean isErrorDisplay() {
		try {
			WebElement Errormsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Error Invalid Credentials']")));
			if(Errormsg.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error isnot display.");
		}
		return false;
	}
}
