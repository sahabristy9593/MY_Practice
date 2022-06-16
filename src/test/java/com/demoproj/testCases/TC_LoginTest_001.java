package com.demoproj.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.demoproj.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException, IOException {
	   System.out.println("============testcase started================");
		driver.get(baseURL);
		logger.info("URL is oppened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.login();
		logger.info("logged in");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Test001 passed");
		}else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test001 failed");
		}
		
	}
	 
}
