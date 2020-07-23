@Book
Feature: Verify Book Store Application

  Scenario: Verify Login functionality in Book Store Application
    Given User opens Book Store Application "https://demoqa.com/books"
    When User clicks on Login
    And User enters Username "karansaini" and Password "Password@2020!"
    And User clicks on Login to sign in
    Then User should be successfully Signed In

  Scenario: Verify Selecting Book in Book Store Application
    Given User opens Book Store Application "https://demoqa.com/books"
    When User selects "Speaking JavaScript" book from the list
    Then Details about the book "Speaking JavaScript" should be displayed

  Scenario: Adding book to your collection and deleting it
    Given User opens Book Store Application "https://demoqa.com/books"
    When User clicks on Login
    And User enters Username "karansaini" and Password "Password@2020!"
    And User clicks on Login to sign in
    And User selects "Speaking JavaScript" book from the list
    And User Click on Add to your Collection
    Then User go to Profile and verify Book "Speaking JavaScript" should be added in collection
    And User delete the book from collection
    And Verifying that book is deleted successfully
    And User Log Out from Book Store

