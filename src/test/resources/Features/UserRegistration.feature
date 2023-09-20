Feature: feature to test user registration
  @tag1
  Scenario: check user registartion with valid details

    Given user in amazon user registration page
    And user enter name
    And user select country code
    And user enter mobile no
    And user enter valid email
    And user enter password
    When user clcik continue button
    Then user should navigate to next window


  Scenario: validate user registration required fields

    Given user in amazon user registration page
    When user clcik continue button
    Then error message should displayed under the username
    And error message should displayed under the mobile number
    And error message should displayed under the password