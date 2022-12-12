Feature: Place the order for Products

  Scenario Outline: Experience for product order

    Given User is on GreenCart landing page
    When user searched with Shortname <Name> and extracted actual name of product
      And added 3 items of the selected product to cart
    Then user proceds to Checkout and validate the <Name> items in checkout page 
      And verify user has ability to enter promo code and place the order

    Examples:
    | Name |
    | Tom  |
