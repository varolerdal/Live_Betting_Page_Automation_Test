@Test
Feature: Responsive Design Testing of Live Betting Page

  Scenario Outline: Verify Live Betting Page running on desktop viewport
    Given I am on the Live Betting page
    When I set the browser viewport to "<device>"
    And bwin logo, Register button and Log In button should be visible for "<device>"
    And The navigation menu buttons should be visible for "<device>"

    Examples:
      | device   |
      | desktop  |
      | mobile   |