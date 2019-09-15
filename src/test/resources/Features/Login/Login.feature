@VSD-1
Feature: Login Feature

  @VSD-3
  Scenario: Login with Username and Password Story happy path
    Given the system is running at "http://demo.viosystems.com/EnterUsername"
    When the user submits valid username and password credentials
    Then I expect them to be authenticated and allowed access to their profile

  @VSD-3
  Scenario: Login with Username and Password Story invalid credentials
    Given the system is running at "http://demo.viosystems.com/EnterUsername"
    When the user submits unknown username and password credentials
    Then I expect them to be denied access

