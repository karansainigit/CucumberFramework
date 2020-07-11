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

  @Demo
  Scenario: Verify Dynamic Properties functionality
    Given User navigates to "https://demoqa.com/elements" website
    When User clicks on Dynamic Properties
    Then Verify the dynamic properties of the elements

  @Demo
  Scenario: Verify Practice Form functionality
    Given User navigates to "https://demoqa.com/forms" website
    When User clicks on Practice Form
    And User fills the Practice Form
    And Clicks on Submit button
    Then Verify form is successfully submitted

  @Demo
  Scenario: Verify Browser Windows functionality
    Given User navigates to "https://demoqa.com/alertsWindows" website
    When User clicks on Browser Windows
    And User clicks on New Tab and verify the text
    And User clicks on New Window and verify the text
    And User clicks on New Window Message and verify the message

  @Demo
  Scenario: Verify Alerts functionality
    Given User navigates to "https://demoqa.com/alertsWindows" website
    When User clicks on Alerts
    And User clicks on First Alert and verify the text
    And User clicks on Second Alert and verify the text
    And User clicks on Third Alert and verify the text
    And User clicks on Fourth Alert and verify the text

  @Demo
  Scenario: Verify Frames functionality
    Given User navigates to "https://demoqa.com/alertsWindows" website
    When User clicks on Frames
    Then User verifies sample text in each frame

  @Demo
  Scenario: Verify Modal Dialogs functionality
    Given User navigates to "https://demoqa.com/alertsWindows" website
    When User clicks on Modal Dialogs
    And User clicks on Small Modal and verify the text
    And User clicks on Large Modal and verify the text

  @Demo
  Scenario: Verify Accordian functionality
    Given User navigates to "https://demoqa.com/widgets" website
    When User clicks on Accordian
    And User clicks any tab
    Then Appropriate text should be displayed

  @Demo
  Scenario: Verify Auto Complete functionality
    Given User navigates to "https://demoqa.com/widgets" website
    When User clicks on Auto Complete
    And User enters colors "Red" , "Black" and "Purple"
    Then Appropriate color should be selected

  @Demo
  Scenario: Verify Date Picker functionality
    Given User navigates to "https://demoqa.com/widgets" website
    When User clicks on Date Picker
    And User selects Date "21" Month "June" and Year "2021"
    And User enters Month "December" Date "25" and Time "20:00"
    Then Selected Date "06/21/2021" and entered Date and Time "December 25, 2020 8:00 PM" should be displayed