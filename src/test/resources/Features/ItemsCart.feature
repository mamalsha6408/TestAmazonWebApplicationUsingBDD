@testCart
Feature: feature to test cart related functions

  @testCartNoUser
  Scenario: search item and add to cart and remove
    Given user in amazon index page
    And user enter item name in search field and search
      |Portable Keyboard  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    And user close cartPage and navigate to searchPage

    And user enter item name in search field and search
      |Portable Speaker  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    And user close cartPage and navigate to searchPage

    And user enter item name in search field and search
      |1TB portable hard  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    And print all the cart items
    And user delete first item from cart item list
    And print all the cart items
    And user close cartPage and navigate to searchPage


  @testCartWithUser
  Scenario: logged user perform search items, add to cart and remove item

    Given user signin
    Given logged user in amazon index page
    And user enter item name in search field and search
      |Portable Keyboard  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    And user close cartPage and navigate to searchPage

    And user enter item name in search field and search
      |Portable Speaker  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    And user close cartPage and navigate to searchPage

    And user enter item name in search field and search
      |1TB portable hard  |
    And user navigate to search result page
    When user select first item from search result
    And user navigate to selected item page
    And user click add to cart button
    Then user click cart button to navigate cart
    And validate added item is present in cart
    And print all the cart items
    And user delete first item from cart item list
    And print all the cart items
    And user close cartPage and navigate to searchPage