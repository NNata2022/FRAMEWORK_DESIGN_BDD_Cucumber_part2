@TutorialsNinjaAddtoCart
Feature: Add to Cart functionality on Tutorialsninja website

  As a user of TutorialsNinja,
  I want to add products to my shopping cart,
  So that I can purchase them later.

  @AddingProductToCart
  Scenario Outline: Adding a product to the cart
    Given I have navigated to the TutorialsNinja homepage
    When I enter a valid product name "<productName>" in the search bar
    And I initiate the product search clicking on the search button
    Then I should see a list of products related to the search term in the product search
    When I click on the add to cart button for "<productName>"
    Then I should see the product added successfully to the cart message
    And I click on the checkout button

    Examples:
      | productName     |
      | Samsung Galaxy  |


  
