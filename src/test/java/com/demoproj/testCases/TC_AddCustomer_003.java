package com.demoproj.testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoproj.pageObjects.AddCustomerPage;
import com.demoproj.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass
{
   @Test
   public void addNewCustomer() throws InterruptedException, IOException {
	   
	   LoginPage lp = new LoginPage(driver);
	    lp.setUserName(username);
	    lp.setPassword(password);
	    lp.login();
	    
	    Thread.sleep(3000);
	    
	    AddCustomerPage cp = new AddCustomerPage(driver);
	    cp.addnewCust();
	    Thread.sleep(1000);
			
	   
	    
	    Thread.sleep(3000);
	    String nm = "ATest " + randomString();
	    cp.sendName(nm);
	    cp.SelectGender();
	    cp.DateOfBirth("05", "09", "93");
	    cp.cAddress("New Amarabhati ladies pg" + " Bellandur");
	    cp.cCity("Bangalore");
	    cp.cState("Karnataka");
	    cp.cPIN("560103");
	    String phone = String.valueOf(randomNumber());
	    cp.cMobile(phone);
	    String email = randomString() + "@gmail.com";
	    cp.cEmail(email);
	    cp.cPassword("Pasword123");
	    cp.submitApplication();
	    
	    Thread.sleep(5000);
	    
	    boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	    
	    if(res==true) {
	    	Assert.assertTrue(true);
	    }else {
	    	captureScreen(driver, "Add new Customer");
	    	Assert.assertTrue(false);
	    }
	    
	    driver.close();
   }
   
   public String randomString() {
	  String generatedString = RandomStringUtils.randomAlphabetic(5);
	   return generatedString;
	   
   }
   
   public int randomNumber() {
		  Random random = new Random(10);
		  int randomNumber = random.nextInt();
		   return randomNumber;
		   
	   }
   public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e)  {
			return false;
		}}
   public boolean isWindowPresent() {
		try {
		driver.switchTo().window("name");
		return true;
		}catch(Exception e)  {
			return false;
		}}
}
