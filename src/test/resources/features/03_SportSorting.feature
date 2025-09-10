@Test
Feature: Sport Sorting

  Scenario: User selects a sport from A-Z list
    Given I am on the Live Betting page
    When I open the A-Z Sports list
    Then I select the sport Formula 1
    And Formula 1 tab should be highlighted
    And The URL should indicate Formula 1
