Feature: Amazon user flow without login

  Scenario: Verify Amazon flow without login

    Given User is on Amazon home page
    When User clicks on "Today's Deals"
    And User selects product number 3
    And User adds the product to cart
    Then Cart quantity should be updated

    When User searches for product "Mobiles"
    Then User prints the last product from results

    When User navigates using menu
    And User returns to home page