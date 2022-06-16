package com.demoproj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	   WebDriver ldriver;
	   
	   public AddCustomerPage(WebDriver rdriver) {
		   ldriver = rdriver;
		   PageFactory.initElements(rdriver, this);
	   }
	   
	   @FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	   @CacheLookup
	   WebElement lnkNewCust;
	   
	   @FindBy(how = How.XPATH, using = "//*[@name='name']")
	   @CacheLookup
	   WebElement CustName;
	   
	   @FindBy(how = How.NAME, using = "rad1")
	   @CacheLookup
	   WebElement gender;
	   
	   @FindBy(how = How.ID_OR_NAME, using = "dob")
	   @CacheLookup
	   WebElement DOB;
	   
	   @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	   @CacheLookup
	   WebElement address;
	   
	   @FindBy(how = How.XPATH, using = "//input[@name='city']")
	   @CacheLookup
	   WebElement City;
	   
	   @FindBy(how = How.XPATH, using = "//input[@name='state']")
	   @CacheLookup
	   WebElement State;
	   
	   @FindBy(how = How.XPATH, using = "//input[@name='pinno']")
	   @CacheLookup
	   WebElement Pin;
	   
	   @FindBy(how = How.XPATH, using = "//input[@name='telephoneno']")
	   @CacheLookup
	   WebElement Mobile;
	   
	   @FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	   @CacheLookup
	   WebElement Email;
	   
	   @FindBy(how = How.XPATH, using = "//input[@type='password']")
	   @CacheLookup
	   WebElement Password;
	   
	   @FindBy(how = How.XPATH, using = "//input[@type='submit']")
	   @CacheLookup
	   WebElement submit;
	   
	   public void addnewCust() {
		   lnkNewCust.click();
	   }
	   
	   public void sendName(String name) {
		   CustName.sendKeys(name);
	   }
	   
	   public void SelectGender() {
		   gender.click();
	   }
	   
	   public void DateOfBirth(String mm, String dd, String yy) {
		   DOB.sendKeys(mm);
		   DOB.sendKeys(dd);
		   DOB.sendKeys(yy);
	   }
	   
	   public void cAddress(String addr) {
		   address.sendKeys(addr);
	   }
	   
	   public void cCity(String city) {
		   City.sendKeys(city);
	   }
	   
	   public void cState(String state) {
		   State.sendKeys(state);
	   }
	   
	   public void cPIN(String pin) {
		   Pin.sendKeys(String.valueOf(pin));
	   }
	   
	   public void cMobile(String mobileno) {
		   Mobile.sendKeys(mobileno);
	   }
	   
	   public void cEmail(String email) {
		   Email.sendKeys(email);
	   }
	   public void cPassword(String password) {
		   Password.sendKeys(password);
	   }
	   
	   public void submitApplication() {
		   submit.click();
	   }
}
