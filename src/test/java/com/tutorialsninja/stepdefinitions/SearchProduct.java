package com.tutorialsninja.stepdefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverLogic.DriverFactory;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	
	
	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;

	   @Given("I am on the TutorialsNinja homepage")
	    public void i_am_on_the_tutorialsninja_homepage() {
		driver = DriverFactory.getDriver();	

	}

	@When("I enter a valid product name {string} in the search bar on website")
	public void i_enter_a_valid_product_name_in_the_search_bar_on_website(String validProduct) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(validProduct);
	    //driver.findElement(By.name("search")).sendKeys(validProductText); 
	}

	@When("^I initiate the search clicking on the search button$")
	public void i_initiate_the_search_clicking_on_the_search_button() {
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();
	    //driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click(); this will go to SearchPage

	}

	@Then("^I should see a list of products related to the search term$")
	public void i_should_see_a_list_of_products_related_to_the_search_term() {
		//searchpage = new SearchPage(driver);
		searchpage.verifyDisplayStatusOfValidProduct();
		//driver.findElement(By.linkText("Samsung Galaxy Tab 10.1")).isDisplayed();

	}

	 @When("I enter an invalid or non-existent product name in the search bar {string}")
	    public void i_enter_an_invalid_or_non_existent_product_name_in_the_search_bar(String invalidProduct) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(invalidProduct);
		//driver.findElement(By.name("search")).sendKeys(invalidProductText); 
	}

	@Then("^I should see a message indicating no products were found$")
	public void i_should_see_a_message_indicating_no_products_were_found() {
			searchpage = new SearchPage(driver);
			Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct());
		   //Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]")).isDisplayed());
		
	}

	@When("^I enter no product name in the search bar$")
	public void i_enter_no_product_name_in_the_search_bar() {
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();
	    //driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click(); this will go to SearchPage

	}

	
}
