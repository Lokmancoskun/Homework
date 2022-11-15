@Regression
@loginUI
Feature: Login functionality
  Scenario: Login as a user
    Given user is on homepage
    When user clicks on home
    And user verifies testing! text is visible
    And user verifies Hello world! text is visible
    And user clicks on login
    And user logs in with credentials
    And user clicks on search
    And user makes search
    And user clicks on object table

