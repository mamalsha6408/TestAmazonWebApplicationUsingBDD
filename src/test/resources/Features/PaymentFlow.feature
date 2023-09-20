Feature: Feature to test payment flow

  @checkout
  Scenario: logged user add item to cart and proceed checkout with invalid credit card details

    Given user signin
    And logged user in amazon index page
    And user enter item name in search field and search
    |bluetooth speaker  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    When user click proceed to buy button
    And user navigate to Checkout Page
    And user click Add new address link
    And user select country in delivery address popup form
    And user enter name in delivery address popup form
    And user enter mobile in delivery address popup form
    And user enter pincode in delivery address popup form
    And user enter address line one in delivery address popup form
    And user enter address line two in delivery address popup form
    And user enter landmark in delivery address popup form
    And user enter city in delivery address popup form
    And user select state in delivery address popup form
    Then user click use this address button in delivery address popup form
    When user clcik credit card radio button
    And user click enter credit card details link
    And user enter invalid card number in credit card popup form
    And user enter card holder name in credit card popup form
    And user select month in credit card popup form
    And user select year in credit card popup form
    Then user click enter card details button
    And user got error message

