Feature: Login
  Scenario: Login with invalid credentials
    Given user loads a Flights Page
    And click the Account Button
    And Click the Sign In Button
    When user sends login and password
    And click Sign In button on the Login Page
    Then Login Error is Displayed