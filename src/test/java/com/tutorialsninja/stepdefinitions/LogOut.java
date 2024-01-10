package com.tutorialsninja.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tutorialsninja.driverLogic.DriverFactory;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoggedOutPage;
import com.tutorialsninja.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOut {
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public Properties dataprop;
	public LoggedOutPage loggedoutpage;
	 @Given("I am logged into the TutorialsNinja website with email {string} and password {string}")
	    public void i_am_logged_into_the_tutorialsninja_website(String validEmail, String validPassword) {
	        // Code to log into the website
		// Logic to ensure the user is logged in
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(validEmail);
		loginpage.enterPassword(validPassword);
		loginpage.clickOnLoginButton();
		accountpage = new AccountPage(driver);
		accountpage.validateDisplayStatusOfEditAccountInfoLink();
		
//	}
//
//    @When("I click on the logout button from DropDown options")
//    public void i_click_on_the_logout_button_from_dropdown_options() {
//    	loggedoutpage = new LoggedOutPage(driver);
//    	loggedoutpage.getMyaccountdropdown();
//    	loggedoutpage.getLogoutDropDown();
   
       
    }
	@When("I click on the logout button from Right Corner")
	public void i_click_on_the_logout_button_from_right_corner()  {
	
		//loggedoutpage = new LoggedOutPage(driver);
		driver.findElement(By.linkText("Logout")).click();
		//loggedoutpage.getLoggedOut();

	}

	@Then("I should be logged out of the system and redirected to the Logoutpage")
	public void i_should_be_logged_out_of_the_system_and_redirected_to_the_logoutpage() {
		WebElement accountLogoutElement = driver.findElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertTrue(accountLogoutElement.isDisplayed(), "Account Logout text is not displayed");
//		loggedoutpage = new LoggedOutPage(driver);
//		Thread.sleep(2000);
//		loggedoutpage.validateDisplayMessageOfLoggOffFromAccountInfoLink();
//		String expectedMessage = dataprop.getProperty("logOutFromAccountMessage");
//		Thread.sleep(3000);
//		String actualMessage = driver.findElement(By.xpath("//p[contains(text(),'You have been logged off your account. It is now s')]")).getText();
//		Assert.assertTrue(actualMessage.contains(expectedMessage));

	}

}
