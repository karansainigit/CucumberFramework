@Web
Feature: Verify Home Page

  Scenario: Verify Home Page Title
    Given Navigate to "http://live.demoguru99.com/index.php/" website
    Then Verify Home Page title is "Home page"

  Scenario: Verify Home Page Default Welcome Message
    Given Navigate to "http://live.demoguru99.com/index.php/" website
    Then Verify Default Welcome Message is "DEFAULT WELCOME MSG"