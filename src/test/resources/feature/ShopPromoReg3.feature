# feature/ShopPromoReg3.feature
Feature: Shop Promo Reg 3
@ShoppingCart

Scenario Outline: Promo Test 3
    Given customer logged in
    When customer bought <count> Unlimited 1GB Sims
    And customer bought <count_2gb> Unlimited 2GB Sims
    Then the customer will pay only <total_price> for total price
    And the customer will have free <free_item_count> <free_item>

    Examples:
    | count | count_2gb | total_price | free_item | free_item_count |
    | 1     | 2         | 84.70       | 1gb       | 2               |
