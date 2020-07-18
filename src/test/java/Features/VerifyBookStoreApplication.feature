@Book
Feature: Verify Book Store Application

  Scenario: Verify Login functionality in Book Store Application
    Given User opens Book Store Application "https://demoqa.com/books"
    When User clicks on Login
    And User enters Username "karansaini" and Password "Password@2020!"
    And User clicks on Login to sign in
    Then User should be successfully Signed In