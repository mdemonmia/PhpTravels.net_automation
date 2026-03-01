package com.example.new_maven.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.new_maven.BaseTest;
import com.example.new_maven.Service_stay;

public class Service_stayTest extends BaseTest {
	
  @Test(priority=1)
  public void validserviceStay() {
	  driver.get("https://phptravels.net/stays");
	  Service_stay Ss=new Service_stay(driver);
	  Ss.selectService();
	 // Ss.selectDestination("Dhaka");
	  Ss.selectCheckIn("18");
	  Ss.selectCheckOut("20");
	  Ss.selectGuestRoom();
	  Ss.selectNationality("Bangladesh");
	  Ss.searchHotel();
  }
  
//  @Test(priority=2)
//  public void invaliddestinationserviceStay() {
//	  driver.get("https://phptravels.net/stays");
//	  Service_stay Ss=new Service_stay(driver);
//	  Ss.selectService();
//	  Ss.selectDestination("");
//	  Ss.selectCheckIn("18");
//	  Ss.selectCheckOut("20");
//	  Ss.selectGuestRoom();
//	  Ss.selectNationality("Bangladesh");
//	  Ss.searchHotel();
//	  
//	  Assert.assertTrue(Ss.DestinationErrorDisplay(), "please fill in the destination city.");
//  }
//  
//  @Test(priority=3)
//  public void invalidnationalityserviceStay() {
//	  driver.get("https://phptravels.net/stays");
//	  Service_stay Ss=new Service_stay(driver);
//	  Ss.selectService();
//	  Ss.selectDestination("Dhaka");
//	  Ss.selectCheckIn("18");
//	  Ss.selectCheckOut("20");
//	  Ss.selectGuestRoom();
//	  Ss.selectNationality("");
//	  Ss.searchHotel();
//	  
//	  Assert.assertTrue(Ss.NationalityErrorDisplay(), "please fill in the nationality.");
//  }
  
  
}
