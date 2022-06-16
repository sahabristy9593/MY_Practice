package com.demoproj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localdriver;
	
	public LoginPage(WebDriver remoteDriver){
		localdriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//*[text()='Log out']")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUserName(String username) {
		txtUserName.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void login() {
		btnLogin.click();
	}
	
	public void logout() {
		btnLogout.click();
	}
	
}
