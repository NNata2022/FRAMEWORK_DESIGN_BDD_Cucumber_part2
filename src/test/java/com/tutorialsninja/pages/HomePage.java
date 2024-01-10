package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchTextBox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}
	
	public void selectLoginOption() {
		loginOption.click();
		
	}
	public void selectRegisterOption() {
		registerOption.click();
		
	}
	
	public void enterProductDetail(String productNameText) {
		searchTextBox.sendKeys(productNameText);
	}

	public SearchPage clickOnSearchIcon() {
		searchButton.click();
		return new SearchPage(driver);
		
	}

}
