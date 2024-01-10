@TutorialNinjaLogout
Feature: Logout functionality on Tutorialsninja website

As a  user of TutorialsNinja i should log in to my account 

  I want to be able to log out of my account
  So that I can ensure my account security when I'm not using the site


  @LogoutRightbottomCornerOption  
  Scenario: Successful logout from Right buttom Corner Options
    Given I am logged into the TutorialsNinja website with email "nagulanata@gmail.com" and password "Nataliia@123"
    When I click on the logout button from Right Corner 
    Then I should be logged out of the system and redirected to the Logoutpage 
   
  
   