@TutorialsNinjaSearchProduct
Feature: Search Product functionality of TutorialsNinja

  As a customer of TutorialsNinja
  I want to use the search functionality
  So that I can easily find products I am interested in

  @ValidProduct
  Scenario Outline: Successful product search with valid search term
    Given I am on the TutorialsNinja homepage
    When I enter a valid product name "<productName>" in the search bar on website
    And I initiate the search clicking on the search button
    Then I should see a list of products related to the search term

    Examples:
      | productName   |
      | Samsung Galaxy|
      

  @InvalidProduct
  Scenario: Search for an invalid or non-existent product
    Given I am on the TutorialsNinja homepage
    When I enter an invalid or non-existent product name in the search bar "DELL"
    And I initiate the search clicking on the search button
    Then I should see a message indicating no products were found

  @NoProduct
  Scenario: Search with no product name
    Given I am on the TutorialsNinja homepage
    And I initiate the search clicking on the search button
    Then I should see a message indicating no products were found
