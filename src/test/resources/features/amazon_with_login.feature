Feature: Amazon logged-in user flow

  Scenario: Verify Amazon complete flow after login

    Given User is logged into Amazon
    When User clicks on "Today's Deals"
    And User selects "Prime Exclusive" filter
    And User selects product number 1
    Then Delivery date should be displayed

    When User navigates to past orders for year "2025"
    And User navigates to Your Addresses page
    And User adds a new address with following details
      | name         | Mariyappan |
      | phone        | 9876543210 |
      | pincode      | 600052 |
      | addressLine  | No.762, 1st Main Road, Solaiamman Nagar, Redhills |
      | city         | chennai |

    Then Address "Mariyappan" should be added successfully

    When User searches for product "Books"
    And User selects Prime Reading eligible filter
    And User selects first product from search result