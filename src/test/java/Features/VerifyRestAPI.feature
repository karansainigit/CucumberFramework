@Rest
Feature: Verify Rest API

  Scenario: Verify Post requests for Authorized, GenerateToken and User
    Given BaseURL "https://demoqa.com/Account/v1" is set
    And Username "TOOLSQA-Test" and Password "Test@@123" for the request body
    When Post Authorized request is made
    And Post GenerateToken request is made
    And Post User request is made
    Then Verifying the status of these request