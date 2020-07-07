Feature: Verify Demo QA Website

  @Demo
  Scenario: Verify Text Box functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Text Box
    And User enters "Test User" "test@gmail.com" "123 Main St, NY" all the details and click on Submit button
    Then Verify Text Box contents displayed correctly

  @Demo
  Scenario: Verify Check Box functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Check Box
    And User clicks on Toggle and select Downloads check box
    Then Verify "downloads" check box is selected

  @Demo
  Scenario: Verify Radio Button functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Radio Button
    And User clicks on Impressive radio button
    Then Verify "Impressive" radio box is selected

  @Demo
  Scenario: Verify Web Tables functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Web Tables
    And User clicks on sort by First Name
    Then Verify First Name are sorted in ascending order

