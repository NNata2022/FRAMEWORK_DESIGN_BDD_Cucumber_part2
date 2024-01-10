@TutorialNinjaRegister
Feature: Registration on Tutorialsninja website
  As a new user
  I want to register an account on tutorialsninja.com
  So that I can access exclusive features available to registered users

 @MandatoryFields
  Scenario: Successful registration with valid details
  Given I am on the tutorialsninja registration page
    When I enter below valid registration details
    |firstname 			| Nataliia			|
    |lastname				| Chicago				|
    |telephone			| 7765663333 		|
    |password				| Nataliia@123 	|
    |confirmpassword| Nataliia@123 	|
    And I agrees to the Privacy Policy by checking the box
    When I submits the registration by clicking the Continue button
    Then I should see a confirmation message for successful registration


 @AllFields
  Scenario: Register with all fields
  Given I am on the tutorialsninja registration page
    When I enter below all fields
    |firstname 			| Nataliia			|
    |lastname				| Chicago				|
    |telephone			| 7765663333 		|
    |password				| Nataliia@123 	|
    |confirmpassword| Nataliia@123 	|
    And I selects yes to subscribe to the newsletter
    And I agrees to the Privacy Policy by checking the box
    When I submits the registration by clicking the Continue button
    Then I should see a confirmation message for successful registration

    
 
 
  @DuplicateEmail
  Scenario: Register with existing email
  Given I am on the tutorialsninja registration page
    When I enter below all fields with existing email
    |firstname 			| Nataliia	 						|
    |lastname				| Chicago	 							|
    |email 					|nagulanata@gmail.com   |
    |telephone			| 7765663333						|
    |password				| Nataliia@123 					|
    |confirmpassword| Nataliia@123 					|
    And I selects yes to subscribe to the newsletter
    And I agrees to the Privacy Policy by checking the box
    When I submits the registration by clicking the Continue button
    Then I should see warning message of duplicate email  
 
 
  @NoFields
  Scenario: Registration with missing mandatory fields
  Given I am on the tutorialsninja registration page
    When  I submits the registration by clicking the Continue button
    Then I should see error messages for each mandatory field
    