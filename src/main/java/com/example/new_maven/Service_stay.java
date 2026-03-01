package com.example.new_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Service_stay {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Service_stay(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void selectService() {
		WebElement service=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//*[self::a or self::button or self::span]" +
				        "[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'services')]")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", service);
		try {
			new Actions(driver).moveToElement(service).pause(Duration.ofMillis(500)).perform();
		} catch (Exception ignored) {
			
		}
		try {
			service.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", service);
		}
		
		WebElement clickStay=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[" +
				          "contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'stays')" +
				          " or contains(translate(@href,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'/stays')" +
				        "]")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", clickStay);
		try {
			clickStay.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", clickStay);
		}
		wait.until(ExpectedConditions.urlContains("/stays"));
	}
	
	public void selectDestination(String city) {

	    if (city == null) city = "";
	    String c = city.trim();

	    By destinationOpener = By.xpath(
	        "(//input[@placeholder='Search By City' or @placeholder='Destination or Hotel Name']" +
	        " | (//span[contains(@class,'select2-selection')])[1])[1]"
	    );

	    // ✅ Select2 opened state
	    By select2Open = By.cssSelector("span.select2-container--open");

	    // ✅ Search input fallbacks (সবচেয়ে কমন 3টা)
	    By select2Input1 = By.cssSelector("span.select2-container--open input.select2-search__field");
	    By select2Input2 = By.xpath("//span[contains(@class,'select2-container--open')]//input");
	    By select2Input3 = By.xpath("(//input[@type='search' or @role='searchbox'])[last()]");

	    // ✅ 1) Open dropdown
	    WebElement opener = wait.until(ExpectedConditions.elementToBeClickable(destinationOpener));
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", opener);
	    try { opener.click(); } catch (Exception e) { js.executeScript("arguments[0].click();", opener); }

	    // ✅ 2) Wait until select2 is open (এটা না থাকলে input আসবেই না)
	    wait.until(ExpectedConditions.presenceOfElementLocated(select2Open));

	    // ✅ 3) Find search input with fallback
	    WebElement searchInput;
	    try {
	        searchInput = wait.until(ExpectedConditions.elementToBeClickable(select2Input1));
	    } catch (Exception e1) {
	        try {
	            searchInput = wait.until(ExpectedConditions.elementToBeClickable(select2Input2));
	        } catch (Exception e2) {
	            searchInput = wait.until(ExpectedConditions.elementToBeClickable(select2Input3));
	        }
	    }

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", searchInput);

	    // clear + type
	    searchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    searchInput.sendKeys(Keys.DELETE);

	    if (c.isEmpty()) {
	        searchInput.sendKeys(Keys.ESCAPE);
	        return;
	    }

	    searchInput.sendKeys(c);

	    // ✅ 4) Click first matching option
	    By option = By.xpath(
	        "(//li[contains(@class,'select2-results__option') and not(contains(@class,'loading'))]" +
	        "[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + c.toLowerCase() + "')])[1]"
	    );

	    WebElement clickOption = wait.until(ExpectedConditions.elementToBeClickable(option));
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", clickOption);
	    try { clickOption.click(); } catch (Exception e) { js.executeScript("arguments[0].click();", clickOption); }
	}
	

	
	public void selectCheckIn(String checkin) {
		
		if(checkin == null) checkin = "";
		String d=checkin.trim();
		
		for(int i=0;i<3;i++) {
			try {
				
				WebElement clickDate=wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By
						.xpath("//input[contains(@placeholder,'Check-in Date')]"))));
				js.executeScript("arguments[0].scrollIntoView({block:'center'});", clickDate);
				
				try {
					clickDate.click();
				} catch (Exception e) {
					js.executeScript("arguments[0].click();", clickDate);
				}
				
				try {
					WebElement openCalender=wait.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("//*[contains(@class,'datepicker') or contains(@class,'flatpickr') or contains(@class,'calendar') or @role='dialog']")));
					
					
				} catch (Exception ignored) {
					
				}
				
				WebElement selectDate=wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By
						.xpath("(" +
						        "  (//*[contains(@class,'datepicker') or contains(@class,'flatpickr') or contains(@class,'calendar') or @role='dialog']" +
						        "    | //body" +
						        "  )" +
						        "  //*[self::td or self::button or self::span or self::div]" +
						        "  [normalize-space()='" + d + "']" +
						        "  [not(@disabled) and not(contains(@class,'disabled'))]" +
						        ")[1]"))));
				js.executeScript("arguments[0].scrollIntoView({block'center'});", selectDate);
				try {
					selectDate.click();
				} catch (Exception e) {
					js.executeScript("arguments[0].click();", selectDate);
				}
				return;
				
			} catch (org.openqa.selenium.StaleElementReferenceException ignored) {
				// TODO: handle exception
			}
		}
		
		throw new RuntimeException("selectCheckIn failed due to repeated StaleElementReferenceException");
	}
	
	
	public void selectCheckOut(String checkout) {
		WebElement clickcheckout=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@placeholder='Check-out Date']")));
		js.executeScript("arguments[0].click();", clickcheckout);
		
		WebElement selectcheckout=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space()='" + checkout + "'])[1]")));
		js.executeScript("arguments[0].click();", selectcheckout);
		
	}
	
	public void selectGuestRoom() {
		WebElement clickGuest=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[contains(@x-text,'getGuestText()')]")));
		js.executeScript("arguments[0].click();", clickGuest);
		
		WebElement clickAdult=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space()='Adults']/following::button[.//span[normalize-space()='Add']])[1]")));
		js.executeScript("arguments[0].click();", clickAdult);
				
	}
	
	public void selectNationality(String country) {
		WebElement clickNation=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[@x-text='getSelectedName()']")));
		
		js.executeScript("arguments[0].click();", clickNation);
		
		WebElement inputCountry=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@placeholder='Search country...']")));
		
		inputCountry.click();
		inputCountry.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		inputCountry.sendKeys(Keys.DELETE);
		
		if(country !=null && !country.trim().isEmpty()) {
			inputCountry.sendKeys(country.trim());
		}
		
		WebElement clickCountry=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//li//span[normalize-space()='" + country.trim() + "'])[1]")));
		js.executeScript("arguments[0].click();", clickCountry);
	}
	
	public void searchHotel() {
		WebElement Searchhotel=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Search Hotels']")));
		js.executeScript("arguments[0].click();", Searchhotel);
	}
	
	public boolean DestinationErrorDisplay() {
		try {
			WebElement destError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(translate(.,'DESTINATION','destination'),'destination')]")));
			return destError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean NationalityErrorDisplay() {
		try {
			WebElement NError=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//*[contains(translate(.,'NATIONALITY','nationality'),'nationality')]")));
			return NError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
