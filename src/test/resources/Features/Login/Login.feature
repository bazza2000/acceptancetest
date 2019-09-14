@JIRA-222
Feature: Login Feature

  @JIRA-123
  Scenario: Login with Username and Password Story
    Given the system is running at "http://demo.viosystems.com/EnterUsername"
    When the user submits the credentials for user "Jim Lack"
    Then I expect them to be shown the profile for "Jim"


