Feature: Flights

  Scenario: User can switch to One way flights
    Given Flights Page is loaded
    When click the One Way tab
    Then returning Data Field becomes invisible

  Scenario: Typing the first letter into Fly From Filed user gets ten auto suggestions
    Given Flights Page is loaded
    When user types "k" into Fly From field
    Then amount of auto suggestions equals to ten

  Scenario: Last auto suggestion for a Fly From field starts from the entered letter
    Given Flights Page is loaded
    When user types "S" into Fly From field
    And choose last value from auto suggestion
    And click Space button
    Then value chosen filled into Fly From field starts from "S"

  Scenario: After clicking Departing Data a Calendar is displayed
    Given Flights Page is loaded
    When user clicks Departing Data
    Then Calendar is displayed

  Scenario: After clicking Close button on the Calendar user Calendar disappears
    Given Flights Page is loaded
    When user clicks Departing Data
    And clicks Close button
    Then Calendar is not displayed

  Scenario: Three groups are displayed in Traveler Dropdown
    Given Flights Page is loaded
    When user clicks Traveler Dropdown
    Then Three Traveler groups are displayed

  Scenario: After adding child Traveler in Traveler Dropdown child Age dropdown displayed
    Given Flights Page is loaded
    When user clicks Traveler Dropdown
    And clicks Add child button
    Then Child age button dropdown is displayed
Scenario: Child Age dropdown contains all child ages
  Given Flights Page is loaded
  When user clicks Traveler Dropdown
  And clicks Add child button
  Then ChildAge Dropdown contains all child ages
  Scenario: After loading Flights page Car checkbox is not selected
    Given Flights Page is loaded
    When User doesn't select anything
    Then Add Car checkbox is not selected
    Scenario: after checking Add Car checkbox Save Message is displayed
      Given Flights Page is loaded
      When check Add Car checkbox
      Then Save Message is Displayed