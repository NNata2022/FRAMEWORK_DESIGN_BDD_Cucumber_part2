@TutorialNinjaLogin
Feature: Login functionality on Tutorialsninja website

  As a user of tutorialsninja.com
    I want to log into my account
    So that I can access personalized features of the website

  Scenario Outline: Successful login with valid credentials
    Given I am on the tutorialsninja login page
    When I input a valid email <email> into the email field
    And I input a valid password <password> into the password field
    And I click the login button
    Then I should be redirected to the Account page

    Examples:
      | email                      | password     |
      | nagulanata@gmail.com       | Nataliia@123 |
      | seleniumpanda1@gmail.com   | Selenium@123 |
      | seleniumpanda2@gmail.com   | Selenium@123 |
      | seleniumpanda3@gmail.com   | Selenium@123 |
      | seleniumpanda4@gmail.com   | Selenium@123 |
      | seleniumpanda5@gmail.com   | Selenium@123 |
      | seleniumpanda6@gmail.com   | Selenium@123 |
      | seleniumpanda7@gmail.com   | Selenium@123 |
      | seleniumpanda8@gmail.com   | Selenium@123 |
      | seleniumpanda9@gmail.com   | Selenium@123 |
      | seleniumpanda10@gmail.com  | Selenium@123 |

  Scenario: Unsuccessful login with incorrect password
    Given I am on the tutorialsninja login page
    When I input a valid email 'user@example.com' into the email field
    And I enter invalid password "incorrectPassword"
    And I click the login button
    Then I should see an error message about invalid credentials

  Scenario: Unsuccessful login with invalid email
    Given I am on the tutorialsninja login page
    When I enter invalid email into the email field
    And I input a valid password "Password123" into the password field
    And I click the login button
    Then I should see an error message about invalid credentials

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the tutorialsninja login page
    When I enter invalid email into the email field
    And I enter invalid password "incorrectPassword"
    And I click the login button
    Then I should see an error message about invalid credentials
