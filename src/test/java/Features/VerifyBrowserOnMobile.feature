@MobileBrowser
Feature: Verify MakeMyTrip on Mobile Browser

  Scenario: One Way trip search
    Given User navigates to "https://www.makemytrip.com/flights/" url on mobile
    When User clicks on One Way search
    And User Enter From "delhi" and To "goa" city
    And User selects Date of travel