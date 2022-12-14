# -- FILE: features/Cart.feature
Feature: User experience with Cart

  @Cart
  Scenario: The cart is initially empty
    Given User is on GreenCart landing page
    When user inspect the cart
    Then verify the cart is empty

  @Cart
  Scenario Outline: Add product to cart
    Given User is on GreenCart landing page
    When user searched with Shortname <Name> and extracted actual name of product
      And added 4 items of the selected product to cart
    Then verify user has ability to checkout order

  Examples:
  | Name |
  | Cucum  |
  | Carrot  |