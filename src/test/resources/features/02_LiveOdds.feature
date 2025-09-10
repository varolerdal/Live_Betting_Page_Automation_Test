@Test
Feature: Validate Live Odds Updates

  Scenario: Odds change in real time during a live event
    Given I am on the Live Betting page
    When I select Table Tennis live events
    Then I view the first live event, wait until the odds update and verify it
    And the odds update indicators should be visible