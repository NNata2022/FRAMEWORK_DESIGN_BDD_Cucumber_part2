package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedOutPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//i[@class='fa fa-user']") 
	WebElement myaccountdropdown;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement LogoutDropdown;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LoggedOut;
	@FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
	private WebElement logOffFromAccountInfoLink;

	public LoggedOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getLoggedOut() {
		return LoggedOut;
	}
	public WebElement getMyaccountdropdown() {
		return myaccountdropdown;
	}
	
	public WebElement getLogoutDropDown() {
		return LogoutDropdown;
	}
	public boolean validateDisplayMessageOfLoggOffFromAccountInfoLink() {
		boolean displayStatus = logOffFromAccountInfoLink.isDisplayed();
		return displayStatus;
	}
}
