Feature: Mobile Test Cases

  @Mobile
  Scenario: Verify Bouncing Balls in APIDemos apk
    Given User is on home screen and clicks on Animation
    When User clicks on Bouncing Balls
    Then Bouncing Balls are displayed