package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBoxField;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBoxField;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement credentialsMismatchWarningMessage;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String validEmail) {
		emailTextBoxField.sendKeys(validEmail);
	}
	
	public void enterPassword(String validPassword) {
		passwordTextBoxField.sendKeys(validPassword);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	
	}
	public AccountPage navigateToLoginPage(String emailText, String passwordText) {
		emailTextBoxField.sendKeys(emailText);
		passwordTextBoxField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String retrieveCredentialsMismatchWarningMessage() {
		String warningCredMismatch = credentialsMismatchWarningMessage.getText();
		return warningCredMismatch;
	}

}
