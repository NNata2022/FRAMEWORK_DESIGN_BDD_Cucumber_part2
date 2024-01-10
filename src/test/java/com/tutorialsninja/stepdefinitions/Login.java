package com.tutorialsninja.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.Utilities.Util;
import com.tutorialsninja.driverLogic.DriverFactory;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public Properties dataprop;

	  @Given("I am on the tutorialsninja login page")
	    public void i_am_on_the_tutorialsninja_login_page() {
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
		// driver.findElement(By.linkText("My Account")).click();
		// driver.findElement(By.linkText("Login")).click();

	}

	@When("^I input a valid email (.+) into the email field$")
	public void i_input_a_valid_email_into_the_email_field(String validEmail) {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(validEmail);
		// driver.findElement(By.id("input-email")).sendKeys(validEmail);

	}

	@And("^I input a valid password (.+) into the password field$")
	public void i_input_a_valid_password_into_the_password_field(String validPassword) {
		// driver.findElement(By.id("input-password")).sendKeys(validPassword);
		loginpage = new LoginPage(driver);
		loginpage.enterPassword(validPassword);
	}

	@And("I click the login button")
	public void i_click_the_login_button() {
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginButton();
	}

	@Then("I should be redirected to the Account page")
	public void i_should_be_redirected_to_the_account_page() {
		accountpage = new AccountPage(driver);
		accountpage.validateDisplayStatusOfEditAccountInfoLink();
		// Assert.assertTrue(driver.findElement(By.linkText("Edit your account
		// information")).isDisplayed());

	}

	@When("I enter invalid email into the email field")
	public void i_enter_an_invalid_email_into_the_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(Util.emailWithDateTimeStamp());
		// driver.findElement(By.id("input-email")).sendKeys(incorrectEmail);
	}

	@And("I enter invalid password {string}")
	public void i_enter_an_invalid_password(String invalidPassword) {
		loginpage = new LoginPage(driver);
		loginpage.enterPassword(invalidPassword);
		// driver.findElement(By.id("input-password")).sendKeys(incorrectPassword);
	}

	@Then("I should see an error message about invalid credentials")
	public void i_should_see_an_error_message_about_invalid_credentials() {
		loginpage = new LoginPage(driver);
		loginpage.retrieveCredentialsMismatchWarningMessage();
		String actualWarningMessage = loginpage.retrieveCredentialsMismatchWarningMessage();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
				// Address and/or
				// Password.";//dataprop.getProperty("emailPasswordNoMatchWarningMessage");
		// or this way
																									// //
																									// //dataprop.getProperty("emailPasswordNoMatchWarningMessage");
//		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]"))
//				.getText();
//		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

}
