@smoke_test
Feature:

  Background: chrome testing
    Given user test with "chrome" browser

  @unit_test
  @regression_test
  Scenario: User goes to Autotrader Website
    Given User is in landing page
    Then Verify that "Browse by Make" are present
    Then Verify that "Browse by Style" are present
    Then Verify that "Advanced Search" are present
    And verify that search button is present.
    Then verify that "Any Make" and "Any Model" is visible


  @integration_test
  Scenario: User checks the Advance search link
    Given User click Advance Search link on the home page
    Then User enter "30004" in the zip code text box
    Then User select "Certified" check box under "Condition"
    Then User select "Convertible" check box under "Style"
    Then user update Year "2017" to "2020"
    Then user select "BMW" car from Make,Model and Trim section
    Then User clicks Search button
    Then User verifies that he is in result page
    Then User verifies that he sees only "BMW" cars in listing
    Then Display in console, the number of cars listed in result page

  Scenario Outline: testin the multiple entry
    Given choose make as "<model>"
     Examples:
      | model    |
      | BMW      |
      | Auidi    |
      | Mercedes |
      | Toyota   |
      | Acura    |
      | BMW      |
      | Auidi    |
      | Mercedes |
      | Toyota   |
      | Acura    |


