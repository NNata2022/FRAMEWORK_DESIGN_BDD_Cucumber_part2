package com.tutorialsninja.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverLogic.DriverFactory;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoggedOutPage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.SearchPage;
import com.tutorialsninja.pages.ShoppingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCard {

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public Properties dataprop;
	public SearchPage searchpage;
	public LoggedOutPage logoutpage;
	public ShoppingCartPage shoppingcardpage;

	@Given("I have navigated to the TutorialsNinja homepage")
	public void i_have_navigated_to_the_tutorialsninja_homepage() {
		driver = DriverFactory.getDriver();

	}

	@When("I enter a valid product name {string} in the search bar")
	public void i_enter_a_valid_product_name_in_the_search_bar(String productName) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(productName);

	}

	@When("I initiate the product search clicking on the search button") // !!!!!!!!!!!!!!!
	public void i_initiate_the_product_search_clicking_on_the_search_button() {
		// Locate the search button and click on it.
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();

	}

	@Then("I should see a list of products related to the search term in the product search")
	public void i_should_see_a_list_of_products_related_to_the_search_term_in_the_product_search() throws Exception {
		// Example: Check if the products list is displayed
		shoppingcardpage = new ShoppingCartPage(driver);
		// Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
		// shoppingcardpage.addToCartButton(); // system is re-directed to//
		// ProductInfoPage
		Assert.assertTrue(driver.findElement(By.linkText("Samsung Galaxy Tab 10.1")).isDisplayed());
		Thread.sleep(3000);

	}

	@When("I click on the add to cart button for {string}")
	public void i_click_on_the_add_to_cart_button_for(String productName) throws Exception {
		//shoppingcardpage = new ShoppingCartPage(driver);
		//driver.findElement(By.linkText("Add to Cart")).click();
		//shoppingcardpage.addToCartButton();
		driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
		Thread.sleep(2000);
	}

	@Then("I should see the product added successfully to the cart message")
	public void i_should_see_the_product_added_successfully_to_the_cart_message() {
		String expectedSuccessMassage = "Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart!";
	    String actualsuccessMassage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	    System.out.println(actualsuccessMassage);
	    Assert.assertTrue(actualsuccessMassage.contains(expectedSuccessMassage));
		//shoppingcardpage = new ShoppingCartPage(driver);
		//Assert.assertTrue(successAlert.getText().contains(dataprop.getProperty("productAddedSuccessfullyToCartMessage")), "The product added successfully message is not displayed as expected.");
//		String expectedMessage = dataprop.getProperty("productAddedSuccessfullyToCartMessage");
//		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'Samsung Galaxy Tab 10.1')]")).getText();
//		Assert.assertTrue(actualMessage.contains(expectedMessage));
//		Assert.assertTrue(driver.findElement(By.xpath(
//				"//div[@class='alert alert-success alert-dismissible']")).isDisplayed());
	//Assert.assertTrue(dataprop.getProperty("productAddedSuccessfullyToCartMessage"));
//		String successMessage = dataprop.getProperty("productAddedSuccessfullyToCartMessage");
//		Assert.assertNotNull("The success message should not be null", successMessage);
//		Assert.assertNotSame("The success message should not be empty", successMessage.isEmpty());
//		shoppingcardpage = new ShoppingCartPage(driver);
//		shoppingcardpage.validateIfProductWasSuccessfullyAddedToCart();
//		   boolean isSuccessMessageDisplayed =shoppingcardpage.isAlertSuccessMessageDisplayed();
//	       System.out.println("Is success message displayed? " + isSuccessMessageDisplayed);
//	    
//	    boolean displayStatus = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
//	     System.out.println(displayStatus);

	}

	@When("I click on the checkout button")
	public void i_click_on_the_checkout_button() throws Exception {
		driver.findElement(By.xpath("//div[@id = 'cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Checkout")).click();
	}
}
