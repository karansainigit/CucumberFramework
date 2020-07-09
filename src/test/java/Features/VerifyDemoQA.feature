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

  @Demo
  Scenario: Verify Buttons functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Buttons
    And User double clicks, right clicks and clicks on buttons
    Then Verify Clicks are done correctly

  @Demo
  Scenario: Verify API Links functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Links
    And User clicks on all the links that will send API call
    Then Verify correct call is being made

  @Demo
  Scenario: Verify New Tab Links functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Links
    And User clicks on all the links that will open new tab
    Then Verify title of the new tabs

  @Demo
  Scenario: Verify Download functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Upload and Download
    And User clicks on Download link
    Then Verify file is downloaded

  @Demo
  Scenario: Verify Upload functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Upload and Download
    And User clicks on Choose File link and selects file to be uploaded
    Then Verify file is uploaded successfully