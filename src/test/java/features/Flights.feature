Feature: Flights

  Scenario: User can switch to One way flights
    Given Flights Page is loaded
    When click the One Way tab
    Then returning Data Field becomes invisible

  Scenario: Typing the first letter into Fly From Filed user gets ten auto suggestions
    Given Flights Page is loaded
    When user types first letter into Fly From field
    Then amount of auto suggestions equals to ten