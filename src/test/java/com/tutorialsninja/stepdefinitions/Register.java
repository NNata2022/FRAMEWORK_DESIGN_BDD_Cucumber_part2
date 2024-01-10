package com.tutorialsninja.stepdefinitions;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.tutorialsninja.Utilities.Util;
import com.tutorialsninja.driverLogic.DriverFactory;
import com.tutorialsninja.pages.AccountSuccessPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public RegisterPage registerpage;
	public Map<String, String>dataMap;
	public AccountSuccessPage accountsuccesspage;

	 @Given("I am on the tutorialsninja registration page")
	    public void i_am_on_the_tutorialsninja_registration_page() {
	    driver = DriverFactory.getDriver();
	    homepage = new HomePage(driver);
	    homepage.clickOnMyAccount();
	    homepage.selectRegisterOption();

	    // Initialize the registerpage object here
	    registerpage = new RegisterPage(driver);
		// driver.findElement(By.linkText("My Account")).click();
		// driver.findElement(By.linkText("Register")).click();
	}

	@When("I enter below valid registration details") // @MandatoryFields
	public void i_enter_below_valid_registration_details(io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("lastname"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']"))
//				.sendKeys(dataMap.get("firstname"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']"))
//				.sendKeys(dataMap.get("lastname"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']"))
//				.sendKeys(Util.emailWithDateTimeStamp());
//		driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']"))
//				.sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']"))
//				.sendKeys(dataMap.get("password"));
//		driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']"))
//				.sendKeys(dataMap.get("confirmpassword"));
	}

	@When("I submits the registration by clicking the Continue button")
	public void i_submits_the_registration_by_clicking_the_continue_button() {
		// registerpage = new RegisterPage(driver);
		accountsuccesspage = registerpage.clickOnContinueButton();
		// driver.findElement(By.xpath("//div[@class =
		// 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();
	}

	@Then("I should see a confirmation message for successful registration")
	public void i_should_see_a_confirmation_message_for_successful_registration() {
		// accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.verifyDisplayStatusOfAccountSuccessMessage());
//		Assert.assertTrue(driver
//				.findElement(
//						By.xpath("//p[text() = 'Congratulations! Your new account has been successfully created!']"))
//				.isDisplayed());

	}

	@When("I enter below all fields")
	public void i_enter_below_all_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		// registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("lastname"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']"))
//				.sendKeys(dataMap.get("firstname"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']"))
//				.sendKeys(dataMap.get("lastname"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']"))
//				.sendKeys(Util.emailWithDateTimeStamp());
//		driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']"))
//				.sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']"))
//				.sendKeys(dataMap.get("password"));
//		driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']"))
//				.sendKeys(dataMap.get("confirmpassword"));

		// driver.findElement(By.xpath("//div[@class =
		// 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();

	}

	@When("I selects yes to subscribe to the newsletter")
	public void i_selects_yes_to_subscribe_to_the_newsletter() {
		// registerpage = new RegisterPage(driver);
		registerpage.clickOnNewsLetterYesOptionRadioButton();
//		driver.findElement(
//				By.xpath("//aside[@id = 'column-right']/preceding::input[@name = 'newsletter' and @value = '1']"))
//				.click();
	}

	@When("I agrees to the Privacy Policy by checking the box")
	public void i_agrees_to_the_privacy_policy_by_checking_the_box() {

		// registerpage = new RegisterPage(driver);
		registerpage.clickOnPrivacyPolicyCheckBox();
//		driver.findElement(
//				By.xpath("//div[@class = 'pull-right']/child::a[1]/following-sibling::input[@name = 'agree']")).click();
	}

	@When("I enter below all fields with existing email")
	public void i_enter_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		// registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("lastname"));
		registerpage.enterEmail(dataMap.get("email"));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']"))
//				.sendKeys(dataMap.get("firstname"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']"))
//				.sendKeys(dataMap.get("lastname"));
//		driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']"))
//				.sendKeys(dataMap.get("email"));
//		driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']"))
//				.sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']"))
//				.sendKeys(dataMap.get("password"));
//		driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']"))
//				.sendKeys(dataMap.get("confirmpassword"));

	}

	@Then("I should see warning message of duplicate email")
	public void i_should_see_warning_message_of_duplicate_email() {
		// registerpage = new RegisterPage(driver);
		String actualWarningMessage = registerpage.retrieveDuplicateEmailWarning();
		// String actualWarningMessage =
		// driver.findElement(By.xpath("//div[contains(@class,
		// 'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
//		String actualDuplicateWarningMessage = driver
//				.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
//		String expectedDuplicateWarningMessage = "Warning: E-Mail Address is already registered!";

	}



	@Then("I should see error messages for each mandatory field")
	public void i_should_see_error_messages_for_each_mandatory_field() {

		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(driver
				.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]"))
				.getText().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver
				.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]"))
				.getText().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]"))
						.getText().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(driver
				.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]"))
				.getText().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]"))
						.getText().contains("Password must be between 4 and 20 characters!"));

//		String actualPrivacyPolicyWarningMessage = driver
//				.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
//		String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
//		Assert.assertTrue(actualPrivacyPolicyWarningMessage.contains(expectedPrivacyPolicyWarningMessage));
//
//		String actualFirstNameWarningMessage = driver
//				.findElement(By.xpath("//input[@id = 'input-firstname']/following-sibling::div[1]")).getText();
//		String expectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
//		Assert.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage));
//
//		String actualLastNameWarningMessage = driver
//				.findElement(By.xpath("//input[@id = 'input-lastname']/following-sibling::div[1]")).getText();
//		String expectedLastNameWarningMessage = "Last Name must be between 1 and 32 characters!";
//		Assert.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage));
//
//		String actualEmailWarningMessage = driver
//				.findElement(By.xpath("//input[@id = 'input-email']/following-sibling::div[1]")).getText();
//		String expectedEmailWarningMessage = "E-Mail Address does not appear to be valid!";
//		Assert.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage));
//
//		String actualTelephoneWarningMessage = driver
//				.findElement(By.xpath("//input[@id = 'input-telephone']/following-sibling::div[1]")).getText();
//		String expectedTelephoneWarningMessage = "Telephone must be between 3 and 32 characters!";
//		Assert.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage));
//
//		String actualPasswordWarningMessage = driver
//				.findElement(By.xpath("//input[@id = 'input-password']/following-sibling::div[1]")).getText();
//		String expectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
//		Assert.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage));
	}

}
