Feature: Mobile Test Cases

  @Mobile,@Animation
  Scenario: Verify Bouncing Balls in APIDemos apk - Animation
    Given User is on home screen and clicks on Animation
    When User clicks on Bouncing Balls
    Then Bouncing Balls are displayed

  @Mobile,@App
  Scenario: Verify Alert Dialogs-Single choice list in APIDemos - App
    Given User is on home screen and clicks on App
    When User clicks on Alert Dialogs
    And User clicks on Single choice list and choose Traffic
    Then Traffic should be selected

  @Mobile,@App
  Scenario: Verify Alert Dialogs-Ultra long message in APIDemos - App
    Given User is on home screen and clicks on App
    When User clicks on Alert Dialogs
    And User clicks on Ultra long message and swipe till last
    Then User clicks on Ultra long message OK

  @Mobile,@App
  Scenario Outline: Verify Alert Dialogs-Text Entry dialog in APIDemos - App
    Given User is on home screen and clicks on App
    When User clicks on Alert Dialogs
    And User clicks on Text Entry dialog and enter <name> , <password>
    Then User clicks on Text Entry dialog OK
    Examples:
      | name     | password |
      |username1 | password1|
      |username2 | password2|

