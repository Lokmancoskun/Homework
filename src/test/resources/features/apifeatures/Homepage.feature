@Regression @Api
Feature: Homepage API test

  @HomeApi
  Scenario: validation of home "hello world!" text

    Given user sets base url on homepage
    Then user validates status code
