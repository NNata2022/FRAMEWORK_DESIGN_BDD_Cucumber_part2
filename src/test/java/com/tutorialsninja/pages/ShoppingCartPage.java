package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	public WebDriver driver;
	
	
	
	
	
	@FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")
	private WebElement ShoppingCart;
	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'Samsung Galaxy Tab 10.1')]")
	private WebElement ProductCodeInfo;
	@FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")
	private WebElement addToCartButton;
	@FindBy(linkText = "Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart!")
	private WebElement successAlert;

	 @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	  private WebElement isAlertSuccessMessageDisplayed;
	
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public WebElement ShoppingCart() {
		 return ShoppingCart;
	 }
	 
	 public WebElement addToCartButton() {
		 return addToCartButton;
	 }
	 public WebElement successAlert() {
		 return successAlert;
	 }
	 
	 public boolean validateDisplayStatusProdInfo() {
			boolean displayStatus = ProductCodeInfo.isDisplayed();
			return displayStatus;
		}
	 //Validates if the product was successfully added to the cart.
	 public boolean validateIfProductWasSuccessfullyAddedToCart() {
		    boolean displayStatus = successAlert.isDisplayed();
		    return displayStatus;
		}
	 public boolean isAlertSuccessMessageDisplayed() {
		  By successmssageLocator  = By.xpath("//div[@class='alert alert-success alert-dismissible']");
		     return driver.findElement(successmssageLocator).isDisplayed();
		   }
	
		   

}
