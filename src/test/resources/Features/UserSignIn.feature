Feature: feature to test user sign in

  Scenario: check sign in function with valid details

    Given user in amazon signin page
    And user enter user email
    When user click button continue
    And user enter user password
    When user click button signin
    Then user navigate to home page