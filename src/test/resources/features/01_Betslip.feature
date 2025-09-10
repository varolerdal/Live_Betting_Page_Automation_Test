@Test
Feature: Adding pick to Betslip

  Scenario: User adds a pick to Betslip from Event View
    Given I am on the Live Betting page
    When I navigate to the Event View page
    And I add a pick to the Betslip
    Then The pick should be visible in the Betslip
    And The pick should be highlighted