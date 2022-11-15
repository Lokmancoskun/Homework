@Regression @Api
Feature: Login API test

  @LoginApi
  Scenario Outline: validation of login functionality

    Given user sets pathparams for login page
    When user logs in with credentials "<email>", "<password>"
    And user sends the POST request and gets the login token
    Then user validates post request status code
    When user sends GET request for all profile information
    And user sends POST request to create notes
    And user sends GET request to get noteID
    Then user sends POST request for searching relevant notes

    Examples:
      | email           | password                       |
      | tester@shair.co | secure-password-for-assessment |





