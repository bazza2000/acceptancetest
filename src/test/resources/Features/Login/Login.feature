@JIRA-222
Feature: Login

  @JIRA-123
  Scenario: Login with Username and Password
    Given the system is running at "https://vio"
    When the user enters the credentials for user "Jim Lack"
    Then I expect to be greeted with "Hello Jim"


